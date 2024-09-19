package com.sist.main2;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;


@Component("ds")
public class MyBasicDataSource extends BasicDataSource{
	public MyBasicDataSource() {
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
	}
}
