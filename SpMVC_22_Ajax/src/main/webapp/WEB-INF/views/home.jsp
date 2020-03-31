<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>나의 홈페이지</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style>
section {
	border: 1px solid blue;
	padding: 1rem
}
</style>
<script>
	$(function(){
	
		// jq의 event 핸들러를 작성할때
		// $("#call_ajax").click() 이라고 작성을 하는데
		// ajax등을 사용하여 서버로 부터 나중에 가저온 페이지는
		// 해당 이벤트 핸들러로 작동이 안된다.
		// ajax를 고려할때 아래와 같은 핸들러를 작성하는 것을
		// 자주 연습하자.
		$(document).on("click","#call_ajax",function(){
			$.ajax({
				url : "${rootPath}/ajax",
				method : "GET",
				success : function(result){
					/*
					서버에서 문자열을 return 하면 
					문자열을 신호로 하여 클라이언트에서 처리
					*/
					// alert(result)
					if(result == "OK") {
						alert("서버에서 OK를 보냄")
					}
				},
				error : function() {
					alert("서버 통신 오류")
				}
			})
		})
	})
</script>
<script>
	// jsp 외부에 script를 작성할때는 
	// el tag로 작성한 변수를 사용할수 없기 때문에
	// 임의로 스크립트 변수를 선언하여 전달해 주어야 한다.
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/resources/js/ajax.js"></script>

</head>
<body>
	<section id="main">

		<button id="call_ajax">Ajax 호출</button>
		<input type="text" id="msg">
		<button id="call_msg">메시지 호출</button>
		<button id="call_addr">주소 호출</button>
		<button id="call_addr_view">주소 view 호출</button>
	</section>

	<section id="sub"></section>

</body>
</html>