package com.biz.models.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.biz.models.domain.UsersVO;

@Repository
public interface UserDao {
	
	@Select("SELECT * FROM tbl_user WHERE userId = #{userId} ")
	public UsersVO findByUserId(String userId);
	
//	@Insert(" INSERT INTO tbl_user" + 
//			" (userId," + 
//			" password," + 
//			" userName," + 
//			" userRolle)" + 
//			" VALUES (" + 
//			" #{userId}," + 
//			" #{password}," + 
//			" #{userName}," + 
//			" #{userRolle})")
	public int insert(UsersVO usersVO);
	
	@Delete("DELETE FROM tbl_user WHERE userId = #{userId}" )
	public int delete(String userId) ;
	
	
	
}






