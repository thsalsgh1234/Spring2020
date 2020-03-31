package com.biz.bbs.service;

import java.util.List;

import com.biz.bbs.domain.CommentVO;

public interface CommentService {

	public List<CommentVO> selectAll();
	public CommentVO findById(long c_id);
	
	/*
	 * 게시판 원글에 달린 코멘트 들만 추출하기
	 */
	public List<CommentVO> findByBId(long c_b_id);
	
	public List<CommentVO> findByPId(long c_p_id);
	
	public int insert(CommentVO commentVO);
	public int update(CommentVO commentVO);
	
	public int delete(long c_id);
	
}
