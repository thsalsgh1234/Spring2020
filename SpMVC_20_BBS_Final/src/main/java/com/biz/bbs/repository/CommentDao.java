package com.biz.bbs.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.domain.CommentVO;

public interface CommentDao {

	public List<CommentVO> selectAll();
	public CommentVO findById(long c_id);
	
	
	/*
	 * 오라클의 쿼리를 이용하여 계층형 코멘트 데이터 추출
	 */
	public List<CommentVO> findByBIdLevel(long c_b_id);
	
	/*
	 * 
	 * 게시판 원글에 달린 코멘트 들만 추출하기
	 * 
	 */
	@Select("SELECT * FROM tbl_comment "
			+ " WHERE c_b_id = #{c_b_id}  "
			+ " AND c_p_id = 0 "
			+ " ORDER BY c_date_time DESC ")
	public List<CommentVO> findByBId(long c_b_id);
	
	@Select("SELECT * FROM tbl_comment "
			+ " WHERE c_p_id = #{c_p_id} "
			+ " ORDER BY c_date_time DESC ")
	public List<CommentVO> findByPId(long c_p_id);
	
	
	public int insert(CommentVO commentVO);
	public int update(CommentVO commentVO);
	
	@Delete("DELETE FROM tbl_comment WHERE c_id = #{c_id}")
	public int delete(long c_id);
	
	
}
