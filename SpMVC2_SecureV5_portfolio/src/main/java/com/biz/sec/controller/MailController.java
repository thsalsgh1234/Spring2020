package com.biz.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.sec.service.MailSendService;

import lombok.RequiredArgsConstructor;
@RequestMapping(value="/mail")
@Controller
@RequiredArgsConstructor
public class MailController {

	private final MailSendService mService;
	
	@ResponseBody
	@RequestMapping(value="/send",method=RequestMethod.GET)
	public String sendMail() {
		
		mService.sendMail();
		return "SEND OK";
	}
	
	
	
	
	
	
}
