package com.sist.dao;

import com.sist.mapper.*;
import com.sist.dao.*;
import com.sist.vo.*;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class DataBoardDAO {
   @Autowired
   private DataBoardMapper mapper;
   
   @Autowired
   private BCryptPasswordEncoder encoder;


//      @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
//          +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
//          +"FROM (SELECT no,subject,name,regdate,hit "
//          +"FROM spring_databoard ORDER BY no DESC)) "
//          +"WHERE num BETWEEN #{start} AND #{end}")
//     public List<BoardVO> databoardListData(@Param("start") int start,@Param("end") int end);
   public List<BoardVO> databoardListData(int start, int end) {
      return mapper.databoardListData(start, end);
   }
     
//     @Select("SELECT COUNT(*) FROM spring_databoard")
//     public int databoardRowCount();
   public int databoardRowCount() {
      return mapper.databoardRowCount();
   }
     
//     @Insert("INSERT INTO spring_databoard(no, name, subject, content, pwd, filename, filesize, filecount) "
//         + "VALUES (sd_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd}, #{filename}, #{filesize}, #{filecount})")
//     public void databoardInsert(DataBoardVO vo);

   public void databoardInsert(DataBoardVO vo) {
      mapper.databoardInsert(vo);
   }
   
   /*
     @Update("UPDATE spring_databoard SET "
     		+ "hit=hit+1 "
     		+ "WHERE no=#{no}")
     public void hitIncrement(int no);
     
     @Select("SELECT no, name, subject, content, TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday, "
     		+ "hit, filename, filesize, filecount "
     		+ "FROM spring_databoard "
     		+ "WHERE no=#{no}")
     
     public DataBoardVO databoardDetailData(int no);
    */
   
   public DataBoardVO databoardDetailData(int no) {
	   mapper.hitIncrement(no);
	   return mapper.databoardDetailData(no);
   }
   
   /*
     // 삭제하기 => 비교 (암호화 = 실제 데이터) => match
     @Select("SELECT filename, filecount FROM spring_databoard "
     		+ "WHERE no=#{no}")
     public DataBoardVO databoardFileInfoData(int no);
     
     @Select("SELECT pwd FROM spring_databoard "
     		+ "WHERE no=#{no}")
     public String databoardGetPassword(int no);
     
     @Delete("DELETE FROM spring_databoard "
     		+ "WHERE no=#{no}")
     public void databoardDelete(int no);
    */
   
   public DataBoardVO databoardFileInfoData(int no) {
	   
	   return mapper.databoardFileInfoData(no);
   }
   
   public boolean databoardDelete(int no, String pwd) {
	   boolean bCheck=false;
	   String db_pwd=mapper.databoardGetPassword(no);
	   // 복호화 => 원상복귀
	   // encode() : 암호화 , matches() : 비교하는 메소드
	   if(encoder.matches(pwd, db_pwd)) {
		  // 복호화 => 비밀번호 검색
		  bCheck=true;
		  mapper.databoardDelete(no);
	   }
	   else {
		   bCheck=false;
	   }
	   return bCheck;
   }

}
















