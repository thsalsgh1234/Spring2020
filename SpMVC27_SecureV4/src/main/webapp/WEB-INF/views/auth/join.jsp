<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
    
<%@ taglib uri="http://www.springframework.org/tags/form"  
			prefix="form"%>
			
<%@ taglib uri="http://www.springframework.org/security/tags" 
			prefix="sec" %>

<%@ include file="/WEB-INF/views/include/include-head.jspf" %>

<style>
* {
	margin:0;
	padding:0;
	box-sizing: border-box;
}

.join_form {
	
	width:400px;
	padding:40px;
	
	background: blue;
	text-align: center;
	z-index: 10;
	
	border-radius: 20px;
	box-shadow: 12px 12px 2px 1px rgba(0,0,255,0.2);
	
	margin:20px auto;

}

.join_form h2 {
	color:white;
	font-weight: 500;
}

.join_form h3 {
	color:white;
	font-weight: 300;
	background-color: red;
	border-radius: 20px;
}

.join_form input {
	
	background: none;
	margin:10px auto;
	text-align: center;
	
	border:2px solid #3498db;
	
	padding:14px 10px;
	width:200px;
	outline: none;
	color:white;
	
	border-radius: 25px;
	transition : 0.2s;
	
}

.join_form input:focus {
	width: 280px;
	border-color: #2ECC71;
}

.join_form .option {
	text-align: right;
	margin-right: 3px;

}
.join_form label[for="view_pass"]{

 padding: 0 0 5px 2px;
 cursor: pointer;
 text-transform: uppercase;

  margin-bottom: 10px;
  font-size: 11px;
  font-weight: 400;
  text-transform: capitalize;
  color:white;
}

.join_form input[type="checkbox"]{
  vertical-align: middle;
  margin: -1px 5px 0 1px;

}

.join_form input[type='checkbox']:focus{
  width:200px;

}


.join_form button {
	
	border:2px solid #2ECC71;
	padding:14px 40px;
	background: none;
	display: block;
	margin:20px auto;
	padding:14px 40px;
	
	outline: none;
	color:white;
	
	border-radius: 25px;
	
	cursor: pointer;
}

.join_form button:hover {
	background-color: #2ECC71;
}

.naver_login img {
	border-radius: 10px;
}

/*
 div box에 image를 2개 가져오고
 초기에는 2번째 이미지를 감춰둔다
*/
.naver_login img:last-child {
	display: none;
}

/*
마우스를 div box에 올리면
처음 이미지는 감추고, 두번째 이미지는 보여라
*/
.naver_login:hover img:last-child {
	display: inline-block;
}

.naver_login:hover img:first-child {
	display: none;
}

</style>

<script>
$(function(){
	
	$(document).on("click","#btn-join",function(){

		// 유효성검사
		// id, password가 입력되지 않았을때 경고
		let username = $("#username")
		let password = $("#password")
		let re_password = $("#re_password")
		
		if(username.val() == "") {
			alert("아이디를 입력하세요")
			username.focus()
			return false;
		}

		if(password.val() == "") {
			alert("비밀번호를 입력하세요")
			password.focus()
			return false;
		}

		if(re_password.val() == "") {
			alert("비밀번호 확인 입력하세요")
			re_password.focus()
			return false;
		}

		if(password.val() != re_password.val()) {
			alert("비밀번호와 비빌번호 확인이 다릅니다")
			password.focus()
			return false;
		}
		$("form").submit()
		
	})
	
	// 현재 입력박스에서 포커스가 벗어났을때 발생하는 이벤트
	$(document).on("blur", "#username",function(){
		
		let username = $(this).val()
		
		if(username == "") {
			$("#m_username").text("아이디는 반드시 입력해야 합니다")
			$("#username").focus()
			return false;
		}
		
		$.ajax({
			
			// 데이터를 전송하기 전에 헤더에 csrf값을 설정한다
			beforeSend : function(ajaxReq)
            {   
                ajaxReq.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
			url : "${rootPath}/user/idcheck",
			method : "POST",
			data : {username : username},
			success : function(result) {
				if(result == "EXISTS") {
					
					$("#m_username").text("* 이미 가입된 사용자이름 입니다.")
					$("#m_username").css("color","red")
					$("#username").focus()
					return false
					
				} else {
					
					$("#m_username").text("* 사용가능한 ID 입니다.")
					
				}
			},
			error:function(){
				$("#m_username").text("* 서버통신오류.")
				return false;
			}
			
		})
		
	})
	
	// 현재 DOM 화면에 class가 view_pass인 모든것에 적용
	$(".view_pass").each(function(index,input){
		
		// 매개변수로 전달된 input을 선택하여
		// 변수 $input에 임시 저장하라
		let input_ref = $(input)
		$("input#view_pass").click(function(){
			let change = $(this).is(":checked") 
					? "text" 
						: "password";
			// 가상의 input 생성
			// <input type='text'> 또는 <input type='password'>
			let ref = $("<input type='" + change + "' />")
				.val(input_ref.val())
				.insertBefore(input_ref);
			
			input_ref.remove();
			input_ref = ref;
		})	
	})
})
</script>
	<style>
		.message {
			color:yellow;
			font-weight: bold;
			font-size: 0.5rem;
		}
	</style>

	<form:form method="POST" 
			action="${rootPath}/user/join" 
			class="join_form">
			
		<h2>회원가입</h2>
		
		<input type="text" id="username" 
					name="username" 
					placeholder="사용자 ID">
		<div class="message" id="m_username"></div>
		<input type="password" id="password" 
					name="password"  class="view_pass"
					placeholder="비밀번호">
		<input type="password" id="re_password" 
					name="re_password" class="view_pass"
					placeholder="비밀번호 한번 더~~">
					
		<div class="option">					
			<label for="view_pass">
			<input type="checkbox" id="view_pass">
			비밀번호 보이기</label>
		</div>			
		<button type="button" id="btn-join">회원가입</button>
		<button type="button" id="btn-loss">ID/비번찾기</button>
	
	</form:form>

	
	
	
	