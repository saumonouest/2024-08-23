package com.sist.dao;

public class MyDAO {
	public void getConnection() {
		System.out.println("����Ŭ ����");
	}
	
	public void disConnection() {
		System.out.println("����Ŭ ����");
	}
	
	public void select() {
		//getConnection();
		System.out.println("SELECT ���� ó�� ");
		//disConnention();
		
	}
	public void insert() {
		//getConnection();
		System.out.println("insert ���� ó�� ");
	}
	public void update() {
		//getConnection();
		System.out.println("update ���� ó�� ");
	}
	public void delete() {
		//getConnection();
		int a = 10/0;
		System.out.println("a="+a);
		System.out.println("delete ���� ó�� ");
	}
	
	public String find(String fd) {
		return fd+"ã�� �Ϸ�";
	}
	

}
