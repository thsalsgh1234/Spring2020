<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${rootPath}/readbook/book/create">
		<input name="b_code" placeholder="도서코드">
		<input name="b_name" placeholder="도서이름">
		<input name="b_comp" placeholder="출판사">
		<input name="b_auther" placeholder="저자">
		<input name="b_year" placeholder="발행년도">
		<input name="b_iprice" placeholder="구입가격">
		<button>저장</button>
	</form>
</body>
</html>