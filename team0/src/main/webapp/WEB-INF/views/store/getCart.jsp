<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0, user-scalable=yes">
<title> </title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script type="text/javascript" src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/common.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="/resources/assets/css/storeCommon.css">
<link rel="stylesheet" type="text/css" href="/resources/assets/css/storeLayOut.css">
<jsp:include page="../common/head.jsp" />
</head>
<body id="wrap">
	<header id="header">
	<div class="wrap">
	</div>
	</header>
	<section id="container"> 
	<div id="detail">
		<div class="wrap">
			<div class="detail">
				<div class="menu tab-area">
					<div class="tabs tab-btns">
						<ul>
							<li class="active"><a href="javascript:;">메뉴 <em
									class="num">56</em></a></li>
							<li><a href="javascript:;">리뷰 <em class="num">4379</em></a>
							</li>
							<li><a href="javascript:;">가게 정보</a></li>
						</ul>
					</div>
					<div class="content">
						<div class="tab-box active">
							<div class="setmenu">
								<ul>
									<li>
										<div class="setmenu-layer">
											<div class="desc" id="kdflsamf">
												<div class="con">
													<div class="tit">땅콩카라멜(한마리) + 레몬크림탕슈(안심)</div>
													<div class="txt">최고의 조합만 모았다! 가심비 대표 메뉴 세트!</div>
													<div class="pri">
														<p class="price">27,000원</p>
													</div>
												</div>
												<div class="img">
													<img src="/resources/assets/images/img_hosigi_menu01.jpg">
												</div>
											</div>			
										</div>
									</li>
								</ul>
								<script type="text/javascript">
									//<![CDATA[ 
									$(function() {
										$(".setmenu > ul li:nth-child(1) .setmenu-layer").addClass("on");
										$(".setmenu > ul li:nth-child(1) .setmenu-button").addClass("on");
										$(".info dd button").click(function() {
											if ($(this).hasClass('on')) {
												$(this).removeClass("on");
											} else {
												$(this).addClass("on");
											}
										});
										$(".setmenu-button").click(
											function() {
												if ($(this).hasClass('on')) {
													$(".setmenu-layer").removeClass("on");
													$(".setmenu-button").removeClass("on");
												} else {
													$(".setmenu-layer").removeClass("on");
													$(".setmenu-button").removeClass("on");
												$(this).siblings(".setmenu-layer").addClass("on");
												$(this).addClass("on");
											}
										});
									})
								</script>
							</div>
							<div class="information">
								<a href="#">원산지 정보</a> <a href="#">알레르기 유발 정보</a>
							</div>
						</div>
						<div class="tab-box">
							<div class="review">
								<div class="stars">
									<div class="star-point">
										<div class="num">4.6</div>
										<div class="star">
											<p class="on">★</p>
											<p class="on">★</p>
											<p class="on">★</p>
											<p class="on">★</p>
											<p>★</p>
										</div>
									</div>
								</div>
								<div class="option">
									<div class="count">
										<span>리뷰<strong>3115</strong>개
										</span> <span>사장님댓글<strong>3104</strong>개
										</span>
									</div>
								</div>
								<div class="list">
									<ul>
										
									</ul>
								</div>
							</div>
						</div>
						<div class="tab-box">
							<div class="info">
								<div class="desc">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="order">
				<div class="title">장바구니</div>
				<div class="content">
					<div class="list">
						<div class="empty">주문표에 담긴 메뉴가 없습니다.</div>
					</div>
					<div class="info">
						<p>배달요금 2,000원 별도</p>
					</div>
				</div>
				<div class="button">
					<button type="submit" disabled>주문하기</button>
				</div>
			</div>
		</div>
	</div>
	<div id="modal-order" class="popup-layer">
		<!-- 메뉴 상세 부분 -->
		<div class="popup-box">
			<div class="popup-close">
				<i></i>
			</div>
			<div class="popup-title">메뉴상세</div>
			<div class="popup-cont">
				<div class="image">
					<img src="/resources/assets/images/img_hosigi_menu01.jpg">
				</div>
				<div class="info">

					<div class="name">(New)오븐바사삭+찍먹커리(티카마살라)</div>
					<div class="text">오븐바사삭＋티카마살라커리＋러블링소스＋각무</div>
				</div>
				<div class="price">
					<dl>
						<dt>가격</dt>
						<dd>19,900원</dd>
					</dl>
				</div>
				<div class="option">
					<dl>
						<dt>
							메가박스 이벤트 참여 선택 <em>(추가선택 가능)</em>
						</dt>
						<dd>
							<ul>
								<li><label class="checkbox"> <input type="checkbox">
										<i></i>
										<p>메가박스 1만원 결제권(~4/30)</p> <em>추가비용없음</em>
								</label></li>
							</ul>
						</dd>
					</dl>
					<dl>
						<dt>
							음료 추가선택 <em>(추가선택 가능)</em>
						</dt>
						<dd>
							<ul>
								<li>
									<!-- 옵션 체크박스 --> <label class="checkbox"> <input
										type="checkbox"> <i></i>
										<p>콜라 1.25L 사이즈업</p> <em>+ 2,000원</em>
								</label>
								</li>
								<li><label class="checkbox"> <input type="checkbox">
										<i></i>
										<p>콜라 1.25L 사이즈업</p> <em>+ 2,000원</em>
								</label></li>
							</ul>
						</dd>
					</dl>
				</div>
				<div class="quantity">
					<dl>
						<dt>수량</dt>
						<dd>
							<button type="button" class="quantity_minus" id="minus"></button>
							<span class="quantity_number" id="numberPlace">1</span>
							<button type="button" class="quantity_plus" id="plus"></button>
							<script>
								window.onload = function() {
									var minusBtn = document
											.getElementById("minus"), plusBtn = document
											.getElementById("plus"), numberPlace = document
											.getElementById("numberPlace"), numberResult = document
											.getElementById("numberResult"), number = 1, /// number value
									min = 1, /// min number
									max = 50; /// max number

									minusBtn.onclick = function() {
										if (number > min) {
											number = number - 1; /// Minus 1 of the number
											numberPlace.innerText = number; /// Display the value in place of the number
											numberResult.innerText = number; /// Display the value in place of the number

										}
										if (number == min) {
											numberPlace.style.color = "#e11414";
											setTimeout(
													function() {
														numberPlace.style.color = "#000000"
													}, 500)
										} else {
											numberPlace.style.color = "#000000";
										}

									}
									plusBtn.onclick = function() {
										if (number < max) {
											number = number + 1;
											numberPlace.innerText = number; /// Display the value in place of the number
											numberResult.innerText = number; /// Display the value in place of the number

										}
										if (number == max) {
											numberPlace.style.color = "#909090";
											setTimeout(
													function() {
														numberPlace.style.color = "#0080FF"
													}, 500)
										}

										else {
											numberPlace.style.color = "#0080FF";

										}
									}
								}
							</script>
						</dd>
					</dl>
				</div>
				<div class="total">
					<dl>
						<dt>총 주문금액</dt>
						<dd><strong>19,900원</strong><p>(최소주문금액 15,000원)</p></dd>
					</dl>
				</div>
			</div>
			<div class="mine-button">
				<div class="popup-button">
					<a href="#" class="btn btn_01">주문표에 추가</a> <a href="#"
						class="btn btn_02">주문하기</a>
				</div>
			</div>
		</div>
	</div>
	 <script type="text/javascript">
        //<![CDATA[ 
        $(function() {
            $("#kdflsamf").click(function(){
                if ($('#modal-order').hasClass('active')){
                    $('#modal-order').removeClass("active");
                    $("html, body").css("overflow","initial");
                } else{
                    $('#modal-order').addClass("active");
                    $("html, body").css("overflow","hidden");
                }
            });
            $("#modal-order .popup-close").click(function(){
                $("#modal-order").removeClass("active");
                $("html, body").css("overflow","initial");
            });
            $('#modal-order').on('click', function(e){
                if(!$('.popup-box').has(e.target).length){
                    $("#modal-order").removeClass("active");
                    $("html, body").css("overflow","initial");
                }
            });
        });
        //]]>
        </script>
		<div id="Image">
		<div class="img">
			<img src="">
		</div>
		<div class="bg"></div>
		<div class="close"></div>
	</div>
	</section>

	


</body>
</html>
