package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

/*
 *	1. 스프링 = 프레임워크
 *		= 라이브러리 : 자주 사용되는 기능들을 모아서 미리 구현한 클래스의 집합
 *											==============
 *		= 프레임워크 : 미리 구현된 클래스의 집합
 *					기본 틀이 만들어져 있다
 *					====== 기본 틀에 맞게 구현
 *						   ======
 *							Controller => @GetMapping, @PostMapping 
 */

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.service.*;
import com.sist.vo.*;

@Aspect // 공통모듈 => 반복 제거 => 메모리 할당은 아님
@Component // 메모리 할당은 여기임
public class CommonsFooterAOP {
	@Autowired
	private RecipeService rService;
	
	// 수행되는 위치는 finally{메소드 수행} 부분 => 오류와 상관 없이 무조건 수행
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void commonsFooterData() {
		List<FoodVO> foodList=rService.foodTop5Data();
		List<RecipeVO> recipeList=rService.recipeTop5Data();
		
		// 전송 => request
		HttpServletRequest request=((ServletRequestAttributes)
				RequestContextHolder.getRequestAttributes()).getRequest(); // request 객체를 얻어올 때 사용하는 거 // 채팅할 떄 사용 가능?
		request.setAttribute("foodList", foodList);
		request.setAttribute("recipeList", recipeList);
		
	}
	
	
	
	
}
