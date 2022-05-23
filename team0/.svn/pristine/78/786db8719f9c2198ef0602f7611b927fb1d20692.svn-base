<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/resources/assets/css/normalizeStoreManagement.css" />
	<link rel="stylesheet" href="/resources/assets/css/demoStoreManagement.css" />
	<link rel="stylesheet" href="/resources/assets/css/componentStoreManagement.css" />
	<script src="/resources/assets/js/modernizr.custom.js"></script>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
	<div class="navBorder"></div>
			<div class="col-3 p-0" id="sidebar">
				<jsp:include page="../member/sidebar.jsp"></jsp:include>
			</div>
		<div class="col-9 float-right mt-3;">
			<div class="container mt-3">
				<h2>내가 찜한 가게</h2>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>별점</th>
							<th>가게이름</th>
							<th>리뷰 수</th>
							<th>배달시간</th>
							<th>최소주문금액</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stores}" var="store">
							<tr>
								<td>${store.scope}</td>
								<td><a href="/store/detail/${store.sno}">${store.name}</a></td>
								<td>${store.reviewNum}</td>
								<td>${store.delTime}</td>
								<td>${store.minPrice}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div> 
		<jsp:include page="../common/footer.jsp" />
</body>
</html>