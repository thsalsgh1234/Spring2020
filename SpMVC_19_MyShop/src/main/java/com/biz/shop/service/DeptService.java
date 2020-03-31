package com.biz.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.shop.dao.DeptDao;
import com.biz.shop.domain.DeptVO;
import com.biz.shop.persistance.DeptRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeptService {

	private final DeptRepository deptRepo;
	private final DeptDao deptDao;

	public List<DeptVO> selectAll() {
		List<DeptVO> deptList = deptRepo.findAll();
		return deptList;
	}

	public DeptVO save(DeptVO deptVO) {
		DeptVO ret = deptRepo.save(deptVO);
		
		return ret;
	}

	public DeptVO search(String d_code) {

		// return deptDao.findByD_Code(d_code);
		return null;
	}

	public List<DeptVO> findByDName(String search) {
		return deptDao.findByDName(search);
	}
}
