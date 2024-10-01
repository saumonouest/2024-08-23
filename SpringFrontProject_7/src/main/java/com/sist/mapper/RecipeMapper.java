package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface RecipeMapper {
	 // 목록 출력
	   @Select("SELECT no, title, poster, chef, hit, num "
	   		+ "FROM(SELECT no, title, poster, chef, hit, rownum as num "
	   		+ "FROM(SELECT /*+INDEX_ASC(recipe_no_pk)*/no, title, poster, chef, hit "
	   		+ "FROM recipe WHERE no IN(SELECT no FROM recipe "
	   		+ "INTERSECT SELECT no FROM recipedetail))) "
	   		+ "WHERE num BETWEEN #{start} AND #{end}")
	   public List<RecipeVO> recipeListData(Map map);
	   
	   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
	   		+ "WHERE no IN(SELECT no FROM recipe "
	   		+ "INTERSECT SELECT no FROM recipedetail)")
	   public int recipeTotalPage();
	   
	   
	   // 상세보기
	   @Update("UPDATE recipe SET "
	   		+ "hit=hit+1 "
	   		+ "WHERE no=#{no}")
	   public void hitIncrement(int no);
	   
	   @Select("SELECT * FROM recipedetail "
	   		+ "WHERE no=#{no}")
	   public RecipeDetailVO recipeDetailData(int no);
}
