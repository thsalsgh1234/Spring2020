package com.biz.ajax.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ajax.domain.UserVO;

@Controller
public class UserController {
	
	/*
	 * @ModelAttribute는 form에서 전송되는 데이터를
	 * VO에 한꺼번에 받기위해서 사용하는 Annotation
	 * Sp3에서는 기본으로 설정을 해주여만 
	 * 		제대로 VO에서 데이터를 받았다
	 * Sp4에서 부터는 선택사항으로 설정되고 VO에 Annotation을
	 * 	붙이지 않아도 form에서 전송되는 데이터를 잘 받았다
	 * 
	 * form의 input box name으로 설정된 이름의 변수가
	 * VO에 있으면 알아서 잘 매칭되어 데이터를 받을 수 있었다
	 * 혹시 VO에 있는 변수값이 전송되지 않더라도 문제가 없고
	 * VO에 없는 변수값이 전송되더라도 오류가 나거나 하지 않았다
	 * 
	 * @ModelAttribute를 사용하는 또하나의 이유는
	 * form에서 받은 데이터를 다시 view로 재 전송할때
	 * Model에 데이터를 싣지 않아도 자동으로 값이 실려서 전송되었다.
	 * 
	 * @ModelAttribute("객체이름")을 설정해주어야 
	 * Model에 싣는 기능이 정상 작동된다.
	 * 
	 * @ModelAttribute("객체이름") 설정을 사용하면
	 * form에서 vo에 받은 데이터를 별도로 Model에 싣지 않아도
	 * 바로 view로 전송할수 있다.
	 */
	@RequestMapping(value="saveUser",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("userVO") UserVO userVO) {
		return "home";
	}
	
	/*
	 * @ResponseBody 가 설정된 Controller의 method는
	 * return 문에서 view 파일을 찾지 않고
	 * return 문의 데이터를 그대로 있는 그대로 전송하는 역할을
	 * 수행한다. 
	 */
	@ResponseBody
	@RequestMapping(value="sendUserId"
					,method=RequestMethod.POST
					,produces = "application/json;charset=UTF-8")
	public Map<String,Object> sendUserId(UserVO userVO) {
		
		Map<String,Object> msg = new HashMap<String,Object>();
		msg.put("RET_CODE", "RECV_OK");
		msg.put("userVO",userVO);
		
		// return userVO.getUserId();
		// return "home";
		return msg;
	
	}
	
	@ResponseBody
	@RequestMapping(value="sendUser",method=RequestMethod.POST)
	public UserVO sendUser(UserVO userVO) {
		return userVO;
	}
	
	
	@RequestMapping(value="html",method=RequestMethod.GET)
	public String sendUserFromHtmml(UserVO userVO) {
		return "user_info";
	}
	
}








