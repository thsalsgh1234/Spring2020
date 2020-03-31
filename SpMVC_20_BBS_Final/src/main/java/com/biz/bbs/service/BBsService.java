package com.biz.bbs.service;

import java.util.List;

import com.biz.bbs.domain.BBsVO;

/*
 * interface 
 * 1. 클래스의 모델의 설계도 역할
 * 2. 필수로 작성해야할 method를 정의하는 용도
 * 3. 팀프로젝트 수행에서 미리 설계된 인터페이스를 상대로
 * 		다른 모듈을 구현하면, 아직 기능구현은 되지 않았어도
 * 		method가 없어서 발생한는 문법적 오류 없이
 * 		기능을 구현할수 있다.
 */
public interface BBsService {
	
	public List<BBsVO> selectAll();
	public BBsVO findById(long b_id);
	
	public List<BBsVO> findBySubject(String b_subject);
	public List<BBsVO> findByWriter(String b_writer);
	
	public int insert(BBsVO bbsVO);
	public int delete(long b_id);
	public int update(BBsVO bbsVO);
	
}
