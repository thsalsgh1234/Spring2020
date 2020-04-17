package com.biz.sec.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.sec.domain.UserDetailsVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	
	/*
	 * security mapping을 Annotation을 사요하여 설정
	 * @Secured(value={문자열 배열}
	 */
	
	// @Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String auth(Model model) {
		return "auth/auth_view";
	
	}
	
	/**
	 * Controller의 method에서 HttpServletRequest 클래스로 부터 인증(로그인한)정보를
	 * 추출하여 세부항목을 보는 방법
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value = "/auth/{id}", method = RequestMethod.GET)
	public Object auth(@PathVariable("id")String id,
			HttpServletRequest req) {
		
		
		int intId = 0;
		
		try {
			intId = Integer.valueOf(id);
		} catch (Exception e) {
			return e.getMessage();
		
		}
		Authentication auth = (Authentication) req.getUserPrincipal();
		
		
		if(intId == 1) {
			log.debug("intId = 1");
		}else if(intId ==2){
			log.debug("intId = 2");
		}
		
		
		// swith 문은 break로 끝내주거나 return문으로 끝내줘야한다.
		switch (intId) {
		case 1: // if(int Id == 1)
			return auth.getDetails();
			
		case 2: // else if(int Id == 2)
			return auth.getCredentials();
			
		case 3: // else if(int Id == 3)
			return auth.getPrincipal();
			
		case 4: // else if(int Id == 4)
			return auth.getAuthorities();
			
		case 5: // else if(int Id == 5)
			return auth.getName();
			
		case 6: // else if(int Id == 6)
			UserDetailsVO userVO = (UserDetailsVO) auth.getPrincipal();
			return userVO;	
			
			
		default: // 그 외
			return "Not Found";
		}
		
		
		
		
	
	}
}

