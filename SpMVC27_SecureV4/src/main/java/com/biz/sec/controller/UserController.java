package com.biz.sec.controller;

import java.security.Principal;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.sec.domain.UserDetailsVO;
import com.biz.sec.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "auth/login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "auth/join";
	}

	@ResponseBody
	@RequestMapping(value = "/join", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String join(String username, String password) {

		log.debug("아이디 {}, 비번 {}", username, password);

		userService.insert(username, password);

		// return "redirect:/";
		return String.format("아이디 : <b>%s</b>, 비번 : <b>%s</b>", username, password);

	}

	@ResponseBody
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public String idcheck(String username) {

		boolean ret = userService.isExistsUserName(username);
		if (ret) {
			return "Exists".toUpperCase(); // EXISTS
		}
		return "NonExists".toUpperCase(); // NONEXISTS

	}

	@ResponseBody
	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public String password(String password) {

		boolean ret = userService.check_password(password);
		if (ret)
			return "PASS_OK";
		return "PASS_FAIL";

	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String user() {
		return "user HOME";
	}

	@RequestMapping(value = "/mypage1", method = RequestMethod.GET)
	public String mypage(Model model) {

		// 로그인한 사용자 정보
		UserDetailsVO userVO 
			= (UserDetailsVO) SecurityContextHolder
			.getContext()
			.getAuthentication()
			.getPrincipal();

		// 권한(ROLE) 리스트 추출하여 userVO에 setting
		userVO.setAuthorities(
				SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getAuthorities());

		model.addAttribute("userVO", userVO);
		return "auth/mypage";
	}

//	@ResponseBody
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Principal principal, Model model) {

		UsernamePasswordAuthenticationToken upa 
			= (UsernamePasswordAuthenticationToken) principal;
		
		UserDetailsVO userVO 
			= (UserDetailsVO) upa.getPrincipal();
		userVO.setAuthorities(upa.getAuthorities());

		model.addAttribute("userVO", userVO);
		return "auth/mypage";
//		return userVO;
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.POST)
	public String mypage(UserDetailsVO userVO,Principal principal,
					String[] auth, Model model) {

		/*
		 * Security Session 정보가 
		 * 저장된 메모리에 직접 접근하여
		 * session user 정보를 수정하는 방법으로
		 * 코드는 쉬워지나 보안에 
		 * 치명적인 문제를 일으킬 수 있다.
		 * 
		UsernamePasswordAuthenticationToken upa 
		= (UsernamePasswordAuthenticationToken) principal;
	
		UserDetailsVO oldUserVO
		= (UserDetailsVO) upa.getPrincipal();
		
		oldUserVO.setEmail(userVO.getEmail());
		
		*/
		
		int ret = userService.update(userVO);
		return "redirect:/user/mypage";

		
	}
}
