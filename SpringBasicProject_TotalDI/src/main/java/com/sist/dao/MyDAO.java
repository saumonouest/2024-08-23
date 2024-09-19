package com.sist.dao;

public class MyDAO {
	public void getConnection() {
		System.out.println("오라클 연결");
	}
	
	public void disConnection() {
		System.out.println("오라클 해제");
	}
	
	public void select() {
		//getConnection();
		System.out.println("SELECT 문장 처리 ");
		//disConnention();
		
	}
	public void insert() {
		//getConnection();
		System.out.println("insert 문장 처리 ");
	}
	public void update() {
		//getConnection();
		System.out.println("update 문장 처리 ");
	}
	public void delete() {
		//getConnection();
		int a = 10/0;
		System.out.println("a="+a);
		System.out.println("delete 문장 처리 ");
	}
	
	public String find(String fd) {
		return fd+"찾기 완료";
	}
	

}
