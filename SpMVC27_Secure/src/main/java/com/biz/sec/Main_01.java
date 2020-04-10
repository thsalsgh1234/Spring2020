package com.biz.sec;

public class Main_01 {
	public static void main(String[] args) {

		내클래스 나 = new 내클래스();
		나.나(); // 나는 누구인가 라는것이 출력될 것으로 생각
		나.너();

	}
}

class 내클래스 implements 내인터페이스{
	public String 나는() {
		// System.out.println("나는 누구인가");
		return "나는 누구인가";
	}

	@Override
	public String 너() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String 나() {
		// TODO Auto-generated method stub
		return null;
	}
}

interface 내인터페이스{
	public String 나();
	public String 너();
}


