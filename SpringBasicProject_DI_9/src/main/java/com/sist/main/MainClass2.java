package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
/*
 * @Component => @Target(value={TYPE})
 * 				======================= class ������
 * @Repository => @Target(value={TYPE})
 * 
 * @Autowired => @Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
 * 
 * class A {
 * @Autowired
 * 	private B b; => FIELD (�������)
 * 
 * @Autowired
 * 	public A(B b){ => CONSTRUCTOR
 * 		this.b=b
 * }
 * 
 * @Autowired => ANNOTATION_TYPE
 * @Qualifier("mysql")
 * public void setB(@Autowired B b){ => METHOD
 * 		this.b=b	��PARAMETER
 * }
 * 
 * 	=> ������̼� 
 * 	 1. ������ (�ε���)
 * 		Ŭ���� : TYPE
 * 		�Ű����� : PARAMETER
 * 		������ : CONSTRUCTOR
 * 		�޼ҵ� : METHOD	
 */
@Component("mc")
public class MainClass2 {
	@Autowired // �ڵ����� �������� ���� ��ü�� ã�Ƽ� �ּҰ� ����
	@Qualifier("mysql") // ���� => ��ü ���� (������ �ִ� ��쿡 �� �� ����)
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
