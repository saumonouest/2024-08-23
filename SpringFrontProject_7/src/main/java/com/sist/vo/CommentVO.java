package com.sist.vo;
import java.util.*;

import lombok.Data;
// recipe(1) / seoul(2) / goods(3) ===> 프로시저
@Data
public class CommentVO {
	private int cno, rno, likecount, group_id, group_step, group_tab, depth, root;
	private String id, name, sex, msg, dbday;
	private Date regdate, modifydate;
	private int type;
}

