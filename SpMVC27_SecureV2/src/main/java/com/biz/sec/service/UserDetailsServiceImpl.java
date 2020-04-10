package com.biz.sec.service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.biz.sec.domain.AuthorityVO;
import com.biz.sec.domain.UserDetailsVO;
import com.biz.sec.domain.UserVO;
import com.biz.sec.persistance.AuthoritiesDao;
import com.biz.sec.persistance.UserDao;

import lombok.RequiredArgsConstructor;

/*
 * 사용자의 상세정보를 DB로 부터 가져와서
 * Spirng Security 여러곳에서 사용할 수 있도록 VO에 연동하는  method
 * 
 * UserDetailService 인터페이스를 가져와서  customizing
 */
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	/*
	 * 외부에서 주입받을 객체,변수 선언
	 * 보통은 객체나 변수에 @Autowired를 사용하는데 
	 * 
	 * private final로 객체 변수를 선언하고 
	 * @RequiredArgsConstructor을 붙여서 변수를 생성(초기화)하도록 한다.
	 * 
	 * 만약 @RequiredArgsConstructor을 사용하지 않으려면 클래스 생성자에 @Autowired를 붙여서 초기화 해주어야 한다.
	 */
	private final AuthoritiesDao authDao;
	private final UserDao userDao;
	
	// DB로부터 데이터를 불러와서 UserDetailsVO에 데이터를 복사하여 연동하는 코드가 작성될곳 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// DB로부터 사용자 정보 가져오기
		UserVO userVO = userDao.findByUserName(username);
		
		//Spring Security가 사용할 DetailVO 선언
		UserDetailsVO userDetails = new UserDetailsVO();
		userDetails.setUsername(userVO.getUsername());
		userDetails.setPassword(userVO.getPassword());
		userDetails.setEnabled(true);
		
		// 사용자 정보를 사용할수 있는가 아닌가를 세밀하게 제어하기 위한 칼럼
		userDetails.setAccountNonExpired(true);
		userDetails.setAccountNonLocked(true);
		userDetails.setCredentialsNonExpired(true);
		
		userDetails.setAuthorities(this.getAuthorities(username));
		
		// 이것을 builder pattren을 이용하면
		userDetails = UserDetailsVO.builder()
				.username(userVO.getUsername())
				.password(userVO.getPassword())
				.enabled(true)
				.accountNonExpired(true)
				.AccountNonLocked(true)
				.credentialsNonExpired(true)
				.authorities(this.getAuthorities(username))
				.build();
												
			return userDetails;
		
	}
	
	/**
	 * authorities 테이블에서 권한 리스트를 가져오기
	 */
	private Collection<GrantedAuthority> getAuthorities(String username){
		
		List<AuthorityVO> authList = authDao.findByUserName(username);
		List<GrantedAuthority> authorites = new ArrayList<GrantedAuthority>();
		
		for(AuthorityVO vo : authList) {
			SimpleGrantedAuthority sAuth = new SimpleGrantedAuthority(vo.getAuthority());
			authorites.add(sAuth);
		}
		
		return authorites;
	}

}
