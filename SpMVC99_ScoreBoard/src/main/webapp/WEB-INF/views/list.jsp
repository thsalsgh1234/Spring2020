<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>학생리스트</title>
</head>
<body>
	<h2 class="w3-container w3-teal">학생리스트</h2>
	<section>
	<table class="w3-table-all">
		
			<tr class="w3-red">
				<th>학번</th>
				<th>이름</th>
				<th>학년</th>
				<th>반</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>석차</th>
			</tr>
		<c:forEach items="">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		</c:forEach>

	</table>
</section>
</body>
</html>