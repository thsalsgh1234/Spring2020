package com.biz.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@RequestMapping(value="/nation")
@Controller
public class NationController {

	@ResponseBody
	@RequestMapping(value="/where")
	public String where() {
		
		String nation = " 대한민국 \n";
		
		nation +="Korea\n";
		nation +="우리나라";
		
		return nation;
	}
	@ResponseBody
	@RequestMapping(value="/korea")
	public String korea() {
		
		String nation = " 나의 조국 대한민국";
		
		
		return nation;
	}
	@ResponseBody
	@RequestMapping(value="/usa")
	public String usa() {
		
		String nation = " united state America";
		
		
		return nation;
	}

	
	
}
