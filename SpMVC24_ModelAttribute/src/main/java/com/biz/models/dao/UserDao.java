package com.biz.models.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.biz.models.domain.UsersVO;

public interface UserDao {

	@Select("SELECT * FROM tbl_user WHERE userId = #{userId}")
	public UsersVO findByUserID(String userId);
	
	@Insert(" INSERT INTO tbl_user" + 
			" (userId," + 
			" passWord," + 
			" userName," + 
			" userRolle)" + 
			" VALUES" + 
			" (#{userId}," + 
			" #{passWord}," + 
			" #{userName}," + 
			" #{userRolle})")
	public int insert(UsersVO userVO);
	
	@Delete("DELETE FROM tbl_user WHERE userId = #{userId}")
	public int delete(String userId);
	
}
