package com.biz.models.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.models.domain.UsersVO;
import com.biz.models.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends UserController{
	
	@Autowired
	UserService us ;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		UsersVO userVO = UsersVO.builder()
				.userId("korea")
				.password("12345")
				.userName("대한민국")
				.userRolle("gov")
				.build();
		us.insert(userVO);
		return "home";
	}
	
}


