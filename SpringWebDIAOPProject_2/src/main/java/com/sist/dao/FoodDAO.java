package com.sist.dao;
import java.util.*;
public class FoodDAO {
	public List<FoodVO> foodListData(int start, int end){
		return mapper.foodListData(start, end)
	}
}
