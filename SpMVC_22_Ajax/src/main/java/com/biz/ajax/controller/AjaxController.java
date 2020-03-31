package com.biz.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ajax.domain.AddrVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/ajax")
@Controller
public class AjaxController {
	
	/*
	 * @ResponseBody 
	 * 컨트롤러 method에서 return하는 값을 변환없이 있는 그대로
	 * 보내라
	 * 
	 * 일반 method에서는 문자열에 해당하는 view를 찾아서
	 * rendering을 수행하여 클라이언트에게 보낸다.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="",method=RequestMethod.GET)
	public String ajax_method() {
		
		return "OK";
		
	}
	
	/*
	 * 전자정부 관련한 web서비스에서 사용하던 
	 * URL 패턴
	 * 
	 * 일반적으로 서버에 처음 접속을 하면
	 * index.* 라는 파일을 보여주고
	 * 메뉴를 클릭하거나 어떤 기능을 선택할때
	 * 접미사로 .do를 붙여서 연동하도록 하는 패턴
	 * *.do 접미사가 붙어있는 URL은 컨트롤러를 통해서
	 * 업무를 처리하고
	 * 그렇지 않은 요청은 모두 무시하게 하는 패턴이었다
	 * 
	 * 이패턴을 사용하여 web서비스를 만들려면
	 * 프로젝트의 web.xml의 appServlet url-pattern을 설정하고
	 * 대신 index.html, index.jsp 파일을 webapp 폴더에
	 * 작성해 두어야 한다.
	 * 그래야 프로젝트가 톰캣에 의해 run 되었을때
	 * 최초 404 오류가 나타나지 않는다.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/msg",method=RequestMethod.GET)
	public String ajax_method(String msg) {
		
		if(msg.equalsIgnoreCase("KOREA")) {
			return "KOREA" ;
		} else {
			return "ERROR";	
		}
	}
	

	/*
	 * @ResponseBody를 붙이고 객체(클래스)를 리턴하면
	 * 객체 json으로 변환되어 클라이언트에 전송
	 * 단, jacksonbind를 pom.xml에 
	 * 		dependency를 설정해 두어야 한다.
	 */
	@ResponseBody
	@RequestMapping(value="/addr",method=RequestMethod.GET)
	public AddrVO addr() {

		AddrVO vo = AddrVO.builder()
				.ad_name("홍길동")
				.ad_addr("서울특별시")
				.ad_tel("010-111-1111")
				.ad_age(33).build();
	
		return vo;
	}
	
	/*
	 * responseBody 가 없는 method는
	 * 문자열을 return 하고 해당하는 문자열.jsp 파일을 views 폴더에서
	 * 찾아 데이터와 rendering하여 클라이언트로 보낸다
	 */
	@RequestMapping(value="/addr_view",method=RequestMethod.GET)
	public String addr(Model model) {

		AddrVO vo = AddrVO.builder()
				.ad_name("홍길동")
				.ad_addr("서울특별시")
				.ad_tel("010-111-1111")
				.ad_age(33).build();
	
		model.addAttribute("vo",vo);
		return "addr" ;
	}

	
	
	@ResponseBody
	@RequestMapping(value="/put",method=RequestMethod.PUT,
		produces = "text/plain;charset=UTF-8")
	public String ajax_put(String msg) {
		log.debug(msg);
		return msg;
	}
	
	
	
	
	

}
