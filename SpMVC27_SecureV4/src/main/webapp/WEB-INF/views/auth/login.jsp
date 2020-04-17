<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<%@ taglib uri="http://www.springframework.org/security/tags" 
			prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 
			prefix="form" %>			

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>


<link rel="stylesheet"
	href="${rootPath}/resources/css/login.css?2020-04-09" />

<script>
$(function(){
	$(document).on("click","button.join",function(){
		document.location.href = "${rootPath}/user/join"		
	})
})

</script>	
</head>
<body>
	<section class="container">
		<form:form action="${rootPath}/login" method="POST" class="login_form">
			<h1>
				<span class="login">Log in</span> or <span class="sign-up">sign
					up</span>
			</h1>
			<div>
				<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}" >
					<span>${SPRING_SECURITY_LAST_EXCEPTION.message}</span>
				</c:if>
			</div>
			
			<div class="input_layout">
			
			<div class="input_box">
				<label id="username">UserName</label> 
				<input id="username" name="username" type="text"
					placeholder="User ID">
			</div>
			<div class="input_box">
				<label id="password">Password</label> 
				<input type="password" id="password"
					name="password" placeholder="비밀번호">
			</div>
			</div>
			<div class="button_box">
				<button class="login">로그인</button>
				<button class="join" type="button">회원가입</button>
			</div>
		</form:form>
	</section>


</body>
</html>



