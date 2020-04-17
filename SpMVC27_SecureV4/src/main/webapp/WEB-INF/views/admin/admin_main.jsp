<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<style>
	#body{
		position: fixed;
		top: 60px;
		left: 0;
		width: 100%;
		display: flex;
	}
	#body menu{
		flex: 1;
		border: 1px solid red;
		margin: 5px;
	}
	#body article{
		flex: 3;
		border: 1px solid red;
		margin: 5px;
	}
	#body menu li{
		list-style: none;
	}
	#body menu li a{
		display: inline-block;
		padding: 5px 10px;
		text-decoration: none;
		width: 150px;
		margin-left: 10px;
		border-bottom: 2px solid transparent;
		
	}
	#body menu li a:hover{
		border-top: 2px solid blue;
		border-bottom: 2px solid blue;
		transition: ease 0.3s;
	}
	
</style>
<script>
	$(function(){
		$(document).on("click","#user_list",function(){
			$.get("${rootPath}/admin/user_list",function(result){
				$("#admin_content").html(result)
			})
		})
		$(document).on("click","tr.tr_user",function(){
			let username = $(this).data("id")
			$.get("${rootPath}/admin/user_detail_view/" + username,
					function(result){
				$("#admin_content").html(result)
			})
		})
		$(document).on("click","button#btn_save",function(){
			
			
			let formdata = $("form").serialize()
			$.post("${rootPath}/admin/user_detail_view",formdata,function(result){
				$("#admin_content").html(result)
				alert("Update 성공!!!")
			})
			
		})
			
		$(document).on("click","#auth_append",function(){
			
			let auth_input = $("<input/>",
					{class:"auth",name:"auth"})
			// auth_input.append($("<p/>",
			//		{text:'제거',class:'auth_delete'}))		
			$("div#auth_box").append(auth_input)
		})
			
	})

</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<section id="body">
	<menu>
		<h3>Admin Page</h3>
		<ul>
			<li><a href="javascript:void(0)" id="user_list">User List</a>
			<li><a href="#">메뉴1</a>
			<li><a href="#">메뉴2</a>
		</ul>
	</menu>
	<article id="admin_content">
	
	</article>

</section>
</body>
</html>