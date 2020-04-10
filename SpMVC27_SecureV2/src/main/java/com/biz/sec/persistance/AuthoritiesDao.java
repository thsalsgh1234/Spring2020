package com.biz.sec.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.sec.domain.AuthorityVO;

public interface AuthoritiesDao {
	
	/*
	 * 사용자이름으로 권한 테이블에서 권한 리스트를 SELECT 
	 */
	
	@Select("SELECT * FROM authorities "
			+ "WHERE username = #{username} ")
	List<AuthorityVO> findByUserName(String username);
}
