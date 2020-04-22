<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>

<script>
	$(function() {

		$(document).on("click", "#btn_email_ok", function() {
			let secret_key = $("span#secret").text()
			let secret_value = $("input#email_ok").val()
			if (secret_value == "") {
				alert("인증코드를 입력한 후 인증버튼을 클릭하세요")
				$("input#email_ok").focus()
				return false
			}
			$.ajax({
				url : "${rootPath}/join/email_token_check",
				method : "POST",
				data : {
					"${_csrf.parameterName}" : "${_csrf.token}",
					secret_id : "${username}",
					secret_key : secret_key,
					secret_value : secret_value
				},
				success : function(result) {
					// alert(result)
					document.location.replace("${rootPath}/user/login")
				},
				error : function() {
					alert("서버 통신 오류")
				}
			})
		})
		
		if("EMAIL_OK" == "${JOIN}") {
			$("button.btn-auth").text("인증 Email 다시 보내기")
		}

	})
</script>
<style>
form#userVO {
	width: 60%;
	margin: 30px auto;
	display: flex;
	flex-flow: column;
	justify-content: center;
	align-items: center;
	padding:20px;
	
	z-index: 10;
	border-radius: 20px;
	box-shadow: 12px 12px 2px 1px rgba(0, 0, 255, 0.2);
	background-color: #F0F9FF;
}

form#userVO legend {
	color:blue;
	font-size:2rem;
	font-weight: bold;

}


form#userVO input {
	margin : 10px 0;
}

span#secret {
	display: none;
}

.p-auth,.p-auth-ok {
	font-weight: bold;
}

.p-auth {
	color:red;
}


.p-auth-ok {
	color:blue;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>

	<section class="container body">
		<form:form action="${rootPath}/join/join_last" modelAttribute="userVO">
			<fieldset>
			<legend>E-mail 인증</legend>
			<hr/>
			<p class="p-auth">회원가입을 완료하려면 Email 인증을 수행해야 합니다</p>
			<div class="form-group">
				<form:input type="email" 
						class="form-control" path="email" placeholder="email" />
				<button class="btn-auth btn btn-primary">인증 Email 보내기</button>
			</div>
			
				<c:choose>
					<c:when test="${JOIN == 'EMAIL_OK'}">
						<hr/>
						<p class="p-auth-ok">E-mail을 열어서 인증코드를 확인한 후 아래 입력란에 입력 후 '인증하기' 버튼을 클릭하세요 <span
								id="secret">${My_Email_Secret}</span>
								<div class="form-group"> 
						<input id="email_ok" class="form-control" >
							<button type="button" id="btn_email_ok" class="btn btn-success">인증하기</button>
							</div>
					</c:when>
				</c:choose>
			</fieldset>
		</form:form>
	</section>

</body>
</html>




