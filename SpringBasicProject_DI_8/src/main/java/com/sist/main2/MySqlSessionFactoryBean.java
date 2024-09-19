package com.sist.main2;

import javax.inject.Qualifier;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{
	@Autowired // �ڵ� ����
	public MySqlSessionFactoryBean(DataSource dataSource) {
		setDataSource(dataSource);
		
	}
}
