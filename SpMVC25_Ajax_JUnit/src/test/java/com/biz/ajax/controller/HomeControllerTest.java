package com.biz.ajax.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/*
 * *.class 형식의 코드
 * 매개변수로 실제 *.class 파일을 직접 주입하고
 * 그 파일을 실행하여 결과를 스스로 알아서 가져가라
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}
		)
public class HomeControllerTest {

	/*
	 * 가상의 Mock 클래스를 생성하고, 의존성 주입을 하기 위한 도구
	 */
	MockMvc mockMvc;
	
	/*
	 * HomeController를 단독으로 테스트 하겠다
	 */
	@InjectMocks
	private HomeController hcontroller;
	
	@Before
	public void setUp() throws Exception {
		
		// @InjectMocks로 설정한 class의 의존성주입
		// HomeController를 사용할 수 있도록 초기화
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(hcontroller).build();
		
	}

	@Test
	public void testHome() throws Exception {
		
		System.out.println();
		
		// http://localhost:8080/로 request 요청하라
		// controller가 상태코드를 200(OK) response 했느냐 ?
		// 라고 test를 수행
		mockMvc.perform(get("/"))
		
		// Controller에서 응답코드가 200?
		.andExpect(status().isOk())
		
		// Controller가 마지막에 return한 view가 home.jsp ? 
		.andExpect(view().name("home"));
		
	}

}







