package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
@Repository
public class EmpDAO {
	private MyDataSource ds;
	private Connection conn;
	private PreparedStatement ps;
	
	@Autowired
	public EmpDAO(MyDataSource ds) {
		this.ds=ds;
		try {
			Class.forName(ds.getDriver());
		}catch(Exception ex) {}
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(ds.getUrl(),ds.getUsername(),ds.getPassword());
		}catch (Exception e) {}
	}
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch (Exception e) {}
	}
	
	// 기능 설정 
	public List<EmpVO> empListData(){
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			String sql="SELECT empno, job, TO_CHAR(hiredate, 'YYYY-MM-DD'), sal "
					+ "FROM emp ORDER BY empno ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setSal(rs.getInt(5));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		/*finally {
			AOP => disConnection() ==> After
		}*/
		return list;
	}
	
	public EmpVO empDetailData(int empno) {
		EmpVO vo = new EmpVO();
		try {
			String sql="SELEC empno, ename, job, hiredate, sal "
					+ "FROM emp WHERE empno="+empno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getInt(5));
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
}
