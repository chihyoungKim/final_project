<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
	<jsp:include page="../common/nav.jsp"/>
	<div class="navBorder"></div>
		<div class="clearfix">
			<div class="col-3 p-0 " id="sidebar">
			<jsp:include page="../store/sidebar.jsp"/>
			</div>
			<div class="col-9 mt-3 float-right">
				<c:if test="${member.sno == null}">
					<h1>등록 되어 있는 가게가 없습니다.</h1>
				</c:if>
				<c:if test="${member.sno != null}">
				<div class="container mt-3 ">
<%-- 				<h3>스토어 : ${store}</h3>
				<h3>히스토리 : ${history}</h3> --%>
					<h1 class="mb-4"><strong>${store.name}</strong></h1>
					<div class="table-responsive">            
						<table class="table table-hover ">
							<thead>
								<tr>
									<th>주문일</th>
									<th>주문번호</th>
									<th>주문자</th>
									<th>주문금액</th>
									<th>주문상태</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${history}" var="h" >
								<tr>
									<td>${h.orderDate}</td>
									<td class="ono">
									    <button type="button" id="btnMenu" class="btn" data-bs-toggle="collapse" data-bs-target="#menu">${h.ono}</button>
										<p id="menu" class="collapse">
										 <!-- 메뉴띄우기 -->
										 <c:forEach items="${h.orderMenus}" var="menu">
										 	${menu.name}
										 </c:forEach>
										</p>
									</td>
									<td class="storeName">${h.id}</td>
									<td class="amount">${h.amount}원</td>
									<td class="status">${h.status}</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				</c:if>
				<!-- /container end -->
			</div> 
		</div>
	<script>
		$(function(){
			$("#btnMenu").on("click", function(){
				function get(){
					console.log("get()...");
					$.ajax({
						url: "/store/storeHistory" + ono,
						type: "get",
						dataType: "json",
						success: function(xhr){
							console.log(xhr);
							alert("겟");
						}
					})
				}
			})
			
		})
	</script>
<jsp:include page="../common/footer.jsp"/>	
</body>
</html>