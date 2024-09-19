package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository("oracle")
public class MySQLDAO implements MyDAO{
	@Override
	public void Connection() {
		// TODO Auto-generated method stub
		System.out.println("MySQL ¿¬°á...");
	}

}
