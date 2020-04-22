<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<script>
	$(function() {
		$("input").prop("readonly", true)

		$(document).on("click", "#btn_update", function() {
			let pass = $("#password").val()
			if (pass == "") {
				alert("수정하려면 비밀번호를 입력후 \n" + "다시 수정버튼을 클릭하세요")
				$("div.password").css("display", "block")
				$("#password").prop("readonly", false)
				$("#password").focus()
				return false;
			}
			if (pass != "") {

				$.ajax({
					url : '${rootPath}/user/password',
					method : 'POST',
					data : {
						password : pass,
						"${_csrf.parameterName}" : "${_csrf.token}"
					},
					success : function(result) {
						if (result == "PASS_OK") {

							$("input").prop("readonly", false)
							$("input").css("color", "blue")
							$("button#btn_save").prop("disabled", false)
							$("button#btn_update").prop("disabled", true)

						} else {
							alert("비밀번호가 일치하지 않습니다")
						}
					},
					error : function() {
						alert('서버 통신 오류')
					}
				})
			}
		})

	})
</script>
<style>
section {
	position: fixed;
	left: 0;
	width: 100%;
}

form.mypage-form {
	width: 70%;
	margin: 60px auto 30px;
	padding: 15px;
	position: relative;
	background: #fffaf6;
	border-radius: 4px;
	color: #7e7975;
	box-shadow: 0 2px 2px rgba(0, 0, 0, 0.2), 0 1px 5px rgba(0, 0, 0, 0.2),
		0 0 0 12px rgba(255, 255, 255, 0.4);
	display: flex;
	flex-flow: column;
}

form.mypage-form div.password {
	display: none;
}

form.mypage-form input.auth {
	display: block;
}

form#userVO label {
	color: blue;
	font-weight: bold;
	margin: 10px 0 0 10px;
}

button:disabled, button[disabled] {
	border: 1px solid #999 !important;
	background-color: #ccc !important;
	color: #666 !important;
	cursor: not-allowed;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section class="container body">
		<form:form modelAttribute="userVO" class="mypage-form">
			<h4>회원정보 수정</h4>
			<div>
				<label>USER NAME</label>
				<form:input path="username" class="form-control" />
			</div>
			<div class="password">
				<input id="password" class="form-control" type="password"
					placeholder="비밀번호를 입력!!">
			</div>
			<div>
				<label>E-mail</label>
				<form:input path="email" placeholder="E-mail" class="form-control" />
			</div>
			<div>
				<label>PHONE</label>
				<form:input path="phone" placeholder="전화번호" class="form-control" />
			</div>
			<div>
				<label>ADDRESS</label>
				<form:input path="address" placeholder="주소" class="form-control" />
			</div>
			<hr />
			<div>
				<button type="button" class="btn btn-primary" id="btn_update">수정</button>
				<button type="submit" class="btn btn-success" id="btn_save"
					disabled="disabled">저장</button>
				<button type="button" class="btn btn-danger" id="btn_loss_pass">비밀번호찾기</button>
			</div>
		</form:form>

	</section>


</body>
</html>





