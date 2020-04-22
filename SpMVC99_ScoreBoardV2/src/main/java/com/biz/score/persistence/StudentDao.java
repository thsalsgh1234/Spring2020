package com.biz.score.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.biz.score.domain.StudentVO;


@Repository
public interface StudentDao {

	
	List<StudentVO> selectAll();
	
	
	public StudentVO findById(long st_id);
	
	
	public int insert(StudentVO studentvo);
	
	
	public int delete(long st_id);
	public int update(StudentVO studentvo);
}
