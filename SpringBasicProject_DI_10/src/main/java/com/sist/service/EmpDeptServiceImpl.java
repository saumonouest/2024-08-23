package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.EmpDAO;

@Service("eds")
public class EmpDeptServiceImpl implements EmpDeptService {
	@Autowired
	private EmpDAO edao;
	
	@Autowired
	private DeptDAO ddao;
	
	@Override
	public Lsit<EmpVO> empListData(){
		return edao.empListData();
	}
}
