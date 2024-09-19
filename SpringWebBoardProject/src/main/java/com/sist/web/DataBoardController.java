package com.sist.web;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.*;
import com.sist.vo.BoardVO;
import com.sist.vo.DataBoardVO;
import java.net.*;

@Controller
@RequestMapping("databoard/") // 공통으로 사용되는 URL 주소를 모아서 => 적용
public class DataBoardController {
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private DataBoardDAO dao;
	
	// 사용자 요청에 대한 처리
	@GetMapping("list.do")
	public String databoard_list(String page, Model model) {
		String en=encoder.encode("1234");
		System.out.println(en);
		if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   int rowSize=10;
		   int start=(rowSize*curpage)-(rowSize-1);
		   int end=rowSize*curpage;
		   List<BoardVO> list=dao.databoardListData(start, end);
		   // 총페이지 
		   int count=dao.databoardRowCount();
		   int totalpage=(int)(Math.ceil(count/(double)rowSize));
		   count=count-((rowSize*curpage)-rowSize);
		   // 사용자로부터 받는 값 => Model : 결과값 전송 객체 
		   // 출력에 필요한 데이터를 list.jsp로 전송 
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);
		   model.addAttribute("count", count);
		   model.addAttribute("list", list);
		   
		   return "databoard/list";
	}
	// 데이터 추가
	@GetMapping("insert.do")
	public String databoard_insert() {
		return "databoard/insert";
	}

	// 실제 데이터 첨부
	@PostMapping("insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo) {
		String en=encoder.encode(vo.getPwd()); // 암호화
		vo.setPwd(en);
		String path="c:\\spring_upload";
		List<MultipartFile> list = vo.getFiles();
		if(list==null) {
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}
		else { // 업로드가 있는 경우 
			try {
			String filename="";
			String filesize="";
			for(MultipartFile mf:list) {
				String name=mf.getOriginalFilename(); // 사용자가 보내준 파일명
				File file = new File(path+"\\"+name);
				mf.transferTo(file); // 파일 업로드
				filename+=file.getName()+",";
				filesize+=file.length()+",";
				
			}
			filename=filename.substring(0,filename.lastIndexOf(","));
			filesize=filesize.substring(0,filename.lastIndexOf(","));
			vo.setFilename(filename);;
			vo.setFilesize(filesize);;
			vo.setFilecount(list.size());
		}catch (Exception e) {}
	}
		dao.databoardInsert(vo);
		return "redirect:list.do";
	}
	
	// 상세보기
	@GetMapping("detail.do")
	public String databoard_detail(int no, Model model) {
		DataBoardVO vo =dao.databoardDetailData(no);
		if(vo.getFilecount()!=0) {
				
			List<String> nList=new ArrayList<String>();
			List<String> cList=new ArrayList<String>();
			String [] names=vo.getFilename().split(",");
			String [] lens=vo.getFilesize().split(",");
			nList=Arrays.asList(names);
			cList=Arrays.asList(lens);
			// 배열 => List로 변경
			
			model.addAttribute("nList", nList);
			model.addAttribute("cList", cList);
		}
		model.addAttribute("vo", vo);
		
		return "databoard/detail";
	}
	// 다운로드
	@GetMapping("download.do")
	public void databoard_download(String fn, HttpServletResponse response) {
		try {
			String path="c:\\spring_upload";
			// 서버에서 파일을 읽어서 한 개의 메모리에 저장 => 속도를 빠르게 
			BufferedInputStream bis=
					new BufferedInputStream(new FileInputStream(path+"\\"+fn));
			// 다운로드 요청한 클라이언트
			BufferedOutputStream bos =
					new BufferedOutputStream(response.getOutputStream());
			
			// 1. 다운로드 창을 보여준다
			response.setHeader("Content-Disposition", "attachment;filename="
					+URLEncoder.encode(fn,"UTF-8"));
			File file = new File(path+"\\"+fn);
			response.setContentLength((int)file.length()); // 프로그래스바
			
			// 실제 다운로드 
			byte[] buffer = new byte[1024]; // TCP:1024, UDP : 512
			int i=0; // 파일에서 읽은 바이트 크기
			while((i=bis.read(buffer,0,1024))!=-1) {
				// -1 : EOF
				bos.write(buffer,0,i);
			}
			bis.close();
			bos.close();
		}catch(Exception ex) {}
	}
	
	@GetMapping("delete.do")
	public String databoard_delete(int no, Model model) {
		model.addAttribute("no", no);
		return "databoard/delete";
	}
	
	   @PostMapping("delete_ok.do")
	   public String databoard_delete_ok(int no,String pwd,Model model)
	   {
		   DataBoardVO vo=dao.databoardFileInfoData(no);
		   boolean bCheck=dao.databoardDelete(no, pwd);
		   model.addAttribute("bCheck", bCheck);   
		   try
		   {
			   String files=vo.getFilename();
			   if(vo.getFilecount()!=0) // 파일이 있는 경우 
			   {
				   StringTokenizer st=new StringTokenizer(files,",");
				   while(st.hasMoreTokens())
				   {
					   File file=new File("c:\\spring_upload\\"+st.nextToken());
					   file.delete();
				   }
			   }
		   }catch(Exception ex) {}
		   return "databoard/delete_ok";
		
	   }
}


















