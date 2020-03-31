package com.biz.naver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 공통된 부분삭제
public class NaverVO {
	
	// 뉴스
	private String title;			//: "김현숙 새만금청장 &quot;힘내세요! 선유도 보건지소&quot;",
	private String originallink;	//: "http://www.m-i.kr/news/articleView.html?idxno=692485",
	private String link;			//: "http://www.m-i.kr/news/articleView.html?idxno=692485",
	private String description;		//: "김현숙 새만금청장은 18일 군산시 선유도 보건지소를 방문, <b>코로나</b>19 방역 실태를 확인하고 직원들을 격려하고 있다. 사진=새만금개발청  김현숙 새만금개발청장은 18일 군산시 선유도 보건지소를 방문, <b>코로나</b>19 방역... ",
	private String pubDate;			//: "Wed, 18 Mar 2020 13:27:00 +0900"
	
	// 영화
	private String image;
	private String subtitle;
	private String director;
	private String actor;
	private String userRating;
	
	
	//도서
	private String author;
	private String price;
	private String discount;
	private String publisher;
	private String pubdate;
	private String isbn;
	
}
