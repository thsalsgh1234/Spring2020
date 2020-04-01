<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
</head>
<body>
	<form method="POST">
		<div>
			<input name="b_title" placeholder="도서명">
		
		</div>
		<div>
			<input name="b_comp" placeholder="출판사">
		
		</div>
		<div>
			<input name="b_isbn" placeholder="도서코드">
		
		</div>
		<div>
			<input name="b_price" placeholder="도서가격">
		
		</div>
		<button>전송</button>
		
	</form>
</body>
</html>