<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
<script src="/resources/assets/js/scroll.js"></script>
</head>
<body>
	<jsp:include page="../common/nav.jsp"></jsp:include>
	<div class="row navBorder"></div>
	<div class="clearfix">
		<div class="col-3 p-0 " id="sidebar">
			<jsp:include page="../store/sidebar.jsp"></jsp:include>
		</div>
		<div class="col-9 float-right my-3">
			<c:if test="${member.sno == null}">
				<h1>등록 되어 있는 가게가 없습니다.</h1>
			</c:if>
			<c:if test="${member.sno != null}">
			<div class="container my-3 ">
				<div class="btn-group col-12 my-4 pl-0">
					<h1 class="col-11 mt-0 pl-0 mb-0">메뉴등록</h1>
					<button class="btn-danger col-1" id="menu" type="button">등록</button>
				</div>
				<div class="table-responsive">            
					<table class="table table-hover ">
						<thead>
							<tr>
								<th>메뉴이름</th>
								<th>가격</th>
								<th>상태</th>
								<!-- <th>사진등록여부</th> -->
							</tr>
						</thead>
						<tbody class="menuList" data-sno="${store.sno}">
							<!-- <c:forEach items="${menus}" var="menu" >
							<tr>
								<input type="hidden" name="mno" data-mno="${menu.mno}" value="${menu.mno}">
								<td data-sno="${store.sno}">${menu.name}</td>
								<td>${menu.price}원</td>
								<td>
									<c:if test="${menu.state}">
										<a href="#" class="changeState">판매중</a>
									</c:if>
									<c:if test="${!menu.state}">
										<a href="#" class="changeState">판매중지</a>
									</c:if>
								</td>
								<td>
									<c:if test="${!menu.attach.uuid}">
										<label>
											사진 등록
											<i class="fas fa-camera-retro"></i>
											<input type="file" class="d-none">
										</label>
									</c:if>
								</td>
							</tr>
							</c:forEach> -->
						</tbody>
					</table>
				</div>
			</div>
			</c:if>
		</div>
	<!-- /container end -->
	</div> 
	<form method="post" id="frm" action="/store/menu">
		<div id="modal-order" class="popup-layer">
			<div class="popup-box">
				<div class="popup-close">
					<i></i>
				</div>
				<div class="popup-title">Menu</div>
				<div class="popup-cont">
					<div class="info">
						<input type="text" name="name" class="name" placeholder="메뉴이름">
					</div>
					<div class="quantity">
						<input type="number" name="price" placeholder="가격">
					</div>
					<div class="option">
						<dl>
							<dt>
								<label>
									사진첨부
									<i class="fas fa-camera-retro"></i>
									<input type="file" class="d-none">
								</label>
							</dt>
							<div class="attachName">
								
							</div>
						</dl>
					</div>
					<div class="total reviewContent">
						<dl>
							<dd><textarea placeholder="메뉴설명" name="info"></textarea></dd>
						</dl>
					</div>
				</div>
				<div class="mine-button">
					<div class="popup-button">
						<button class="btn btn_02" id="menuRegister" type="button">메뉴 등록하기</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<script>
		var thisSno = $("tbody").data("sno")
		var lastNo;
		var amount = 20;
		$(function() {

			$("#menu").on("click", function() {
				if ($('#modal-order').hasClass('active')){
                    $('#modal-order').removeClass("active");
                    $("html, body").css("overflow","initial");X
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
					url : "/upload/" + 2,
					dataType : "json"
				}).done(function(result) {
					console.log(result);
					$(".attachName").html($clone.html());

					var str = "";
					for(var i in result) {
						str += '<dd data-uuid="' + result[i].uuid + '" data-path="' + result[i].path + '" data-image="' + result[i].image + '" data-origin="' + result[i].origin + '">';
						str += '	<a href="/download?' + $.param(result[i]) + '">' + result[i].origin + '</a><button type="button" class="close"><span>&times;</span></button>';
						str += '</dd>';
					}
					$(".attachName").append(str);
				})
			})
			
			// // 파일 삭제 이벤트
			// $(".attachName").on("click", ".close", function(){
			// 	var $dom = $(this).closest("[data-uuid]");

			// 	var uuid = $dom.data("uuid");
			// 	var image = $dom.data("image");
			// 	var path = $dom.data("path")
			// 	console.log(path)
			// 	$.post({
			// 		url : "/deleteFile",
			// 		data : {uuid : uuid, path : path, image:image},
			// 		success : function(result) {
			// 			$("[data-uuid='" + uuid + "']").remove();
			// 		}
			// 	})
			// })

			// $("table").on("click", "a.delete", function() {
			// 	event.preventDefault();
			// 	var uuid = $(this).data("uuid");
			// 	var image = $(this).data("image");
			// 	var path = $(this).data("path");
			// 	console.log(path)
			// 	$.post({
			// 		url : "/deleteFile",
			// 		data : {uuid : uuid, path : path, image:image},
			// 		success : function(result) {
			// 			console.log("delete!!!")
			// 		}
			// 	})
			// })
			
			// 메뉴등록완료
			$("#menuRegister").on("click", function() {
				event.preventDefault();
				
				var inputStr = '';
				var str = "";

				inputStr+= '<input type="hidden" value="' + thisSno + '" name="sno">';

				$("#frm").append(inputStr);


				var attrArr = ['uuid', 'origin', 'path'];
				for(var j in attrArr) {
					str +=
						$("<input>")
						.attr("type", "hidden")
						.attr("name", "attach." + attrArr[j])
						.attr("value", $(this).closest("#frm").find(".attachName dd").data(attrArr[j]))
						.attr("value", $("#frm").find(".attachName dd").data(attrArr[j]))
						.get(0).outerHTML + "\n";
				}
				
				$(this).closest("#frm").append(str).submit();
				
				
				$("#frm").append(str)
				$("#frm").submit();
			})

			$(".menuList").on("click", ".changeState", function() {
				event.preventDefault();
				var mno = $(this).closest("tr").find("input").data("mno");
				$.ajax({
					url : "/store/menuState/" + mno,
					type : "get"
				})
				showList(thisSno, lastNo, amount)
			})
			
			// 메뉴 목록 띄우기
			function showList(thisSno, lastNo, amount) {
				console.log(lastNo, amount)
				var param = {sno: thisSno, lastNo: lastNo, amount: amount}
				scrollService.getMenuList(param, function(result) {
					var str = '';
					for(var i in result) {
						str += getMenuStr(result[i]);
					}
					$(".menuList").html(str);
				}, function(xhr) {
					console.log(xhr);
				})
			}
			showList(thisSno, lastNo, amount);
	
			function getMenuStr(menu) {
				var str = '';
				str += '<tr>';
				str += '	<input type="hidden" name="mno" data-mno="' + menu.mno + '" value="' + menu.mno + '">';
				str += '	<td data-sno=' + thisSno+ '>' + menu.name + '</td>';
				str += '	<td>' + menu.price + '원</td>';
				str += '	<td>';
				if(menu.state) {
					str += '			<a href="#" class="changeState">판매중</a>';
				}
				else {
					str += '			<a href="#" class="changeState">판매중지</a>';
				}
				// str += '	</td>';
				// if(!menu.attach.uuid) {
				// 	str += '	<td>';
				// 	str += '		<label>';
				// 	str += '			사진 등록';
				// 	str += '			<i class="fas fa-camera-retro"></i>';
				// 	str += '			<input type="file" class="d-none">';
				// 	str += '		</label>';
				// 	str += '	</td>';
				// }
				// else {
				// 	str += '	<td>';
				// 	str += '		<a href="#" class="delete" data-uuid="' + menu.attach.uuid + '" data-path="' + menu.attach.path + '" data-image="' + menu.attach.image + '" data-origin="' + menu.attach.origin + '">사진 삭제</a>';
				// 	str += '	</td>';
				// }
				// str += '</tr>';
	
				return str;
			}
	
	
			// 무한스크롤 리뷰 더보기
			$(document).scroll(function() {
				var dh = $(document).height();
				var wh = $(window).height();
				var wst = $(window).scrollTop();
				if(dh == wh + wst) {
					var lastNo = $(".menuList tr:last-child input").data("mno");
					var param = {sno:thisSno, lastNo:lastNo};
					scrollService.getMenuList(param, function(result) {
						var str = '';
						for(var i in result) {
							str += getMenuStr(result[i]);
						}
						$(".menuList").append(str);
					})
				}
			})




		})
		
		</script>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>