package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

// �޸� �Ҵ�
@Repository //FoodDAO
public class FoodDAO {
	@Autowired // ���������� ����� ��ü �ּҸ� ã�Ƽ� ���� => �ڵ� ����
	private FoodMapper mapper;
	
}
