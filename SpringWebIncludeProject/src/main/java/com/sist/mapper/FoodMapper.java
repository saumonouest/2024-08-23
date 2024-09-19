package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.FoodVO;
/*
 * vo - mapper - dao - controller - jsp
FNO       NOT NULL NUMBER        
NAME      NOT NULL VARCHAR2(500) 
TYPE      NOT NULL VARCHAR2(100) 
PHONE     NOT NULL VARCHAR2(50)  
ADDRESS   NOT NULL VARCHAR2(300) 
SCORE              NUMBER(2,1)   
THEME              CLOB          
POSTER    NOT NULL VARCHAR2(500) 
IMAGES             CLOB          
TIME               VARCHAR2(50)  
PARKING            VARCHAR2(500) 
CONTENT            CLOB          
RDAYS              VARCHAR2(300) 
JJIMCOUNT          NUMBER        
LIKECOUNT          NUMBER        
HIT                NUMBER      
 */
public interface FoodMapper {
	@Select("SELECT fno, poster, name, type,  num "
			+ "FROM (SELECT fno, poster, name, type, rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(project_food_house fh_fno_pk)*/fno, poster, name, type "
			+ "FROM project_food_house ))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT COUNT(*) FROM project_food_house")
	public int foodRowCount();
	
	// 상세보기
	 @Update("UPDATE project_food_house SET "
			  +"hit=hit+1 "
			  +"WHERE fno=#{fno}")
	   public void foodHitIncrement(int no);
	
	 @Select("SELECT * FROM project_food_house "
			  +"WHERE fno=#{fno}")
	   public FoodVO foodDetailData(int fno);
	 
	 
	// 쿠키 정보 데이터
	@Select("SELECT fno, name, poster "
			+ "FROM project_food_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodCookieInfoData(int fno);
}
