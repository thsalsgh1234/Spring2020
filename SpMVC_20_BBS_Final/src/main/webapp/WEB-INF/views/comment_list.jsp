<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<c:forEach items="${CMT_LIST}" var="CMT">
	<div class="row p-2 bg-light cmt-item" data-id="${CMT.c_id}">
		<div class="col-2 writer"><b>${CMT.c_writer}</b></div>
		<div class="col-7 subject">${CMT.c_subject}</div>
		<div class="col-1 cmt-item-repl"><b>답변</b></div>
		<div class="col-1 cmt-item-del"><b>&times;</b></div>
	</div>
</c:forEach>
