package com.biz.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.score.domain.StudentVO;
import com.biz.score.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String List(Model model) {
		List<StudentVO> studentList = studentservice.selectAll();
		model.addAttribute("STUDENT_LIST",studentList);
		return "student_list";
	}
}
