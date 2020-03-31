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
<h3>학생점수</h3>
<form action="/app/number/score_input" method=POST>
	<label>국어</label><input name="kor" placeholder="국어점수" value="${scoreVO.kor}" default="0"><br>
	<label>영어</label><input name="eng" placeholder="영어점수" value="${scoreVO.eng}" default="0"><br>
	<label>수학</label><input name="math" placeholder="수학점수" value="${scoreVO.math}" default="0"><br>
	<label>과학</label><input name="sci" placeholder="과학점수" value="${scoreVO.sci}" default="0"><br>
	<label>음악</label><input name="music" placeholder="음악점수" value="${scoreVO.music}" default="0"><br>
	<button>계산</button>
</form>
<div><b>총점</b> :${scoreVO.sum} </div>
<div><b>평균</b> :${scoreVO.avg} </div>

</body>
</html>