package com.biz.shop.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http);
		
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/mypage").hasAnyRole("ADMIN","USER")
		.antMatchers("/user/**").permitAll()
		.antMatchers("/**").permitAll()
		.anyRequest().authenticated(); // 위에 나열한 것 외에는 모두 인증 필요
		
		http.formLogin()
		.loginPage("/user/login")
		.usernameParameter("username")
		.passwordParameter("password");
		
		http.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/");
		
	}

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}

	/*
	 * security 필터를 거치지 않고 요청에 응답할 요소들
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {

		// TODO Auto-generated method stub
		// super.configure(web);
		web.ignoring().antMatchers("/resources/**");
		
	}


	
	
	
	
	
	
	
	
}
