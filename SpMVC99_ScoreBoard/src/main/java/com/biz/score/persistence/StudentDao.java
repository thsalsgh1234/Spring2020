package com.biz.score.persistence;

import java.util.List;

import com.biz.score.domain.StudentVO;

public interface StudentDao {

	
	public List<StudentVO> selectAll();
	
	
	public StudentVO findById(long st_id);
	
	
	public int insert(StudentVO studentvo);
	
	
	public int delete(long st_id);
	public int update(StudentVO studentvo);
}
