package com.biz.shop.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.shop.domain.DeptVO;
import com.biz.shop.service.DeptService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/admin/dept")
@Controller
public class DeptController {
	
	private final DeptService dService;
		
	// */admin/dept 로 매핑
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String input(Model model) {

		this.modelMapping(model);
		
		DeptVO deptVO = new DeptVO();
		model.addAttribute("deptVO",deptVO);
		return "admin/main";
	
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		this.modelMapping(model);
		return "admin/dept_list";
	
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String input(
			@Valid @ModelAttribute DeptVO deptVO,
			BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			this.modelMapping(model);
			model.addAttribute("deptVO",deptVO);
			return "admin/main";
		}
		
		DeptVO ret = dService.save(deptVO);
		return "redirect:/admin/dept";
	
	}

	@RequestMapping(value= {"/search/{search}",
							"/search/",
							"/search"},
				method=RequestMethod.GET)
	public String search(
			@PathVariable(
					name = "search",
					required = false) String search,
			Model model) {
		
		this.modelMapping(model,search);
		return "admin/dept_list";
		
	}

	private void modelMapping(Model model,String search) {
		
		List<DeptVO> deptList = null;
		if(search == null) {
			deptList = dService.selectAll();	
		} else {
			deptList = dService.findByDName(search);
		}
		model.addAttribute("DEPT_LIST",deptList);
		model.addAttribute("BODY","DEPT");
	
	}

	private void modelMapping(Model model) {
		this.modelMapping(model,null);
	}

}
