package com.biz.readbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.readbook.domain.ReadBookVO;
import com.biz.readbook.persistence.ReadBookDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReadBookService {

	private final ReadBookDao rDao;
	
	
	public List<ReadBookVO> allSelect(){
		return rDao.selectAll();
	};
	
	public int insert(ReadBookVO rVO) {
		return rDao.insert(rVO);
	}
	
	public int update(ReadBookVO rVO) {
		return rDao.update(rVO);
	}
	
	public int delete(String bCode) {
		return rDao.delete(bCode);
	}

	public ReadBookVO findByBCode(String b_code) {
		// TODO Auto-generated method stub
		return rDao.findById(b_code);
	}
	
}
