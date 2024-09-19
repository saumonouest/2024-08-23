package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.dao.EmpDAO;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new AnnotationConfigApplicationContext("app.xml");
		EmpDAO dao = (EmpDAO)app.getBean("EmpDAO");
		dao.empListData();
	}

}
