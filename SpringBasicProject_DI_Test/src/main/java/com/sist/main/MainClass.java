package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("app.xml");
		GoodsDAO dao=(GoodsDAO)app.getBean("dao");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("페이지 입력 : ");
		int page=scan.nextInt();
		
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		int totalpage=dao.goodsTotalPage();
		List<GoodsVO> list=dao.goodListData(start, end);
		
		for(GoodsVO vo:list) {
			System.out.println("업체 번호 : "+vo.getNo());
			System.out.println("업체명: "+vo.getGoods_name());
		}
		
	}
}
