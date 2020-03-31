package com.biz.models.service;

import org.springframework.stereotype.Service;

import com.biz.models.dao.UserDao;
import com.biz.models.domain.UsersVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserDao userDao;
	
	/*
	 * TDD(테스트 주도형 개발 , Test Driven Developer)
	 * 1. 클래스와 필요한 method의 이름만 만들고
	 * 2. 필요에 따라 매개변수와 리턴 값만 설정한다.
	 * 3. Test에서 매개변수를 주입했을때 return되는 값이 일치함을 테스트하는 코드를 작성한 후
	 * 4. 실제 클래스에서 가상의 일치하는 데이터를 만들고
	 * 5. 데이터를 return 하도록 코드를 작성
	 * 6. 그리고 테스트를 수행하여, 통과되도록 코드를 리팩토링하여
	 * 7. 임시로 클래스를 완성한다.
	 * 
	 * 원래는 Dao에서 데이터를 가져온 후 ID에 따라 사용자 ID와 사용자 이름이
	 * 일치하는 Test Code를 작성해둔 상태이다.
	 * 1. Dao에 데이터를 저장할떄 테스트 코드가 통과될수 있는 데이터를 INSERT한 후 
	 * 2. 다시한번 테스트를 수행하여 Dao와 연동되는 것을 계속해서 획인 한다.
	 */
	public UsersVO getUser(String userId) {
//		UsersVO userVO = UsersVO.builder()
//				.userId("admin")
//				.passWord("12345")
//				.userName("홍길동")
//				.userRolle("admin")
//				.build();
		
		UsersVO userVO = userDao.findByUserID("admin");
		if(userId.equals("admin")) {
			return userVO;
			
		}else if(userId.equals("guest")) {
			
//			userVO.setUserId("guest");
//			userVO.setUserName("성춘향");
			userVO = userDao.findByUserID("guest");
			
		}else if(userId.equals("dba")) {
			
//			userVO.setUserId("dba");
//			userVO.setUserName("이몽룡");
			userVO = userDao.findByUserID("dba");
			
		}else {
			userVO = null;
		}
		
		 return userVO;	
		}
	/*
	 *  insert mehtod는 UsersVO에 담긴 데이터를 받아서
	 *  insert를 수행한 후 결과를 return 하도록 되어있다.
	 *  return 한 값은 데이터가 1개 이므로 정수 1이(0보다 큰값) 된다.
	 *  이러한 TestCode를 만들기 위해서 일단 가상으로 return 1의 코드를 추가한다.
	 */
	public int insert(UsersVO userVO) {
		
		return userDao.insert(userVO);
	}
	public int delete(String userId) {
		
		return userDao.delete(userId);
		
	}
	
}
