package com.biz.sec;

public class Main_02 {

	/*
	 * 기본형 변수, 객체, 배열 등을 모두 변수라고 할수 있다.
	 * 
	 * 
	 * 참조형 변수
	 * 객체나, 배열은 method로 해당 객체나 배열을 전달하고
	 * method에서 객체나 배열의 일부 요소의 값을 변경하면
	 * 원본의 객체나, 배열에 변경한 값이 반영이된다.
	 * 
	 * 기본 형 변수 primitive 형 변수
	 * int, char, long, double 등등으로 만든 변수는
	 * method로 전달하여 method 내에서 값을 변경하여도
	 * 원본은 절대 변경되지 않는다
	 * 
	 */
	
	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.addr);
		sub(test);
		System.out.println(test.addr);
		
		int[] num = new int[5];
		sub(num);
		System.out.println(num[3]);
		
		
		
	}
	
	public static void sub(int[] num) {
		num[3] = 100;
	}
	
	public static void sub(Test t1) {
		t1.addr = "광주광역시";
	}
	
}


class Test {
	
	String name;
	String addr;
	String phone;
	
}
