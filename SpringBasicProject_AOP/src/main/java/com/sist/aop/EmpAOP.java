package com.sist.aop;
import java.util.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
@Component
public class EmpAOP {
	@Autowired
	private EmpDAO dao;
	// ���۰� ���ÿ� ó�� => ���������� ���
	/*
	 * public void insert(){
	 * 	SqlSession session=null;
	 * 	try{
	 * 		session=ssf.openSession()
	 * 		session.insert("id")
	 * 	}catch(Exception ex){
	 * 		ex.printStackTrace() => afterThrowing
	 * 	}
	 * 	finally{
	 * 		if(session!=null) => after
	 * 			session.close()
	 * 	}
	 */
	@Before("exextion(* com.sist.dao.EmpDAO.emp*(..))")
	// try ù��°��
	public void getConnection(){
		dao.getConnection();
	}
	
	@After("exection(* com.sist.dao.EmpDAO.emp*(..))")
	public void disConnection() {
		dao.disConnection();
	}
	
	
	
	@Around(value = "exection(* com.sist.dao.EmpDAO.emp*(..))")
	public Object log(ProceedingJoinPoint jp) {
		Object obj=null;
		try {
			
			long start=System.currentTimeMillis();
			obj = jp.proceed();
			System.out.println("ȣ��� �޼ҵ� : "+jp.getSignature().getName() );
			long end=System.currentTimeMillis();
			System.out.println("�ҿ�ð� : "+(end-start));
		}catch(Throwable ex) {}
		return obj;
	}
	
	
	// ���� ���� => return ���� �޾Ƽ� ó�� 
	@AfterReturning(value="execution(* com.sist.dao.EmpDAO.emp())",returning="obj")
	public void AfterReturning(Object obj) {
		List<EmpVO> list = (List<EmpVO>)obj;
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getHiredate().toString()+" "
					+vo.getSal());
			
		}
	}
	
	// catch ����
	@AfterThrowing(value="exection(* com.sist.dao.EmpDAO.*(..))", throwing="obj")
	public void afterThrowing(Throwable ex) throws Throwable{
		System.out.println("==== ���� �߻� ====");
		ex.printStackTrace();
	}
}























