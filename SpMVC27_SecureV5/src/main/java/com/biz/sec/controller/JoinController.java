package com.biz.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.sec.domain.UserDetailsVO;
import com.biz.sec.service.UserService;
import com.biz.sec.utils.PbeEncryptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Spring Security 기반 
 * 회원가입 및 Email 인증 프로젝트
 * 메인 컨트롤러
 * 
 * @since 2020-04-20
 * @author callor
 *
 */
@Slf4j
@SessionAttributes("userVO")
@Controller
@RequestMapping(value="/join")
@RequiredArgsConstructor
public class JoinController {

	private final UserService userService;
		
	
	@ModelAttribute("userVO")
	public UserDetailsVO newUser() {
		return new UserDetailsVO();
	}
	
	/**
	 * 회원가입 화면 보여주기
	 * sessionAttributes 활용
	 * localhost/sec/join : 회원가입 화면보이기
	 * join/user : 회원가입 버튼 클릭 후
	 * join/email_ok : email 인증 화면에서 email 보내기 후
	 * 
	 * @since 2020-04-20
	 * 
	 *  UPDATE : 2020-04-21
	 *  localhost/sec/join : 회원가입 화면보이기
	 *  join/join_next : 회원가입 버튼 클릭후
	 *  	DB에 회원정보를 보여준 후 email 인증 화면 보이기
	 *  
	 *  join/join_last : email 인증 후 이후 처리
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public String join(@ModelAttribute("userVO") UserDetailsVO userVO, Model model) {		
		return "join/join";
	}
	
	/**
	 * @since 2020-04-21
	 * 최초 회원 가입 화면에서 username과 password를 입력한 후
	 * 회원가입 버튼을 클릭하면
	 * userVO에 데이터를 받아서
	 * sessionAttributes에 설정된 저장소에 저장해 두고
	 * 이메일 인증 화면 보여주기
	 *   
	 * @param userVO
	 * @return
	 */
	@RequestMapping(value="/join_next",method=RequestMethod.POST)
	public String join_next(
		@ModelAttribute("userVO") UserDetailsVO userVO) {
		return "join/join_email";
	}
	
	/**
	 * @since 2020-04-21
	 * Email 인증폼에서 Email 보내기 버튼을 클릭했을때
	 * userVO에 데이터를 받아서(Email만)
	 * 
	 * sessionAttributes에 저장된 데이터와 통합(merge)하고
	 * DB에 저장한 후
	 * 인증정보를 Email로 보내고 
	 * 인증코드를 입력받는 화면을 다시 보여주기
	 * 이땐 JOIN변수에 EMAIL_OK 문자열을 실어서 보내고
	 * 화면에는 인증코드 입력하는 란이 보이도록 설정
	 * 
	 * @param userVO
	 * @return
	 */
	@RequestMapping(value="/join_last",method=RequestMethod.POST)
	public String join_last(
			@ModelAttribute("userVO") UserDetailsVO userVO,Model model) {
		
		// String email_token = userService.insert_getToken(userVO);
		
		model.addAttribute("username",
				PbeEncryptor.getEncrypt(userVO.getUsername()));
		// model.addAttribute("My_Email_Secret",email_token);
		model.addAttribute("JOIN","EMAIL_OK");
		return "join/join_email";
		
	}
	
	/**
	 * @since 2020-04-21
	 * 이메일 인증폼에서 인증키와 인증값을 받아서
	 * 인증 처리
	 * 
	 * @param secret_key
	 * @param secret_value
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/email_token_check",
				method=RequestMethod.POST)
	public String email_token_check(
			@RequestParam("secret_id") String username,
			@RequestParam("secret_key") String secret_key, 
			@RequestParam("secret_value") String secret_value
			) {
		
		boolean bKey 
			= userService
			.email_token_ok(
				username,secret_key,secret_value
		);
		
		
		if(bKey) return "OK";
		else return "FAIL";
	}
	
	
	/**
	 * @since 2020-04-20
	 * 회원가입 화면에서 username, password 입력후
	 * 회원가입 버튼 클릭했을때 호출
	 * 
	 * @param userVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String user(@ModelAttribute("userVO") UserDetailsVO userVO, Model model) {		
		return "join/join_email";
	}

	/**
	 * @since 2020-04-20
	 * 회원가입에서 username, password 입력후
	 * email 보내기 화면으로 이동하기
	 *  
	 * @param userVO
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/joinok",method=RequestMethod.POST)
	public String joinok(
			@ModelAttribute("userVO") UserDetailsVO userVO, 
			SessionStatus session,
			Model model) {		
				
		log.debug("USERVO :" + userVO.toString());
		int ret = userService.insert(userVO);
		model.addAttribute("JOIN","EMAIL_OK");

		// sesstionAttribute에 저장된 session값을 clear시키기
		// session.setComplete();
		log.debug("USERVO :" + userVO.toString());
		return "join/join_email";
		
	}
	
	/**
	 * @since 2020-04-20
	 * 회원가입 중 email 보내기 화면
	 * email 보내기 후 다시 재 전송화면으로
	 * 
	 * @param userVO
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/emailok",method=RequestMethod.GET)
	public String emailOk(
			@ModelAttribute("userVO") UserDetailsVO userVO,
			SessionStatus session,
			Model model) {
		
		boolean ret = userService.emailok(
					userVO.getUsername(),
					userVO.getEmail());
		
		session.setComplete();
		if(ret) {
			return "redirect:/user/login";
		}else {
			// 2020-04-21 추가
			return "join/join_email_fail";
		}
	}
}







