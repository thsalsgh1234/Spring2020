package com.biz.app;

public class ScoreVO {

	private int Kor;
	private int eng;
	private int math;
	private int sci;
	private int music;

	private int sum;
	private int avg;
	
	
	
	public ScoreVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScoreVO(int kor, int eng, int math, int sci, int music, int sum, int avg) {
		super();
		Kor = kor;
		this.eng = eng;
		this.math = math;
		this.sci = sci;
		this.music = music;
		this.sum = sum;
		this.avg = avg;
	}
	public int getKor() {
		return Kor;
	}
	public void setKor(int kor) {
		Kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSci() {
		return sci;
	}
	public void setSci(int sci) {
		this.sci = sci;
	}
	public int getMusic() {
		return music;
	}
	public void setMusic(int music) {
		this.music = music;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "ScoreVO [Kor=" + Kor + ", eng=" + eng + ", math=" + math + ", sci=" + sci + ", music=" + music
				+ ", sum=" + sum + ", avg=" + avg + "]";
	}

}
