package com.biz.score.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.score.domain.StudentVO;

@Service
public interface StudentService {
	
	
	public List<StudentVO> selectAll();
	
	
	public StudentVO findById(long st_id);
	
	
	public int insert(StudentVO studentvo);
	
	
	public int delete(long st_id);
	public int update(StudentVO studentvo);
}
