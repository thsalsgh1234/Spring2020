package com.biz.sec.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Spring Security와 연동하여 회원정보를 관리하기 위한
 * UserVO는 단독으로 작성하지 않고
 * 
 * UserDetail 이라는 인터페이스를 implements 하여 작성한다.
 * 
 * Spring Security에서 제공하는 User라는 클래스를 상속하여
 * 사용할 것이다.
 * 
 * 
 * USerVO는 인턴스를 생성할때
 * 생성자를 사용하여 초기 값을 설정하도록 디자인 되어 있다.
 * 
 */

public class UserVO extends User{

	/*
	 * VO 객체를 map에 담아서 req, res에 실어서 보낼때
	 * 객체를 문자열형으로 변환하는 과정이 있다.
	 * 이 과정을 serialize라고 하는데, 각 변환된 문자열이
	 * 서로 흐트러지지 않도록 설정하는 키값
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String phone;
	
	@Getter @Setter
	private String addr;
	
//	@Getter @Setter
//	private int age;
	
	public UserVO(String username, 
			String password, 
			boolean enabled) {
		
		super(username, password, enabled, true,true,true,null);
	}
	
	public UserVO(
			String username, 
			String password, 
			boolean enabled, 
			
			String email,
			String phone,
			String addr,
//			int age,
			
			boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		this.email = email;
		this.phone = phone;
		this.addr = addr;
//		this.age = age;
		
		// TODO Auto-generated constructor stub
	}


}














