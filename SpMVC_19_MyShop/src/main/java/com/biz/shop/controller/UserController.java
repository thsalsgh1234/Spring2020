package com.biz.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.service.ProductService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String user(Model model) {
		
		return "home";
	}

}
