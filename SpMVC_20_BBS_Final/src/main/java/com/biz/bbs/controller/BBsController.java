package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.domain.CommentVO;
import com.biz.bbs.service.BBsService;
import com.biz.bbs.service.CommentService;
import com.biz.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BBsController {

	/*
	 * 현재 BBsController와 BBsSerivce* 는
	 * BBsService 인터페이스를 거쳐서 연결이 되어 있다.
	 * BBsService 인터페이스를 imp한 클래스의 
	 * 		코드가 미완성 상태이지만
	 * BBsController 입장에서는 
	 * 		BBsService*의 코드가 완성되어있다라는
	 * 		전제하에 Controller 코드 작성을 진행할수 있다.
	 * 만약 이후에 BBsService* 의 코드가 완성되고
	 * 		여러개의 BBserviceImp* 클래스가 작성되면
	 * 		필요한 클래스를 가져다가 부착만하면
	 * 		프로젝트가 완성이 될것이다
	 * 
	 * 결합도를 낮추는 결과가 된다.
	 * - 결합도 : 모듈간의 의존도, 
	 * 	 모듈 코드 작성의 유연성과 관련
	 * 
	 * ※ 결합도는 낮게, 응집도는 높은 모듈간 연계가 
	 * 		좋은 설계이다
	 * 
	 */
	@Autowired
	@Qualifier("bbsV2")
	private BBsService bbsService;
	
	@Autowired
	private FileService fileService;
	
	@Qualifier("cmtV2")
	@Autowired
	private CommentService cmtService;
	
	/*
	 * 게시판 목록 전체를 보기 위한 method이고
	 * DB에서 tbl_bbs 테이블 전체를 SELECT한 결과를
	 * BBS_LIST라는 이름으로 model에 Attribute를 추가하여
	 * bbs_list.jsp와 rendering 하도록 수행한다.
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<BBsVO> bbsList = bbsService.selectAll();
		model.addAttribute("BBS_LIST",bbsList);
		return "bbs_list";
	
	}
	
	/*
	 * 리스트에서
	 * 글쓰기(작성) 버튼을 클릭했을때
	 * 게시판 작성 화면을 열어줄 path
	 * 버튼을 클릭했을때 작동할 path는
	 * 		method를 GET로 설정한다.
	 */
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "bbs_write";
	}
	
	/*
	 * 게시판 작성화면에서 저장(글쓰기)버튼을 클릭했을때
	 * - 게시판 작성화면은 <form> tag로 감싸져 있고
	 * - form tag내에 input tag로 입력 상자를 구성하고
	 * 		버튼이 2개 있다.
	 * - 그중 저장(글쓰기) 버튼은 아무런 type로 
	 * 		지정하지 않았기 때문에
	 * - 저장 버튼을 클릭하면 <form> tag에 지정된
	 * 		action path로 
	 * 		method에 지정된 방식으로 데이터를 전송한다
	 * - 이러한 버튼의 기본 기능을 submit 이라고 한다.
	 * 
	 * bbs_write.jsp에서는 <form> tag에 action을 제거했다
	 * - 이렇게 되면
	 * - 처음 게시판 작성화면을 열기 위해서 사용했던
	 * - path 인 ${rootPath}/bbs/insert 가
	 * 		action에 자동으로 설정이 된다.
	 * - 또한 method는 POST로 지정이 되어 있기 때문에
	 * 		암시적으로 ${rootPath}/bbs/insert path로
	 * 		POST 방식으로 데이터를 전송하라 라는 설정과 같다
	 * - 그래서 이 메서드에서 요청을 수신하게 되고
	 * 		input tag에 입력된 문자열들은 bbsVO 객체변수에 
	 * 		담기게 된다
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(BBsVO bbsVO) {
		
		long b_id = bbsVO.getB_id();
		
		if(b_id > 0) {
			bbsService.update(bbsVO);
		} else {
			bbsService.insert(bbsVO);
		}
		return "redirect:/list";
	
	}
	
	/*
	 * 게시판 리스트에서 제목을 클릭하면
	 * update path에게 b_id 값을 전달하고
	 * b_id값을 수신하여 게시판에서 
	 * 		1개의 게시판 데이터를 SELECT 하고
	 * 		bbsVO에 받는다
	 * model 에 bbsVO를 BBS라는 이름으로 Attribute를 추가하고
	 * bbs_write.jsp 파일에게 전달한다.
	 *  
	 */
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(
			@RequestParam("b_id") String b_id,Model model) {
		
		BBsVO bbsVO = bbsService.findById(Long.valueOf(b_id));
		model.addAttribute("BBS",bbsVO);
		return "bbs_write";
	
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(BBsVO bbsVO,Model model) {
		bbsService.update(bbsVO);
		return "redirect:/list";
	}

	
	@RequestMapping(value="/detail",
			method=RequestMethod.GET)
	public String detail(
			@RequestParam("b_id") String b_id,
			Model model) {
		
		long c_b_id = Long.valueOf(b_id);
		List<CommentVO> cmtList = cmtService.findByBId(c_b_id);
		model.addAttribute("CMT_LIST",cmtList);
		
		BBsVO bbsVO = bbsService.findById(Long.valueOf(b_id));
		model.addAttribute("BBS",bbsVO);

		return "bbs_view";
	
	}
	
	
	public String delete(String strId) {
		bbsService.delete(Long.valueOf(strId));
		return null;
	}
	
	@RequestMapping(value="/repl",method=RequestMethod.GET)
	public String repl(
			@RequestParam("b_id") String b_id,
			Model model) {
		
		// 본글과 답글을 연결하기 위해서
		// 답글의 b_p_id에 본글의 id값을 저장
		BBsVO bbsVO 
			= bbsService.findById(Long.valueOf(b_id));
		
		String b_subject = "re : " + bbsVO.getB_subject();
		bbsVO.setB_subject(b_subject);
		bbsVO.setB_content("");
		bbsVO.setB_writer("");
		
		model.addAttribute("BBS",bbsVO);
		return "bbs_write";
	}
	
	@RequestMapping(value="/repl",method=RequestMethod.POST)
	public String repl(BBsVO bbsVO,Model model) {

		bbsVO.setB_p_id(bbsVO.getB_id());
		bbsVO.setB_id(0L);
		int ret = bbsService.insert(bbsVO);
		return "redirect:/list";
	
	}
	
	@ResponseBody
	@RequestMapping(value="/image_up",
				method=RequestMethod.POST,
				produces = "text/html;charset=UTF-8")
	public String fileUp(MultipartFile upFile) {
		
		log.debug("파일업:" + upFile.getOriginalFilename());
		
		String retFileName = fileService.fileUp(upFile);
		if(retFileName == null) {
			return "FAIL";
		}
		return retFileName;
	}
	
	
	
	
	
	
	
	
}
