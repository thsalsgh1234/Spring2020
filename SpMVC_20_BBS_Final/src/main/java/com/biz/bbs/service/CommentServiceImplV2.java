package com.biz.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.bbs.domain.CommentVO;
import com.biz.bbs.repository.CommentDao;

@Service("cmtV2")
public class CommentServiceImplV2 extends CommentServiceImpl{

	/*
	 * 상속받은 클래스에서
	 * 부모클래스에 protected로 선언된 변수를 초기화 시키는
	 * 생성자 코드
	 */
	public CommentServiceImplV2(CommentDao cmtDao) {
		super(cmtDao);
	}

	@Override
	public List<CommentVO> findByBId(long c_b_id) {

		List<CommentVO> cmtList = cmtDao.findByBIdLevel(c_b_id);
		
		return cmtList;
	}
	
	
	
}
