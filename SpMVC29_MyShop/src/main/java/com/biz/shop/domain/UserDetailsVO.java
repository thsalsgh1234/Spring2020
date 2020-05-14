package com.biz.shop.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsVO implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	/*필수 항목 필드 변수들
	--------------------------------*/
	private String username;
	private String password;
	
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private Collection<? extends GrantedAuthority> authorities;
	//----------------------------------

	private String nickname;
	private String email;
	private String phone;
	private String address;
	
	
}
