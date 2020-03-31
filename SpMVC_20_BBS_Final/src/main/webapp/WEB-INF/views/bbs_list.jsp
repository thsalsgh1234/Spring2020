<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
	<script>
	$(function(){
		$("button.btn-writer").click(function(){
			document.location.href="${rootPath}/insert";
		})
	})
	</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<section class="container-fluid">
		<article>
			<table class="table table-striped table-hover">
				<tr>
					<th>NO</th>
					<th>작성자</th>
					<th>일시</th>
					<th>제목</th>
				</tr>
				<c:forEach items="${BBS_LIST}" 
							var="BBS" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${BBS.b_writer}</td>
					<td>${BBS.b_date_time}</td>
					<td>
					<a href="${rootPath}/detail?b_id=${BBS.b_id}">
					${BBS.b_subject}
					</a></td>
				</tr>
				</c:forEach>
			</table>
		</article>
		<article class="d-flex justify-content-end">
			<button class="btn btn-primary text-white btn-writer">글쓰기</button>		
		</article>
	</section>
</body>
</html>
