<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>처리결과</title>
</head>
<body>
	<h2 class="w3-container w3-teal">나의성적처리</h2>
	<form class="w3-container" action="">

		<label class="w3-text-blue"><b>학번</b></label><input class="w3-input w3-border w3-light-grey" type="text">
		<label class="w3-text-blue"><b>이름</b></label><input class="w3-input w3-border w3-light-grey" type="text">
		<label class="w3-text-blue"><b>학년</b></label><input class="w3-input w3-border w3-light-grey" type="text">
		<label class="w3-text-blue"><b>반</b></label><input class="w3-input w3-border w3-light-grey" type="text">
		<label class="w3-text-blue"><b>국어</b></label><input class="w3-input w3-border w3-light-grey" type="text">
		<label class="w3-text-blue"><b>영어</b></label><input class="w3-input w3-border w3-light-grey" type="text">
		<label class="w3-text-blue"><b>수학</b></label><input class="w3-input w3-border w3-light-grey" type="text">
		<label class="w3-text-blue"><b>총점</b></label><input class="w3-input w3-border w3-light-grey" type="text">
		<label class="w3-text-blue"><b>평균</b></label><input class="w3-input w3-border w3-light-grey" type="text">
		<label class="w3-text-blue"><b>석차</b></label><input class="w3-input w3-border w3-light-grey" type="text">
		<button class="w3-btn w3-green">전체리스트보기</button>

	</form>
</body>
</html>