package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MyDAO;

public class MainClass {
/*
 *	1. DI => 클래스와 클래스 연관 관계 : 메뉴얼 (동작) => 클래스 설정에 대한 정의
 *		1) XML 기반 : Spring4 => 전자정부 프레임워크 (실무)
 *		2) Annotation 기반 => 라이브러리 클래스 등록 시에 상속을 받아서 처리
 *							 =======
 *							 어노테이션 설정이 안 됨
 *		3) XML + Annotation 
 *		   ================ XML : 라이브러리 등록 시 (MyBatis, 보안)
 *				사용자 정의는 어노테이션으로 설정
 *				=> 프로젝트에서 공통 사용 => XML 
 *				=> 개발자마다 => 어노테이션으로 설정됨
 *		=============================================================
 *		4) 순수 자바만 이용
 *		===============
 *
 *		
 *		
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao=(MyDAO)app.getBean("dao");
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		String s=dao.find("Hello");
	}

}
