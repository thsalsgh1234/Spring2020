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
	
	background: #191919;
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
		document.location.href="${rootPath}/auth/join"
	})
	
	$("#btn-login").click(function(){
		// 유효성검사
		// id, password가 입력되지 않았을때 경고
		let u_id = $("#u_id").val()
		if(u_id == "") {
			alert("아이디를 입력하세요")
			$("#u_id").focus()
			return false;
		}
		
		var params = $("form").serialize();
		$.ajax({
			url : "${rootPath}/rest/member/login",
			type:'POST',
			data:params,
			success:function(result) {
				alert(result)
				document.location.href 
					= document.location.href
			}
		})
		
		/*
		$.post("${rootPath}/rest/member/login",
				$("form").serialize(),
				function(result) {
					alert(result)
					document.location.href = document.location.href
					// alert(result)
				}
		)
		*/
	})
})
</script>
	<form:form method="POST" action="${rootPath}/login" class="login-form">
		<h2>로그인</h2>
		<c:if test="${param.error != null}">		
			<h3>아이디나 비번이 잘못되었습니다.</h3>
		</c:if>
		<c:if test="${LOGIN_MSG == 'TRY' }">		
			<h3>로그인을 해야 합니다.</h3>
		</c:if>
		<c:if test="${LOGIN_MSG == 'NO_AUTH' }">		
			<h3>작성자 만이 볼수 있음!!!</h3>
		</c:if>
		<c:if test="${LOGIN_MSG == '0' }">		
			<h3>로그인을 환영합니다.</h3>
		</c:if>
		<!-- spring form tag를 사용하면 생략가능 -->
		
		<input type="hidden" 
				name="${_csrf.parameterName}" 
				value="${_csrf.token}">
				
		<input type="text" id="username" name="username" placeholder="사용자 ID">
		<input type="password" id="password" name="password" placeholder="비밀번호">
		<button type="submit" id="btn-login-s">로그인</button>
		<button type="button" id="btn-join">회원가입</button>
		
	</form:form>
	
	

	
	
	
	