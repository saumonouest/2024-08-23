package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository("dao")
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodListData(int start, int end){
		return mapper.goodsListData(start, end);
	}
	
	public int goodsTotalPage() {
		return mapper.goodsTotalPage();
	}
	
	public GoodsVO goodsDetailData(int no) {
		return mapper.goodsDetailData(no);
	}
}
