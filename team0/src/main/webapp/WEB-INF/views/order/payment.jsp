<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2022. 4. 29.오후 5:43:41</title>
<jsp:include page="../common/head.jsp"/>
</head>
<body>
<div id="wrapper">
   	<jsp:include page="../common/nav.jsp"/>
	        <%-- <h1>${order}</h1> --%>
<div class="container d-lg-flex containerPay ">
    <div class="box-1 bg-light user col-6">
        <div class="d-flex align-items-center mt-3 ">
            <h3>주문내역</h3>
        </div>
        <hr>
        <div class="box-inner-2 pt-3">
        	<c:forEach items="${orderMenu}" var="m">
            <div class="d-flex justify-content-between mb-1 userdetails">
                <p class="fw-bold">메뉴이름</p>
                <p class="fw-lighter">${m.name}</p>
            </div>
            <div class="d-flex justify-content-between mb-1 userdetails">
                <p class="fw-bold">가격</p>
                <p class="fw-lighter">${m.price} 원</p>
            </div>
            <div class="d-flex justify-content-between mb-1 userdetails">
                <p class="fw-bold">수량</p>
                <p class="fw-lighter">${m.count}</p>
            </div>
            <hr>
            </c:forEach>
            <p class="p-3 my-3 parder font-weight-lighter small">고객님의 결제금액 및 수량이 맞는지 확인해주세요.</p>
        </div>
    </div>
    <div class="box-2 col-6">
        <div class="box-inner-2">
	        <div class="d-flex align-items-center mt-3 ">
	            <h3>배달 및 결제정보</h3>
	        </div>
	        <hr>
            <form  method="post" id="frm" >
                <div class="mb-3">
                    <p class="dis fw-bold mb-2">업체명</p> 
                    <input class="form-control mb-2" type="text" value="${order.name}" name="name" readonly>
                    <p class="small">주문일시 : ${order.orderDate}</p>
                    <p class="small">주문번호 : ${order.ono}</p>
                    <p class="small">픽업방법 : 배달/포장</p>
                </div>
                <hr>
                <div>
	                <div class="my-3 form-group">
	                    <label class="dis fw-bold mb-2">전화번호</label> 
	                    <input class="form-control check" id="phone" type="tel" name="phoneNumber" placeholder="(-)를제외한 전화번호를 입력하세요">
	                </div>
                    <div class="d-flex justify-content-between mb-1 ">
                        <p class="dis fw-bold mb-2">사용자주소</p> 
                        <p class="dis fw-bold mb-2"><input class= "btn btn-primary btn-sm" type="button" onclick="execDaumPostcode()" value="우편번호 찾기"></p>
                    </div>
	                <div class="address form-floating">
                        <input type="text"  class="form-control" id="postcode" name="postCode" placeholder="우편번호" readonly>
                        <input type="text"  class="form-control" id="address" name="address" placeholder="주소" readonly>
                        <input type="text"  class="form-control  check" id="detailAddress" name="detailAddress"placeholder="상세주소">
                        <input type="text"  class="form-control" id="extraAddress" placeholder="참고항목" readonly>
	                </div>
	                <div class="form-group mt-3 mb-3">
                        <label for="requests">요청사항</label> 
	                    <input class="form-control check" type="text" placeholder="요청사항을 입력하세요" id="requests" name="requests">
	                </div>
					<div class="form-floating">
					  <select class="form-select" id="selList" name="selList">
					    <option value="html5_inicis">이니시스</option>
					    <option value="kakaopay">카카오페이</option>
					    <option value="">결제수정중</option>
					  </select>
					</div>
                    <div class="d-flex flex-column dis">
                        <div class="d-flex align-items-center justify-content-between mb-2">
                            <p>주문금액</p>
                            <p>${order.amount} 원</p>
                        </div>
<%--                         <div class="d-flex align-items-center justify-content-between mb-2">
                            <div class="d-flex align-items-center">
                                <p class="pe-2">할인금액 <span class="d-inline-flex align-items-center justify-content-between bg-light px-2 couponCode"> <span id="code" class="pe-2"></span></span> </p>
                            </div>
                            <p>0 원</p>
                        </div>
                        <div class="d-flex align-items-center justify-content-between mb-2">
                            <p>배달금액</p>
                            <p> ${order.delPrice} 원</p>
                        </div> --%>
                        <div class="d-flex align-items-center justify-content-between mb-2">
                            <p class="fw-bold">총 결제금액</p>
                            <p class="fw-bold">${order.amount} 원</p>
                        </div>
         			<p class="p-3 parder font-weight-lighter small center">고객님의 배달및 결제정보가 맞는지 확인해주세요.</p>
                		<sec:csrfInput/>					
                        <button class="btn btn-primary mt-2" type="button" onclick="iamport()" id="btnPay">
                        	Pay
                        	<span class="fas fa-won-sign px-1"></span>
                        	${order.amount}
                       	</button>
                    </div>
                </div>
                <input type="hidden" value="${order.id}" name="id">
                <input type="hidden" value="${order.amount}" name="amount">
            </form>
        </div>
    </div>
</div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script>
	var IMP = window.IMP; // 생략 가능
	var index;
	$("#selList").on("change",function(){
		index = $(this).find("option:selected").val();
	})
	//IMP.init("{imp23763120}"); // 예: imp00000000

	//console.log($('#selList option:selected').val());
	/* console.log(selList.options[selList.selectedIndex].value); */
	//상태 (status ready인것만 결제가능하게 해야됨)
	function iamport(){
    	if(!document.getElementById('phone').value){
    		alert("전화번호를 입력해주세요.")
    		document.getElementById('phone').scrollIntoView(true);
    		return false;
    	}
    	if(!document.getElementById('address').value){
    		alert("주소를 입력해주세요.")
    		document.getElementById('address').scrollIntoView(true);
    		return false;
    	}
    	if(!document.getElementById('detailAddress').value){
    		alert("상세주소를 입력해주세요.")
    		document.getElementById('detailAddress').scrollIntoView(true);
    		return false;
    	}
    	if(!document.getElementById('requests').value){
    		alert("요청사항을 입력해주세요.")
    		document.getElementById('requests').scrollIntoView(true);
    		return false;
    	}

		//가맹점 식별코드
		IMP.init('imp23763120');
		IMP.request_pay({
            pg: index ,
	        pay_method: "card",
	        merchant_uid: '${order.ono}',
	        name: '${order.name}',
	        amount: '${order.amount}',
	        //buyer_email: '${payment.email}',
	        buyer_email: "hong@go.com",
	        buyer_name: '${order.id}',
	        buyer_tel: $("#phone").val(),
	        buyer_addr: $("#address").val(),
	        buyer_postcode: $("#postcode").val(),
	        m_redirect_url: "https://www.myservice.com/payments/complete/mobile" /* 모바일되면.. */
		}, function(rsp) {
			if(rsp.success){
				console.log(rsp);
				$.ajax({
					async: false, //여러개 사용할 경우 꼬임방지					
					url: "/order/payment/"+ rsp.imp_uid ,
					method: "POST",
					data:JSON.stringify(rsp),
					dataType:"json",
					contentType:"application/json; charset=utf-8",
					
 					success : function(data) { 
						//console.log("ajax성공");
						if(rsp.paid_amount == data.response.amount){
							var str = "";
							str += '<input type="hidden" value="'+ rsp.buyer_email +'" name="email">';
							str += '<input type="hidden" value="'+ rsp.imp_uid +'" name="impUid">';
							str += '<input type="hidden" value="'+ rsp.pay_method + '" name="payMethod">';
							str += '<input type="hidden" value="12345" name="applyNum">';
							str += '<input type="hidden" value="' + rsp.card_quota + '" name="quota">';
							str += '<input type="hidden" value="' + rsp.status + '" name="status">';
							$("#frm").append(str)
							//console.log($("#frm").serialize());
							$("#frm").submit();
						}
					},
					error : function(xhr, status, error) { 
						console.log(xhr);
						console.log(status);
						console.log(error);
					} 
				})
			} else {
				alert("결제요청실패 " + rsp.error_msg);
			}
		});
	} //iamPort 함수 끝

    //다음 카카오 주소 API
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }

</script>
</body>
</html>