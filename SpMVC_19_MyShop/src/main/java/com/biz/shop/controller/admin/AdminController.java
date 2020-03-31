package com.biz.shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.service.CartService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value="/admin")
public class AdminController {
		
	private final CartService cartService;
		
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String main(Model model) {
		
		int countCart = cartService.countCart();
		int countDelivery = cartService.countDelivery();
		
		model.addAttribute("COUNT_CART",countCart);
		model.addAttribute("COUNT_DELIV",countDelivery);
		return "admin/main";
	}
	
	// @RequestMapping(value="/product",method=RequestMethod.GET)
	public String admin(Model model) {
		
		model.addAttribute("BODY","PRODUCT");
		return "admin/main";
	
	}

}
