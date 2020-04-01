package com.biz.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ajax.domain.BookVO;

@Controller
@RequestMapping(value="/book")
public class BookController {
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String input(BookVO bookVO,Model model) {
		/*
		 * @ResponseBody가 없는 Controller의 method의 return값은
		 * 문자열.jsp 파일을 찾으라는 것이다
		 * return 값이 null 이면 현재 메서드를 호출할때 사용한 url의 path(book/input)를
		 * 문자열로 인식하고 book/input.jsp파일을 찾는다.
		 */
		return null;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(BookVO bookVO,Model model) {
		return "book_insert";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(BookVO bookVO) {
		return "home";
	}
	
	
}
