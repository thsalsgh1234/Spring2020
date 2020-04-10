package com.biz.sec.persistance;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.biz.sec.domain.UserVO;

public interface UserDao {

	public List<UserVO> selectAll();
	
	@Select("SELECT user_name AS username "
			+ " FROM tbl_users WHERE user_name = #{username} ")
	public String findByUserName(String username);
	
	public int insert(Map<String,String> userMap);
	
}












