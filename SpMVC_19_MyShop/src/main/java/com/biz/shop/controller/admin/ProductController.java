package com.biz.shop.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.shop.domain.ProductVO;
import com.biz.shop.service.ProductService;

import lombok.RequiredArgsConstructor;

@SessionAttributes("productVO")
@RequiredArgsConstructor
@RequestMapping(value="/admin/product")
@Controller
public class ProductController {
	
	private final ProductService proService;
	
	@ModelAttribute("productVO")
	public ProductVO newProduct() {
		return new ProductVO();
	}
	
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public String product(
			@ModelAttribute("productVO") ProductVO productVO,
			@RequestParam(value="search",
					required = false, defaultValue = "0") String search,
			@RequestParam(value="text",
					required = false, defaultValue = "") String text,
			Model model) {

		/*
		if(search.equals("0")) {
			List<ProductVO> proList = proService.selectAll();
		} else {
			// 검색 list
		}
		*/

		this.modelMapping(model);
		
		productVO = new ProductVO();
		model.addAttribute("search",search);
		model.addAttribute("text",text);
		model.addAttribute("productVO",productVO);
		return "admin/main";

	}

	@RequestMapping(value="/detail",method=RequestMethod.POST)
	public String product_detail(
			@Valid @ModelAttribute("productVO") ProductVO productVO,
			BindingResult result, Model model) {

		if(result.hasErrors()) {
			this.modelMapping(model);
			return "admin/main";
		}
		this.modelMapping(model);
		model.addAttribute("PRO_BODY","DETAIL");
		return "admin/main";
	}
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String product(
			@ModelAttribute("productVO") ProductVO productVO,
			Model model,SessionStatus status) {
		
		proService.save(productVO);
		status.setComplete();
		return "redirect:/admin/product";
		
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(
			@ModelAttribute("productVO") ProductVO productVO,
			@PathVariable("id") String strId, 
							Model model) {
		
		this.modelMapping(model);
		long id = Long.valueOf(strId);
		productVO = proService.findById(id);
		model.addAttribute("productVO",productVO);
		return "admin/main";
		
	}
	
	private void modelMapping(Model model) {

		List<ProductVO> proList = proService.selectAll();
		model.addAttribute("PRO_LIST",proList);
		model.addAttribute("BODY","PRODUCT");

	}
	
}


