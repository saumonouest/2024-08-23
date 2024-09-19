package com.sist.mapper;
import java.util.*;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("SELECT fno, name, type, address, time, parking, theme "
			+"FROM prpject_foof_house "
			+"WHERE ${column} LIKE '%'||#{fd}||'%'")
	
	public List<FoodVO> foodFindData(Map map);
}
