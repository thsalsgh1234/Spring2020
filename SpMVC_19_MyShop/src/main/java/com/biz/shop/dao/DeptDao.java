package com.biz.shop.dao;

import java.util.List;

import com.biz.shop.domain.DeptVO;

public interface DeptDao {
	
	public List<DeptVO> findByDName(String d_name);

}
