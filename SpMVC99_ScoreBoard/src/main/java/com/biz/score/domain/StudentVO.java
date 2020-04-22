package com.biz.score.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Alias("studentVO")
public class StudentVO {
	
	private long st_id;
	private String st_num;
	private String st_name;
	private String st_grade;
	private String st_class;
	
}
