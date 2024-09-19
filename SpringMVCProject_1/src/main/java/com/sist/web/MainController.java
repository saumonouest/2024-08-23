package com.sist.web;
/*
 * 				.do										
 * 													매개변수
 * 														=================
 *	브라우저 ============= DispatcherServlet ============= Model ======> Model 관리자 : HandlerMapping
 *							Controller					 처리
 *														=================
 *														   |
 *														=================
 *															JSP 관리 => JSP 찾아서 request 전송
 *														=================
 *														   |
 *														JSP로 전송 (View)
 *
 *	1. DispatcherServlet : 사용자의 요청을 받아서
 *						   처리할 데이터를 넘겨주는 역할
 *	
 *	2. HandlerMapping : DispatcherServlet으로부터 받은 데이터를 받아서
 *						처리 => request에 담아서 전송
 *
 *	3. ViewResolver : request를 받아서 JSP를 찾고 전송
 *
 *	4. View (JSP)
 */						
public class MainController {

}
