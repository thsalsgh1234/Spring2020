package com.biz.readbook.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReadBookVO {

	private String b_code;// bigint primary key auto_increment,
	private String b_name;// varchar(20) not null,
	private String b_auther;// varchar(20) not null,
	private String b_comp;// varchar(20),
	private String b_year;// varchar(20),
	private int b_iprice;// int 
	
}
