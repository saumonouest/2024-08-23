package com.sist.mapper;
import java.util.*;

public interface EmpMapper {
	@Select("SELECT empno, ename, sal, job, hiredate "
			+ "FROM emp ORDER BY empno ACS")
	
}
