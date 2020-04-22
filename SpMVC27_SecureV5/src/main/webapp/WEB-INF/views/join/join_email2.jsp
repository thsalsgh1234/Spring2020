<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<style>
section.email_body {
	width: 80%;
	margin: 120px auto;
	display: flex;
	flex-flow: column;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>

	<section class="email_body">
		<h2>Email 인증</h2>
		<div>회원가입을 완료하려면 Email 인증을 수행해야 합니다</div>
		<form:form action="${rootPath}/join/joinok" 
				modelAttribute="userVO">
			<form:input type="email" path="email" 
					placeholder="email" />
			<c:if test="${empty userVO.email}">		
				<button>인증 Email 보내기</button>
			</c:if>
			<c:if test="${not empty userVO.email}">
				<button>인증 Email 다시 보내기</button>
			</c:if>
			<c:choose>
				<c:when test="${JOIN == 'EMAIL_OK'}">
					<button>인증 Email 다시 보내기</button>
				</c:when>
				<c:otherwise>
					<button>인증 Email 보내기</button>
				</c:otherwise>
			</c:choose>
		</form:form>
	</section>

</body>
</html>




