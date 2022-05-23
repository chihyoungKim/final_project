<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결제내역확인</title>
<jsp:include page="../common/head.jsp"/>
</head>
<body>
    <!-- Page Wrapper -->
	<div class="wrapper my-5">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
				<jsp:include page="../common/nav.jsp"/>
                <!-- Begin Page Content -->
                <div class="container-fluid col-6 mt-5">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4 center-block">
                        <div class="card-header py-5 text-center bg-warning ">
                    		<p class="h2">주문이 <span class="h2 text-danger">완료</span>되었습니다.</p>
							<p class="h4 text-small">주문번호 : ${history.ono}</p>
                        </div>
                        <div class="card-body center-block  ">
							<ul class="list-group list-group-flush">
								<li class="list-group-item"><strong>주문매장 : ${history.name}</strong></li>
								<li class="list-group-item">총금액 : <fmt:formatNumber value="${history.amount}"/>원</li>
								<li class="list-group-item">결제방식 : ${history.payMethod}</li>
								<li class="list-group-item">카드승인번호 : ${history.applyNum}</li>
								<li class="list-group-item">할부 : ${history.quota}</li>
								<li class="list-group-item">상태 : ${history.status}</li>
								<li class="list-group-item">결제시간 : ${history.timeStamp}</li>
								<li class="list-group-item">총가격 :  <fmt:formatNumber value="${history.amount}"/> 원</li>
								<li class="list-group-item">배달주소 : ${history.address}</li>
								<li class="list-group-item">핸드폰 : ${history.phoneNumber}</li>
								<li class="list-group-item">가게사장님께 : ${history.requests }</li>
							</ul>
						<div class="col text-center my-5">
							<a href="/member/orderHistory" class="btn btn-primary center"> 주문상세보기 </a>
							<button type="button" class="btn btn-primary center"> 주문내역삭제 </button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../common/footer.jsp"/>
<script>

</script>
</body>
</html>