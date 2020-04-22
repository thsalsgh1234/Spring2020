package com.biz.models.service;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.biz.models.domain.UsersVO;

// 이름순으로 오름차순으로 실행하라
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		
		locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/*-context.xml"}
		
		)
public class UserServiceTest {
	
	@Autowired
	UserService userService;

	@Test
	public void c_getUserTest() {
		
		UsersVO userVO = userService.getUser("admin");
		assertEquals(userVO.getUserId(),"admin");
		assertEquals(userVO.getUserName(),"홍길동");
		
		userVO = userService.getUser("guest");
		assertEquals(userVO.getUserId(),"guest");
		assertEquals(userVO.getUserName(),"성춘향");

		userVO = userService.getUser("dba");
		assertEquals(userVO.getUserId(),"dba");
		assertEquals(userVO.getUserName(),"이몽룡");
		
	}
	
	@Test
	public void b_insertTest() {
		
		UsersVO userVO = UsersVO.builder()
				.userId("korea")
				.password("12345")
				.userName("대한민국")
				.userRolle("gov")
				.build();
		
		int ret = userService.insert(userVO);
		
		// ret 값이 1이며 오차가 없는 결과를 받았느냐 라고
		// Test를 수행한다.
		assertEquals(ret,1,0);
		
		userVO = UsersVO.builder()
				.userId("admin")
				.password("12345")
				.userName("홍길동")
				.userRolle("admin")
				.build();
		ret = userService.insert(userVO);
		assertEquals(ret, 1,0);

		userVO = UsersVO.builder()
				.userId("guest")
				.password("12345")
				.userName("성춘향")
				.userRolle("guest")
				.build();
		ret = userService.insert(userVO);
		assertEquals(ret, 1,0);

		userVO = UsersVO.builder()
				.userId("dba")
				.password("12345")
				.userName("이몽룡")
				.userRolle("dba")
				.build();
		ret = userService.insert(userVO);
		assertEquals(ret, 1,0);
		
	}
	
	@Test
	public void a_deleteTest() {
		
		int ret = userService.delete("admin");
		ret = userService.delete("guest");
		ret = userService.delete("dba");
		ret = userService.delete("korea");
		
		assertEquals(ret, 1,0);

		
	}
}








