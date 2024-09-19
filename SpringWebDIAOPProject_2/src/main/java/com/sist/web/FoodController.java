package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

// Model => 사용자 요청 처리 => 사용자 정의 ~Model, 스프링 => ~Controller, 스트럿츠 => ~Action

@Controller
public class FoodController {

	@GetMapping("list.do")
	public String food_list(String page, Model model) {
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		List<FoodVO> list =dao.foodListData(start, end);
		int totalpage=dao.foodTotalPage();
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		return "food/list";
	}
}
