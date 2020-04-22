package com.biz.sec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_03 {

	public static void main(String[] args) {

		Integer[] num = new Integer[3];
		num[0] = 100;
		num[1] = 100;
		num[2] = 100;
		
		// num 배열을 List형 객체로 변경
		// Arrays.asList(배열) : 실제 완전한 List로 변경이 아니다
		// 		무니만 List
		// 이 method로 변경된 List는 추가, 삭제, 내용변경이 불가
		// 완전한 List 형으로 변경하기 위해서는
		// 		ArrayList, LinkedList 등의 생성자를 사용해서
		// 		List로 변경해주는 절차가 필요하다
		List<Integer> numList 
			= new ArrayList<>(Arrays.asList(num));
		
	}
}






