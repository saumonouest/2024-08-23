package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.EmpMapper;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	public List<EmpVO> empListData();
	public List<DeptVO> deptListData();
	
	
	
}
