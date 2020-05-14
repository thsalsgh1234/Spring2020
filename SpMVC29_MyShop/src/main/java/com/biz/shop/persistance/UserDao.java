package com.biz.shop.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.shop.domain.UserDetailsVO;

public interface UserDao {

	@Select("SELECT user_name as username, "
			+ "user_pass as password,"
			+ "enabled FROM tbl_users ")
	public List<UserDetailsVO> selectAll();
	
	
	// 동적 쿼리 문자열을 받아서 테이블을 생성하는 쿼리
	@Select(" ${create_table_query} ")
	public void create_table(String create_table_query) ;
	
	
}






