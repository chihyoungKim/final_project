<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0, user-scalable=yes">
<title></title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
<link rel="stylesheet" type="text/css" href="/resources/assets/css/storeCommon.css">
<link rel="stylesheet" type="text/css" href="/resources/assets/css/storeLayOut.css">
<jsp:include page="../common/head.jsp" />
</head>
<body id="wrap">
<jsp:include page="../common/nav.jsp" />
	<div id="header">
		<div class="wrap">
		</div>
	</div>
	<div id="container">
<jsp:include page="../common/category.jsp" />
		<div id="align">
			<div class="wrap">
				<input class="search" placeholder="검색어 입력">
				<button type="button" id="search">
					<img src="/resources/assets/images/icon_search1.png" alt="검색 버튼">
				</button>
				<div class="select">
					<select>
						<option value="" selected>기본순</option>
						<option value="S">별점 높은순</option>
						<option value="R">리뷰 많은순</option>
						<option value="D">배달시간 빠른순</option>
						<option value="M">최소주문금액 적은순</option>
					</select>
				</div>
			</div>
		</div>
		<div id="list">
			<div class="wrap">
				<div class="list">
					<div class="desc">
						<div class="title">광고 음식점</div>
						<div class="cont">
							<ul>
							
							
							<c:forEach items="${ad}" var="a">
								<li>
									<a href="/store/detail/${a.sno}" class="inner">
										<div class="img">
											<img onerror="this.src='/resources/assets/images/noimage.png'" src="/display?uuid=${a.attach.uuid}&path=${a.attach.path}&origin=${a.attach.origin}">
										</div>
										<div class="con">
											<div class="ttl">${a.name}</div>
											<div class="txt">
												<p>★</p>
												<em>${a.scope}</em><span>리뷰 ${a.reviewNum}</span><span>사장님 댓글 ${a.replyNum}</span>
											</div>
											<div class="time">평균 ${a.delTime}분</div>
										</div>
									</a>
								</li>
							</c:forEach>
								
								
								
								
							</ul>
						</div>
					</div>
					
					
					
					<div class="desc">
						<div class="title">일반 음식점</div>
						<div class="cont">
							<ul class="normal">
								<!-- 일반음식점 -->
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			var category = ${category};
			var lastNo;
			var amount;
			var condition;
			var search;
			
			function getStoreStr(store) {
				var str = '';
				var noimage = "'/resources/assets/images/noimage.png'";
	
				str += '<li data-sno="' + store.sno + '" data-rn="' + store.rn + '"><a href="/store/detail/' + store.sno + '" class="inner">';
				str += '		<div class="img">';
				str += '			<img onerror="this.src=' + noimage + '" src="/display?uuid=' + store.attach.uuid + '&path=' + store.attach.path + '&origin=' + store.origin + '">';
				str += '		</div>';
				str += '		<div class="con">';
				str += '			<div class="ttl">' + store.name + '</div>';
				str += '			<div class="txt">';
				str += '				<p>★</p>';
				str += '				<em>' + store.scope + '</em><span>리뷰 ' + store.reviewNum + '</span><span>사장님 댓글 ' + store.replyNum + '</span><span>최소주문금액 ' + store.minPrice + '</span>';
				str += '			</div>';
				str += '			<div class="time">평균 ' + store.delTime + '분</div>';
				str += '		</div>';
				str += '</a></li>';
	
				return str;
			}
	
			// 일반음식점 목록 띄우기
			function showStoreList(category, lastNo, amount, condition, search) {
				var param = {category: category, lastNo: lastNo, amount: amount, condition: condition, search:search}
				scrollService.getStoreList(param, function(result) {
					var str = '';
					for(var i in result) {
						str += getStoreStr(result[i]);
					}
					if(!str) {
						$("ul.normal").html('해당 조건에 맞는 가게가 없습니다.');
					}
					else {
						$("ul.normal").html(str);
					}
				}, function(xhr) {
					console.log(xhr);
				})
			}
			showStoreList(category, lastNo, amount, condition, search);
	
			// 무한스크롤 더보기
			$(document).scroll(function() {
				var dh = $(document).height();
				var wh = $(window).height();
				var wst = $(window).scrollTop();
				if(dh == wh + wst) {
					var lastNo = $("ul.normal li:last-child").data("rn");
					var param = {category:category, lastNo:lastNo, condition:condition, search:search};
					scrollService.getStoreList(param, function(result) {
						var str = '';
						for(var i in result) {
							str += getStoreStr(result[i]);
						}
						$("ul.normal").append(str);
					})
				}
			})

			// 검색어로 가게리스트 재정렬
			$("#search").on("click", function() {
				condition = "F";
				search = $(this).closest(".wrap").find(".search").val();
				showStoreList(category, lastNo, amount, condition, search);
			})




			// 필터로 가게리스트 재정렬
			$(".select").on("change", function() {
				condition = $(this).find("option:selected").val();
				showStoreList(category, lastNo, amount, condition, search);
			})





			
		})
	</script>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>