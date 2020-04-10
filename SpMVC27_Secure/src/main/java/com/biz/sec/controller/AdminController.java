package com.biz.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	

	@ResponseBody
	@RequestMapping(value="",method=RequestMethod.GET)
	public String admin() {
		return "admin Home";
	}

}







