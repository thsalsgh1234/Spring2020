<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<style>
* {
	margin:0;
	padding:0;
	box-sizing: border-box;
}

.login-form {
	
	width:400px;
	padding:40px;
	
	background: blue;
	text-align: center;
	z-index: 10;
	
	border-radius: 20px;
	box-shadow: 12px 12px 2px 1px rgba(0,0,255,0.2);
	
	margin:20px auto;

}

.login-form h2 {
	color:white;
	font-weight: 500;
}

.login-form h3 {
	color:white;
	font-weight: 300;
	background-color: red;
	border-radius: 20px;
}

.login-form input {
	
	background: none;
	margin:20px auto;
	text-align: center;
	
	border:2px solid #3498db;
	
	padding:14px 10px;
	width:200px;
	outline: none;
	color:white;
	
	border-radius: 25px;
	transition : 0.2s;
	
}

.login-form input:focus {
	width: 280px;
	border-color: #2ECC71;
}

.login-form button {
	
	border:2px solid #2ECC71;
	padding:14px 40px;
	background: none;
	display: block;
	margin:20px auto;
	padding:14px 40px;
	
	outline: none;
	color:white;
	
	border-radius: 25px;
	
	cursor: pointer;
}

.login-form button:hover {
	background-color: #2ECC71;
}

.naver_login img {
	border-radius: 10px;
}

/*
 div box에 image를 2개 가져오고
 초기에는 2번째 이미지를 감춰둔다
*/
.naver_login img:last-child {
	display: none;
}

/*
마우스를 div box에 올리면
처음 이미지는 감추고, 두번째 이미지는 보여라
*/
.naver_login:hover img:last-child {
	display: inline-block;
}

.naver_login:hover img:first-child {
	display: none;
}



</style>
<script>
$(function(){
	
	$("#btn-join").click(function(){

		// 유효성검사
		// id, password가 입력되지 않았을때 경고
		let username = $("#username")
		let password = $("#password")
		let re_password = $("#re_password")
		
		if(username.val() == "") {
			alert("아이디를 입력하세요")
			username.focus()
			return false;
		}

		if(password.val() == "") {
			alert("비밀번호를 입력하세요")
			password.focus()
			return false;
		}

		if(re_password.val() == "") {
			alert("비밀번호 확인 입력하세요")
			re_password.focus()
			return false;
		}

		if(password.val() != re_password.val()) {
			alert("비밀번호와 비빌번호 확인이 다릅니다")
			password.focus()
			return false;
		}
		$("form").submit()

		
	})
})
</script>
	<form:form method="POST" action="${rootPath}/auth/join" 
								class="login-form">
		<h2>회원가입</h2>
				
		<input type="text" id="username" 
					name="username" placeholder="사용자 ID">
		<input type="password" id="password" 
					name="password" placeholder="비밀번호">
		<input type="password" id="re_password" 
					name="re_password" placeholder="비밀번호 한번 더~~">
					
		<button type="button" id="btn-join">회원가입</button>
	</form:form>
