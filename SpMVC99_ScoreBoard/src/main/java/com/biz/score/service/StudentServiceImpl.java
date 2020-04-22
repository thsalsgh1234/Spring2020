package com.biz.score.service;

import java.util.List;

import com.biz.score.domain.StudentVO;
import com.biz.score.persistence.StudentDao;

public class StudentServiceImpl implements StudentService {

	protected final StudentDao studentdao = null;
	
	@Override
	public List<StudentVO> selectAll() {
		return studentdao.selectAll();
	}

	@Override
	public StudentVO findById(long st_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(StudentVO studentvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long st_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(StudentVO studentvo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
