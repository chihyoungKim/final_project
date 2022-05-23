<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
</head>
<body>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	<div class="navBorder"></div>
	<div class="clearfix mb-5">
		<div class="col-3 p-0 display-flex" id="sidebar">
			<jsp:include page="../store/sidebar.jsp"/>
		</div>
		<div class="col-9 float-right mt-3">
				<h1>Review</h1>	
				<div id="detail">
					<div class="detail">
						<div class="menu">
							<div class="content">
								<div class="tab-box active">
									<div class="review">
										<div class="list">
											<ul class="list-group-item">
											</ul>
											<ul class="reviewList">
												<!-- 리뷰 -->
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</div>
		<form id="frm" method="post">
			<div id="modal-order" class="popup-layer clearfix">
				<!-- 메뉴 상세 부분 -->
				<div class="popup-box">
					<div class="popup-close">
						<i></i>
					</div>
					<div class="popup-title">답글달기</div>
					<div class="popup-content">
						<div class="image menuImage">
							<textarea class="reply" name="content"></textarea>
							<input type="hidden" name="groupId" class="groupId">
							<input type="hidden" name="sno" class="sno" value="${store.sno}">
						</div>
					</div>
					<div class="mine-button">
						<div class="popup-button">
							<a href="#" class="btn btn_02 register">작성하기</a>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
    <script>
    	$(function() {
	 		// 리뷰 관련 스크립트
		    //전역으로 
		    var sno = '${store.sno}';
			var lastRno;
			var lastNo;
			var amount; // undefined
		    // review String
		    function getReviewStr(review) {
				var str = '';
				 
				str += '<li>';
				if(review.rno == review.groupId) {
					str += '<div class="user">';
					str += '	<strong data-rno="' + review.rno + '">' + review.id + '</strong>';
					str += '	<p>' + review.regDate + '</p>';
					str += '</div>';
					str += '<div class="grade">';
					str += '	<div class="star">';
					str += '		<p class=' + (review.scope >= 1 ? "on" : "") + '>★</p>';
					str += '		<p class=' + (review.scope >= 2 ? "on" : "") + '>★</p>';
					str += '		<p class=' + (review.scope >= 3 ? "on" : "") + '>★</p>';
					str += '		<p class=' + (review.scope >= 4 ? "on" : "") + '>★</p>';
					str += '		<p class=' + (review.scope == 5 ? "on" : "") + '>★</p>';
					str += '		<p>' + review.scope + '</p>';
					str += '	</div>';
					str += '</div>';
					if(review.attachs.length) {
						str += "	<div class='img'>";
						/* str += "		<img src='" + review.attachs[0].origin + "'>"; */
						str += "		<img src='/display?uuid=" + review.attachs[0].uuid + "&path=" + review.attachs[0].path + "&origin=" + review.attachs[0].origin + "'>";
						str += "	</div>";
					}
					str += '<div class="comment">' + review.content + '</div>';
					str+= '	<button class="btn-danger col-1 p-3 registerReply" type="button" data-rno="' + review.rno + '">작성</button>';
				}
				else{
					str+= '<div class="answer">';
					str+= '	<div class="owner_user">';
					str+= '		<strong data-rno="' + review.rno + '">' + review.id + '</strong>';
					str+= '		<p>' + review.regDate + '</p>';
					str+= '	</div>';
					str += '<input type="hidden" value="' + review.rno + '">';
					str+= '	<div class="owner_comment pl-3">';
					str+= 		review.content;
					str+= '	</div>';
					str+= '</div>';
				}
				str += '</li>';
		
				return str;
			}
			
		    // 리뷰 목록 띄우기
            function showList(lastRno, amount) {
				console.log(lastRno, amount)
				var param = {sno: sno, lastRno: lastRno, amount: amount}
    			reviewService.getList(param, function(result) {
            		// console.log(result);
					var str = '';
					for(var i in result) {
						str += getReviewStr(result[i]);
					}
					$(".list ul.reviewList").html(str);
            	}, function(xhr) {
            		console.log(xhr);
            	})
    		}
			showList(lastRno, amount);
			
			// 무한스크롤 리뷰 더보기
			$(document).scroll(function() {
				var dh = $(document).height();
				var wh = $(window).height();
				var wst = $(window).scrollTop();
				if(dh == wh + wst) {
					var lastRno = $(".list ul li:last-child strong").data("rno");
					var param = {sno:sno, lastRno:lastRno};
					reviewService.getList(param, function(result) {
						var str = '';
						for(var i in result) {
							str += getReviewStr(result[i]);
						}
						$(".list ul.reviewList").append(str);
            		})
				}
			})
			
			// 답글작성 클릭시 이벤트(모달띄워야함)
			$(".review").on("click", ".registerReply", function() {
				event.preventDefault();
				var rno = $(this).data("rno");
				$("#frm input.groupId").attr("value", rno);

                if ($('#modal-order').hasClass('active')){
                    $('#modal-order').removeClass("active");
                    $("html, body").css("overflow","initial");
                } else{
                    $('#modal-order').addClass("active");
                    $("html, body").css("overflow","hidden");
                }
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
				
			})

			$(".register").on("click", function() {
				$(this).closest("#frm").submit();
			})
    	})
	</script>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>