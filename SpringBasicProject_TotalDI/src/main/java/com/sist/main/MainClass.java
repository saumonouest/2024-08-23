package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MyDAO;

public class MainClass {
/*
 *	1. DI => Ŭ������ Ŭ���� ���� ���� : �޴��� (����) => Ŭ���� ������ ���� ����
 *		1) XML ��� : Spring4 => �������� �����ӿ�ũ (�ǹ�)
 *		2) Annotation ��� => ���̺귯�� Ŭ���� ��� �ÿ� ����� �޾Ƽ� ó��
 *							 =======
 *							 ������̼� ������ �� ��
 *		3) XML + Annotation 
 *		   ================ XML : ���̺귯�� ��� �� (MyBatis, ����)
 *				����� ���Ǵ� ������̼����� ����
 *				=> ������Ʈ���� ���� ��� => XML 
 *				=> �����ڸ��� => ������̼����� ������
 *		=============================================================
 *		4) ���� �ڹٸ� �̿�
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
