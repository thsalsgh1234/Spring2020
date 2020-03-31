package com.biz.shop.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.biz.shop.domain.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

/*
 * supports() method가 true를 return하면
 * 정상로그인된 사용자 정보가 token 형태로 
 * default-target-url에 지정된 controller path에게 데이터가 전송된다.
 * 
 * authenticate에서 필요한 사용자 정보를 만들거나 가공할수 있다.
 */
@Slf4j
public class CustomAuthProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = (String) authentication.getPrincipal(); // username 추출
		String password = (String) authentication.getCredentials(); // 비밀번호 추출
		log.debug("USERNAME : {}",username);
		
		if (username == null || username.isEmpty()) {
			log.debug("LOGIN FAIL");
			return null;
		}

		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		roles.add(new SimpleGrantedAuthority("ROLE_MANEGER"));

		/*
		 * 만약 해당 사용자 Detail 정보가 DB에 있다면 해당 정보를 DB에서 조회하여 CustomUserDetails 클래스에 세팅하여
		 * controller로 전송할수 있다
		 */
		UserDetails cUserDetails = new CustomUserDetails();
		// cUserDetails.setNick_name("홍길동");
		// cUserDetails.setTel("010-111-1111");
		// cUserDetails.setAddr("서울특별시");

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, // principal,
				password, // credentials,
				roles); // authorities)
		token.setDetails(cUserDetails);
		return token;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		log.debug(authentication.toString());
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
