package com.biz.sec.persistance;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.biz.sec.domain.UserVO;

public interface UserDao {

	public List<UserVO> selectAll();
	
	@Select("SELECT user_name AS username, "
			+ " user_pass AS password,"
			+ " enabled "
			+ " FROM tbl_users WHERE user_name = #{username} ")
	public UserVO findByUserName(String username);
	
	public int insert(UserVO userVO);
	
}












