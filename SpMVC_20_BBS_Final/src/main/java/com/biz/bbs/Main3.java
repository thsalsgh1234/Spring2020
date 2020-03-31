package com.biz.bbs;

public class Main3 {
	public static void main(String[] args) {
		
		int sum = add(100);
		System.out.println(sum);
		
	}
	
	/*
	 * 최초에 add(10)이 main에서 호출
	 * 	 num 값은 10이 되고
	 * 	 if 문을 건너 뛰게 되고
	 * 	 	10 + add(10-1)의 리턴값을 덧셈
	 * 		9 + add(9-1)
	 * 		8 + add(8-1)
	 * 		7 + add(7-1)
	 * 		6 + add(6-1)
	 * 		5 + add(5-1)
	 * 		4 + add(4-1)
	 * 		3 + add(3-1)
	 * 		2 + add(2-1)
	 * 		1 + add(1-1)
	 */
	public static int add(int num) {
		
		if(num < 1) return 0;
		return num + add(num-1);
	
	}
}
