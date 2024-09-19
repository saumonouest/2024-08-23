package com.sist.mapper;
import com.sist.vo.*;
public class FoodMapper {
@Select("SELECT fno, poster, name, num "
		+"FROM (SELECT fno, poster, namem rownum as num "
		+ "FROM (SELECT fno, poster, name "
		+ "FROM project_food_house ORDER BY fno ASC)) "
		+ "WHERE num BETWEEN #{start} AND #{end}")
public List<FoodVO> foodListData(@Param("start") int start, @Param("end"))

}
