<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.cart_list {
	border-bottom: 1px solid green;
	background-color: #ddd;
}

</style>
<script>
$(function(){

	$(".btn_one_qty").click(function(){
		let id = $(this).data("id")
		let qty = $("#p_" + id).val()
		// alert("수량 : " + qty)
		
		$.ajax({
			url : "${rootPath}/user/product/qty_update",
			type : "GET",
			data : {
				seq : id,
				p_qty : qty
			},
			success:function(result) {
				if(parseInt(result) > 0)
					alert("수량을 변경했습니다")
				else 
					alert("수량 변경에 실패 했습니다")
			},
			error:function(){
				alert("서버 통신오류")
			}
		})
	}) // btn_qty
	
	$(".btn_one_delete").click(function(){
		let id = $(this).data("id")
		if(confirm("상품을 삭제할까요?")) {
			document
			.location
			.replace("${rootPath}/user/product/"
					+ "cart_one_delete/" + id)
		}
	}) // btn_one_delete
	
	$(".btn_list_delete").click(function(){
		
		// js에서 비어있는 배열을 생성
		let cart_array = Array()
		
		// 본문에 있는 cart_list_check 를 뽑아서 배열로 만들기
		let checkList = $(".cart_list_check")

		// 배열을 순회하면서
		// checked가 되어 있는 checkbox만 찾아서
		// value 값을 cart_array에 추가
		let index = 0;
		for(i = 0 ; i < checkList.length ; i++) {
			if(checkList[i].checked == true) {
				cart_array[index++] = checkList[i].value
			}
		}
		// alert(cart_array)
		if(confirm("선택된 상품을 삭제할까요")) {
			
			$.ajax({
				url : "${rootPath}/user/product/cart_list_delete",
				type : "POST",
				data : {
					"${_csrf.parameterName}" : "${_csrf.token}",
					delList : cart_array
				},
				success:function(result) {
					if(result > 0) {
						alert("삭제 성공!!")
						document.location.replace(document.location.href)
					}
				},
				error:function() {
					alert("서버통신오류")
				}
			})
		}
		
	}) // btn_delete
	
	$(".btn_list_qty_update").click(function(){
		if(confirm("전체수량을 변경합니다")) {
			$("#cart_form").submit()	
		}
	})
	
	$(".btn_list_all_check").click(function() {

		let check = $(this).data("check")
		
		if(check == 1) {
			// $("input[type=checkbox]").attr("checked","checked")
			$("input[type=checkbox]").prop("checked",true)
			$(this).text("전체해제")
			
		} else {
			// $("input[type=checkbox]").removeAttr("checked")
			$("input[type=checkbox]").prop("checked",false)
			$(this).text("전체선택")
		}
		check *= (-1)
		$(this).data("check",check)
		
	})
	
	
	$(".btn_list_buy").click(function() {
		// js에서 비어있는 배열을 생성
		let cart_array = Array()
		
		// 본문에 있는 cart_list_check 를 뽑아서 배열로 만들기
		let checkList = $(".cart_list_check")

		// 배열을 순회하면서
		// checked가 되어 있는 checkbox만 찾아서
		// value 값을 cart_array에 추가
		let index = 0;
		for(i = 0 ; i < checkList.length ; i++) {
			if(checkList[i].checked == true) {
				cart_array[index++] = checkList[i].value
			}
		}

		if(cart_array.length < 1) {
			alert("선택된 상품이 없습니다.\n" 
				+ "상품을 선택한 후 주문버튼을 클릭하세요")
			return false;
		}
		
		if(confirm(cart_array.length + " 개의 상품을 주문 처리 할까요?")) {
			$.ajax({
				url : "${rootPath}/user/product/cart_list_buy",
				type : "POST",
				data : {
					"${_csrf.parameterName}" : "${_csrf.token}",
					buyList : cart_array
				},
				success:function(result) {
					if(result > 0) {
						document.location.replace("${rootPath}/user/product/delivery_list")
					}
				},
				error:function() {
					alert("서버통신오류")
				}
			})
		}
	})

})
</script>
<c:choose>
	<c:when test="${empty CART_LIST}">
		<div>카드가 비어 있습니다</div>
	</c:when>
	<c:otherwise>
		<form id="cart_form" method="POST" action="${rootPath}/user/product/cart_list_qty_update">
		
		<input type="hidden" 
				name="${_csrf.parameterName}"  
				value="${_csrf.token}">
				
		<c:forEach items ="${CART_LIST}"  var="cart">
			<div class="cart_list" data-id="${cart.seq}">
				<p>상품이름 : ${cart.p_name}</p>
				<p>상품가격 : ${cart.p_oprice}</p>
				<p><label>수량</label>

				<input type="number" name="p_qty" value="${cart.p_qty}" id="p_${cart.seq}"/>
				<input type="hidden" name="seq" value="${cart.seq}">
				
				<button class="btn_one_qty" data-id="${cart.seq}">수량변경</button>
				<button class="btn_one_delete" data-id="${cart.seq}">&times;</button>
				<input type="checkbox" class="cart_list_check" value="${cart.seq}">
				
			</div>
		</c:forEach>
		</form>
	</c:otherwise>
</c:choose>
<div>
	<button data-check="1" class="btn_list_all_check">전체선택하기</button>
	<button class="btn_list_buy">주문하기</button>
	<button class="btn_list_delete">주문삭제</button>
	<button class="btn_list_qty_update">수량변경</button>
</div>




