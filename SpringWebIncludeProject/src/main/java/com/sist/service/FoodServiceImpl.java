package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 *    JSP = Controller = Service = Repository = 오라클 
 *                     =         =            =
 */
@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    private FoodDAO dao;

	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return dao.foodListData(map);
	}
	
	@Override
	public int foodRowCount() {
		// TODO Auto-generated method stub
		return dao.foodRowCount();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}


	@Override
	public FoodVO foodCookieInfoData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodCookieInfoData(fno);
	}

}
