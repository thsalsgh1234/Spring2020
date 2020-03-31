<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		border: solid 1px red;
	}
	
</style>
<script>
	$(function(){
		$("#btn-insert").click(function(){
			document.location.href="${rootPath}/book/insert"
		})
		$(".btn-modify").click(function(){	
			var code1 = $(this).data("id")
			document.location.href="${rootPath}/book/update?bCode=" + code1 
		})
		$(".btn-delete").click(function(){
			if(confirm("진짜 지울래요?")){
				var code1 = $(this).data("id")
				document.location.href="${rootPath}/book/delete?bCode=" + code1 
			}
		})
	})
</script>
</head>
<body>
<h1> 도서 관리 리스트</h1>

<table>
		<c:choose>
			<c:when test="${empty readbooklist}">
				<tr><td colspan="5">데이터가 없습니다</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="b" items="${readbooklist}" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td data-id="${b.b_code}">${b.b_code}</td>
						<td>${b.b_name}</td>
						<td>${b.b_auther}</td>
						<td>${b.b_comp}</td>
						<td>${b.b_year}</td>
						<td>${b.b_iprice}</td>
						<td><button type="button" class="btn-modify" data-id="${b.b_code}">자료 수정</button></td>
						<td><button type="button" class="btn-delete" data-id="${b.b_code}">자료 삭제</button></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</table>
		<button type="button" id="btn-insert">자료 입력</button>
</body>
</html>