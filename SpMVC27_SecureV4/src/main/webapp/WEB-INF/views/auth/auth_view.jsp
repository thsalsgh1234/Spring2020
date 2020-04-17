<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<style>
#body{
	position: fixed;
	top: 60px;
	left: 0;
	width: 100%;
}

</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<section id="body">
	<h1>로그인 동적 정보 보기</h1>
	
	<sec:authorize access="isAnonymous()">
		<p>로그인 하지 않았을때 보이는 정보</p>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<h3>로그인 했을때 보이는 정보</h3>
		<p>Principal:</p>
			<sec:authentication property="principal"/>
			
			<p>로그인 User name:<p>
			<sec:authentication property="principal.username"/>
			
			<p>로그인 User 비밀번호:<p>
			<sec:authentication property="principal.password"/>
			
			<p>로그인 User E-mail:<p>
			<sec:authentication property="principal.email"/>
			
			<p>로그인  전화번호:<p>
			<sec:authentication property="principal.phone"/>
			
			<p>로그인  주소:<p>
			<sec:authentication property="principal.address"/>
			
			<p>권한 리스트:<p>
			<sec:authentication property="principal.authorities"/>
			
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h3>Admin으로 로그인 했을때 보이는 정보</h3>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_USER')">
		<h3>User로 로그인 했을때 보이는 정보</h3>
	</sec:authorize>
	
	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
		<h3>Admin이나 User로 로그인 했을때 보이는 정보</h3>
	</sec:authorize>
</section>
</body>
</html>