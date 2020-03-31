package com.biz.shop.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.shop.domain.CartVO;

/*
 * hibernation에서 기본적으로 제공하는 CRUD를 사용하기 위해서
 * JpaRepository를 상속받는데
 * 		<사용할VO, PK의 Type>을 Generic으로 지정한다.
 * 
 * PK type에서 primitive 형식으로 지정하지 말고
 * wrapper class 형식으로 지정하자
 * 
 * =====================================
 * primitive		wrapper class
 * -------------------------------------
 * int				Integer
 * float			Float
 * long				Long
 * double			Double
 * char				Character
 * 문자열			String
 * boolean			Boolean
 * ======================================
 */
public interface CartRepository 
		extends JpaRepository<CartVO, Long>{

	// C(R)UD의 기본 method가 준비되어 있다.
	
}
		
		
		
		
		
		
		
		
