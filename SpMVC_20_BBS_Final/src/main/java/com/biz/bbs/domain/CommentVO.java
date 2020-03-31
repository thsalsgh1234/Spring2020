package com.biz.bbs.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("commentVO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentVO {

	private long c_id;//	NUMBER
	
	private long c_p_id;//	NUMBER
	private long c_b_id;//	NUMBER
	
	private String c_date_time;//	VARCHAR2(30)
	private String c_writer;//	nVARCHAR2(30)
	private String c_subject;//	nVARCHAR2(125)

}
