package com.biz.ajax.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ajax.domain.UserVO;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	
		UserVO userVO = new UserVO();
		
		/*
		 * userVO데이터를 생성하고(Service로 부터 가져오고)
		 * model userVO를 싣고
		 * return "home" (home.jsp 호출하여)
		 * userVO와 home.jsp를 렌더링하여
		 * web client로 전송하라
		 * 		(*.html 코드로 변환되어서 전송)
		 */
		// model.addAttribute("userVO",userVO.sampleVO());
		return "home";
	
	}
	
}








