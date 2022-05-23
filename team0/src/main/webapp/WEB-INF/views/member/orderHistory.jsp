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
			<jsp:include page="../member/sidebar.jsp"/>
			</div>
			<div class="col-9 mt-3 float-right">
				<div class="container mt-3 ">
					<h1 class="mb-0"><strong>주문내역조회</strong></h1>
					<p class="my-4">주문번호를 클릭하면 상세 정보를 확인할 수 있습니다.</p>
					<div class="table-responsive">            
						<table class="table table-hover ">
							<thead>
								<tr>
									<th>주문일</th>
									<th>주문번호</th>
									<th>주문매장</th>
									<th>주문금액</th>
									<th>리뷰</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${history}" var="h" >
								<tr>
									<td data-sno="${h.ord.sno}" data-order="${h.ord}">${h.timeStamp}</td>
									<td><a href="/order/history?ono=${h.ono}" class="ono">${h.ono}</a></td>
									<td class="storeName"><a href="/store/detail/${h.ord.sno}">${h.name}</a></td>
									<td class="amount">${h.amount}원</td>
									<td>
									<c:if test="${!h.existReview}">
										<a href="#" class="registerReview">리뷰</a>
									</c:if>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /container end -->
			</div>
		</div> 
		<form method="post" id="frm" action="/reviews/register" data-ono="">
			<div id="modal-order" class="popup-layer">
				<div class="popup-box">
					<div class="popup-close">
						<i></i>
					</div>
					<div class="popup-title">Review</div>
					<div class="popup-cont">
						<div class="info">
							<div class="name"></div>
						</div>
						<div class="quantity">
							
						</div>
						<div class="option">
							<dl>
								<dt id="scope" data-scope="5.0">
									<dd>
										별점 : 
										<select>
											<option value="1.0">1.0</option>
											<option value="2.0">2.0</option>
											<option value="3.0">3.0</option>
											<option value="4.0">4.0</option>
											<option value="5.0" selected>5.0</option>
										</select>
									</dd>
								</dt>
								<dt>
									<label>
										사진첨부
										<i class="fas fa-camera-retro"></i>
										<input type="file" name="attach" id="attach" style="display: none;" multiple>
									</label>
								</dt>
								<div class="attachName"> 
								
									
								</div>
							</dl>
						</div>
						<div class="total reviewContent">
							<dl>
								<dd><textarea placeholder="리뷰내용작성" name="content"></textarea></dd>
							</dl>
						</div>
					</div>
					<div class="mine-button">
						<div class="popup-button">
							<a href="#" class="btn btn_02" id="reviewRegister">작성하기</a>
						</div>
					</div>
				</div>
			</div>
		</form>
	<script>
		$(function() {
			var thisSno;
			
			
			$(".registerReview").on("click", function() {
				
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
				var ono = $(this).closest("tr").find(".ono").get(0).innerHTML;
				$("#frm").attr("data-ono", ono)
				// var order = $(this).closest("tr").find(".order").val();
				var amount = $(this).closest("tr").find(".amount").get(0).innerHTML;
				var name = $(this).closest("tr").find(".storeName").get(0).innerHTML;
				thisSno = $(this).closest("tr").find("td").data("sno") || 0;

				replyService.getOrderMenus(ono, function(result){
					$('#modal-order').find(".quantity").html(getMenuListStr(result))
				})

				function getMenuListStr(menus) {
					var str = '';
					str += '<dl>';
					str += '	<dt>';
					str += '		<ul>';
					for(var i in menus) {
						str += '			<li>' + menus[i].name + '</li>';
					}
					str += '		</ul>';
					str += '	</dt>';
					str += '	<dd>';
					str += '		<ul class="prices">';
					for(var i in menus) {
						str += '			<li>' + menus[i].price + '</li>';
					}
					str += '		</ul>';
					str += '	</dd>';
					str += '</dl>';
					str += '</hr>';

					str += '<dl>';
					str += '	<dt>';
					str += '		<ul>';
					str += '			<li></li>';
					str += '		</ul>';
					str += '	</dt>';
					str += '	<dd>';
					str += '		<ul class="prices">';
					str += '			<li>' + amount + '</li>';
					str += '		</ul>';
					str += '	</dd>';
					str += '</dl>';

					return str;
				}

				$("#modal-order").find(".name").get(0).innerHTML = name;

			})




			// 파일 첨부
			var regexp = /(.*?)\.(exe|sh|js|jsp)$/;
			var maxSize = 1024 * 1024 * 5;
			
			function validateFiles(fileName, fileSize) {
				if(fileSize > maxSize) {
					alert("파일 사이즈 초과");
					return false;
				}
				if(regexp.test(fileName)) {
					alert("해당 파일의 종류는 업로드할 수 없습니다.");
					return false;
				}
				return true;
			}
			
			$(".option label").on("change", ":file", function() {
				var $clone = $(".attachName").clone();
				var formData = new FormData();
				console.log("첨부파일변경됨")
				for(var i in this.files) {
					if(!validateFiles(this.files[i].name, this.files[i].size)) {
						return false;
					}
					formData.append("files", this.files[i]);
				}
				
				$.post({
					processData : false,
					contentType : false,
					data : formData,
					url : "/upload/" + 3,
					dataType : "json"
				}).done(function(result) {
					console.log(result);
					$(".attachName").html($clone.html());

					var str = "";
					for(var i in result) {
						console.log(result[i])
						console.log($.param(result[i]))
						str += '<dd data-uuid="' + result[i].uuid + '" data-path="' + result[i].path + '" data-image="' + result[i].image + '" data-origin="' + result[i].origin + '">';
						str += '	<a href="/download?' + $.param(result[i]) + '">' + result[i].origin + '</a><button type="button" class="close"><span>&times;</span></button>';
						str += '</dd>';
					}
					$(".attachName").append(str);
				})
			})
			
			
			
			// 파일 삭제 이벤트
			$(".attachName").on("click", ".close", function(){
				var $dom = $(this).closest("[data-uuid]");

				var uuid = $dom.data("uuid");
				var image = $dom.data("image");
				var path = $dom.data("path")
				$.post({
					url : "/deleteFile",
					data : {uuid : uuid, path : path, image:image},
					success : function(result) {
						console.log(result);
						$("[data-uuid='" + uuid + "']").remove();
					}
				})
			})
			
			$("#reviewRegister").on("click", function() {
				// 리뷰작성완료
				event.preventDefault();
				
				var scope = $(this).closest("#frm").find("#scope").data("scope");


				var inputStr = '';
				var str = "";

				inputStr+= '<input type="hidden" value="' + thisSno + '" name="sno">';
				inputStr+= '<input type="hidden" value="' + scope + '" name="scope">';
				inputStr+= '<input type="hidden" value="' + $("#frm").data("ono") + '" name="ono">';

				$("input:not(#attach)").remove();
				$("#frm").append(inputStr);


				var attrArr = ['uuid', 'origin', 'path'];
				$(".attachName dd").each(function(i) {
					for(var j in attrArr) {
						str +=
							$("<input>")
							.attr("type", "hidden")
							.attr("name", "attachs[" + i + "]." + attrArr[j])
							.attr("value", $(this).data(attrArr[j]))
							.get(0).outerHTML + "\n";

					}
				})
				console.log(str)
				$(this).closest("form").append(str).submit();
			})
			
			$("#scope ~ dd").on("change", function() {
				$("#scope").data("scope", $(this).find("option:selected").val());
			})

		})
	</script>
<jsp:include page="../common/footer.jsp"/>	
</body>
</html>