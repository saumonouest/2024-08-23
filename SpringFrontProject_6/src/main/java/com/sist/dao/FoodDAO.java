package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	public List<FoodVO> foodTypeListData(Map map) {
		return mapper.foodTypeListData(map);
	}
	
	public int foodTypeTotalPage(String type) {
		return mapper.foodTypeTotalPage(type);
	}
	
/*
	@Update("UPDATE project_food_house SET "
			+ "hit=hit+1 "
			+ "WHERE fno=#{fno}")
	public void hitIncrement(int fno);
	
	@Select("SELECT fno, name, type, phone, address, theme, poster, images, time,"
			+ "content, score "
			+ "FROM project_food_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);	
 */
	public FoodVO foodDetailData(int fno) {
		mapper.hitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	
	
/*
	@Select("SELECT fno, name, poster, rownum "
			+ "FROM(SELECT fno, name, poster "
			+ "FROM project_food_house "
			+ "WHERE address LIKE '%'||#{address}||'%' "
			+ "ORDER BY hit DESC) "
			+ "WHERE rownum<=5")
	public List<FoodVO> foodNearHouseData(String address);	
 */
	public List<FoodVO> foodNearHouseData(String address){
		return mapper.foodNearHouseData(address);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
