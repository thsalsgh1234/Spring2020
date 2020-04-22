package com.biz.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.biz.score.domain.StudentVO;
import com.biz.score.persistence.StudentDao;

import lombok.extern.slf4j.Slf4j;


@Service
@Repository
@Slf4j
public class StudentService {
	
	StudentDao sDao;
	
	@Autowired
	public StudentService(StudentDao sDao) {
		super();
		this.sDao = sDao;
	}
	public List<StudentVO> selectAll(){
		return sDao.selectAll();
	}
	
	
	
}
