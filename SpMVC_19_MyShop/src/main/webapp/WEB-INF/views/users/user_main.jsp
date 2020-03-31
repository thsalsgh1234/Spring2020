<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" 
		prefix="sec"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Heroic Features - Start Bootstrap Template</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script>
$(function(){
	$("a.logout").click(function(){
		$("#logout").submit()
	})
})
</script>


</script>

</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">MY SHOP</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a class="nav-link" href="${rootPath}/user/product/list">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<sec:authorize access="isAnonymous()">	
							<li class="nav-item">
						<a  class="nav-link" href="${rootPath}/auth/login">로그인</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">

						<form id="logout" method="POST" action="${rootPath}/logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}">
							<li class="nav-item"><a class="nav-link logout" href="#">로그아웃</a></li>
						</form>

					</sec:authorize>
					<li class="nav-item">
							<a class="nav-link" 
								href="${rootPath}/user/product/cart_view">장바구니</a></li> 
					
					<sec:authorize access="hasRole('ADMIN')">
						<li class="nav-item">
							<a  class="nav-link" href="${rootPath}/admin/">관리자</a></li>
					</sec:authorize>	
					
					
					<li class="nav-item"><input type="text" name="search" class="search" >
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<section class="container">
		<c:choose>
			<c:when test="${BODY == 'DETAIL'}">
				<%@ include file="/WEB-INF/views/users/user_product_detail.jsp" %>
			</c:when>

			<c:when test="${BODY == 'CART_VIEW'}">
				<%@ include file="/WEB-INF/views/users/cart_view.jsp" %>
			</c:when>

			<c:otherwise>
				<%@ include file="/WEB-INF/views/users/user_product_list.jsp" %>
			</c:otherwise>
		</c:choose>	
	</section>
	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>

</body>

</html>