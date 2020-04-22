package com.biz.sec.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * DB 연동해서 순수 CRUD를 수행할 클래스로 변경
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserVO {
	
	// spring security에서 사용할 기본 칼럼
	private long id;
	private String username;
	private String password;
	private boolean enabled;
	
	private String email;
	private String phone;
	private String address;
	

}














