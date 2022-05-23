<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
	<div class="navBorder"></div>
		<div class="col-3 p-0 display-flex" id="sidebar">
			<jsp:include page="../store/sidebar.jsp"></jsp:include>
		</div>
		<div class="col-9 float-right mt-3;">
			<h1>ad</h1>	
			<hr>
			<div class="form-group">
				<h2>광고 신청하시겠습니까?</h2>
				<button class="btn btn-danger" type="button" id="btn_applyAd">신청하기</button>
			</div>
		</div> 
		<script src="/resources/assets/js/classie.js"></script>
		<script>
		$(function() {
			$("#btn_id").click(function(){
                alert("신 청 완 료 ★");
                alert("관 리 자 승 인 기 다 리 라 우 ★");
                $("#btn_applyAd").attr("disabled", true);
            });
        })
		</script>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>