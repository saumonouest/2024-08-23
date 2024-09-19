package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class CommonsException {

	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex) {
		System.out.println("데이터베이스 에러 발생");
		ex.printStackTrace();
		System.out.println("==================");
	}
	
	@ExceptionHandler(IOException.class)
	public void ioException(IOException ex) {
		System.out.println("파일 입출력 에러 발생");
		ex.printStackTrace();
		System.out.println("==================");
	}
	
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex) {
		System.out.println("실행시 에러 발생");
		ex.printStackTrace();
		System.out.println("==================");
	}
	
	@ExceptionHandler(Exception.class)
	public void Exception(Exception ex) {
		System.out.println("실행시 에러 발생");
		ex.printStackTrace();
		System.out.println("==================");
	}
	
}
