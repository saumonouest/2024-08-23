package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

// �޸� �Ҵ� : => 1. DAO, 2. Service, 3. Model ...
// VO : �޸� �Ҵ��� �ƴ� (�Ϲ� ��������)
@Repository("dao")
public class MusicDAO {
	@Autowired
	private MusicMapper mapper;
	
	public List<MusicVO> musicListData(){
		return mapper.musicListData();
	}
	
	public List<MusicVO> musicTitleFindData(String title){
		return mapper.musicTitleFindData(title);
	}
	
	public List<MusicVO> musicSingerFindData(String singer){
		return mapper.musicTitleFindData(singer);
	}
	
	public List<MusicVO> musicAlbumFindData(String album){
		return mapper.musicTitleFindData(album);
	}
	
	// ���� �˻� => ���� ����
	/* <foreach> : IN
	 * <trim> : ���� / �߰� => OR/AND
	 * <if> : ���ǹ�
	 * <choose> => ���� ���ǹ�
	 * 	<when>
	 * </choose>
	 * ==============================
	 * => <resultMap> : ����
	 * => <parameterMap> : ���ν��� 
	 *  
	 */
	public List<MusicVO> musicFindData(int type, String fd){
		return mapper.musicFindData(type, fd);
	}
}
