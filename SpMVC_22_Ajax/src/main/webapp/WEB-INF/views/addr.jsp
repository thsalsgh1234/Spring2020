<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<tr>
		<th>이름</th>
		<td id="ad_name">${vo.ad_name}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${vo.ad_addr}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${vo.ad_tel}</td>
	</tr>
	<tr>
		<th>나이</th>
		<td>${vo.ad_age}</td>
	</tr>
</table>