package com.biz.readbook.persistence;

import java.util.List;

import com.biz.readbook.domain.ReadBookVO;

public interface ReadBookDao {
	
	public List<ReadBookVO> selectAll();
	
	public ReadBookVO findById(String b_code);
	
	public int insert(ReadBookVO RVO);
	
	public int update(ReadBookVO RVO);
	
	public int delete(String bCode);
		
	
}
