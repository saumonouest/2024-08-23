package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
/*
 * @Component => @Target(value={TYPE})
 * 				======================= class 구분자
 * @Repository => @Target(value={TYPE})
 * 
 * @Autowired => @Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
 * 
 * class A {
 * @Autowired
 * 	private B b; => FIELD (멤버변수)
 * 
 * @Autowired
 * 	public A(B b){ => CONSTRUCTOR
 * 		this.b=b
 * }
 * 
 * @Autowired => ANNOTATION_TYPE
 * @Qualifier("mysql")
 * public void setB(@Autowired B b){ => METHOD
 * 		this.b=b	ㄴPARAMETER
 * }
 * 
 * 	=> 어노테이션 
 * 	 1. 구분자 (인덱스)
 * 		클레스 : TYPE
 * 		매개변수 : PARAMETER
 * 		생성자 : CONSTRUCTOR
 * 		메소드 : METHOD	
 */
@Component("mc")
public class MainClass2 {
	@Autowired // 자동으로 스프링에 같은 객체를 찾아서 주소값 대입
	@Qualifier("mysql") // 선택 => 객체 지정 (여러개 있는 경우에 한 개 선택)
	// @Resource(name="mysql") => @Autowired+@Qualifier
	private MyDAO dao;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("application-*.xml");
		MainClass2 mc=(MainClass2)app.getBean("mc");
		mc.dao.Connection();
	
	}

}
