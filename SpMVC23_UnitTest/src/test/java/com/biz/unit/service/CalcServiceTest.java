package com.biz.unit.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalcServiceTest {

	CalcService cs = null;
	
	/*
	 * 현재 test케이스에서 공통으로 사용할
	 * 변수, 객체등을 생성하는 초기화 method
	 * test 객체가 작동될때 최초 한번 실행하는 method
	 */
	@Before
	public void setUp() {
		cs = new CalcService();
	}
	
	/*
	 * 각 클래스에 정의된 method를 테스트수행
	 */
	@Test
	public void timesTest() {
		int result = cs.times(20, 30);
		// assertEquals(예상답안, 계산결과, 허용오차)
		assertEquals(600, result,0);
	}
	
	@Test
	public void sumTest() {
		int result = cs.sum(20, 30);
		assertEquals(50, result,0);
	}

	@Test
	public void timesTest1() {
		int[][] testCase = { 
				{384,236,90624},
				{349,371,129479},
				{424,217,92008},
				{479,426,204054},
				{442,270,119340},
				{327,403,131781},
				{321,305,97905},
				{191,345,65895},
				{366,219,80154},
				{128,420,53760},
				{208,110,22880},
				{217,104,22568},
				{271,128,34688},
				{369,191,70479},
				{497,367,182399},
				{162,371,60102},
				{375,134,50250},
				{275,391,107525},
				{266,382,101612},
				{130,210,27300},
				{495,313,154935},
				{115,413,47495},
				{286,108,30888},
				{455,324,147420},
				{423,245,103635},
				{127,351,44577},
				{276,469,129444},
				{187,290,54230},
				{477,446,212742}
			};
		
		for(int i = 0 ; i < testCase.length ; i++) {
			int result = cs.times(testCase[i][0], testCase[i][1]);
			assertEquals(testCase[i][2], result,0);
		}
	}

	
	
}
