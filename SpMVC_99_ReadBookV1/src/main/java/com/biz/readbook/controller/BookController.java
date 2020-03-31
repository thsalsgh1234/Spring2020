package com.biz.readbook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.readbook.domain.ReadBookVO;
import com.biz.readbook.service.ReadBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/book")
@Controller
public class BookController {
	
	private final ReadBookService rService;

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String findList(Model model) {
		List<ReadBookVO> rList = rService.allSelect();
		model.addAttribute("readbooklist", rList);
		return "list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String in() {
		return "insert";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String in(@ModelAttribute ReadBookVO rVO) {
		rService.insert(rVO);
		return "redirect:/book/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String up(@RequestParam("bCode") String b_code, Model model) {
		ReadBookVO rVO = rService.findByBCode(b_code);
		model.addAttribute("VO", rVO);
		return "update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String up(@ModelAttribute ReadBookVO rVO) {
		rService.update(rVO);
		return "redirect:/book/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String 지워(@RequestParam String bCode) {
		rService.delete(bCode);
		return "redirect:/book/list";
	}
}
