<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
	<div class="navBorder"></div>
		<div class="display-flex">
			<div class="col-3 p-0" id="sidebar">
				<jsp:include page="../store/sidebar.jsp"></jsp:include>
			</div>
			<div class="col-9 float-right mt-3; display-flex">
				<div class="card-body">
						<c:if test="${member.sno != null}">
							<h1>등록 되어 있는 가게가 있습니다.</h1>
						</c:if>
						<c:if test="${member.sno == null}">
                            <form method="post">
							<h1>register</h1>
							<hr>
							  <div class="form-group">
							    <label for="title">카테고리</label>
							    <input type="text" class="form-control" placeholder="category" id="category" name="category">
							  </div>
		
							  <div class="form-group">
							    <label for="writer">가게 이름</label>
							    <input type="text" class="form-control" placeholder="name" id="name" name="name">
							  </div>
							  
							  <div class="form-group">
							    <label for="writer">사업자 등록 번호</label>
							    <input type="text" class="form-control" placeholder="business number" id="bno" name="bno">
							  </div>

							  <div class="form-group">
							    <label for="content">주소</label>
							    <input type="text" class="form-control" placeholder="address" id="address" name="address">							    
							  </div>
							  
							  <div class="form-group">
							    <label for="writer">영업 시작 시간</label>
							    <input type="text" class="form-control" placeholder="startTime" id="startTime" name="startTime">							    
							  </div>
							  
							  <div class="form-group">
							    <label for="writer">영업 종료 시간</label>
							    <input type="text" class="form-control" placeholder="endTime" id="endTime" name="endTime">							    
							  </div>

							  <div class="form-group">
							    <label for="writer">가게 공지사항</label>
							    <textarea class="form-control" placeholder="store Notice" id="notice" name="notice" style="resize:none; height:200px"></textarea>
							  </div>
							  
							  <div class="form-group">
							    <label for="writer">원산지 표기</label>
							    <input type="text" class="form-control" placeholder="origin Info" id="originInfo" name="originInfo">							    
							  </div>
							  
							  <h1>DELIVERY</h1>
							  <hr>

							  <div class="form-group">
							    <label for="writer">배달 최소 금액</label>
							    <input type="text" class="form-control" placeholder="Delivery Min Price" id="minPrice" name="minPrice">							    
							  </div>
							  
							  <div class="form-group">
							    <label for="writer">배달료</label>
							    <input type="text" class="form-control" placeholder="Delivery Price" id="delPrice" name="delPrice">							    
							  </div>
							  
							  <div class="form-group">
							    <label for="writer">배달 시간</label>
							    <input type="text" class="form-control" placeholder="Delivery Time" id="delTime" name="delTime">							    
							  </div>

							  <!-- <h1>Logo</h1>
							  
							  <div class="form-group uploadDiv">
							    <label for="attach" class="btn btn-success btn-sm">첨부</label>
							    <input type="file" class="form-control d-none" placeholder="attach" id="attach" name="attach" multiple>
							  </div>
							  <ul class="list-group small px-1 upload-files">
                                  
                              </ul>                         
							  	<style>
							  		.thumbs figure {overflow: hidden;}
							  		.thumbs figure img {transition: all .2s;}
							  		.thumbs figure img:hover {transform: scale(1.05);}
							  	</style>
                              <div class="pt-3 ">
                              	<div class="row thumbs">
                              		<div class="col-6 col-sm-4 col-lg-3 col-xl-2">
		                              	<figure class="d-inline-block " style="position : relative;">
			                              	<figcaption>
			                              		<button type="button" class="close" style="position : absolute; top:15px; right:15px"><span>&times;</span></button>
			                              	</figcaption>
			                              	<a href="/display?origin=%ED%8C%8C%EC%9B%8C%EB%A0%88%EC%9D%B8%EC%A1%B0_ERD.png&amp;uuid=5a9e8713-8e6b-4d5f-9365-2290c0c060d7.png&amp;path=2022%2F05%2F04&amp;image=true" data-lightbox="aa-1" data-title="웅냥냥">
			                              		<img alt="" src="/display?origin=%ED%8C%8C%EC%9B%8C%EB%A0%88%EC%9D%B8%EC%A1%B0_ERD.png&amp;uuid=s_5a9e8713-8e6b-4d5f-9365-2290c0c060d7.png&amp;path=2022%2F05%2F04&amp;image=true" class="mx-1 my-2 img-thumbnail"></a>
			                              	</a>
		                              	</figure>
                              		</div>
                              	</div>
							  </div> -->
							  <sec:csrfInput/>
							  <button type="submit" class="btn btn-primary" id="btnRegisterStore">등록하기</button>
							</form>
						</c:if>
                 </div>	
			</div> 
		</div><!-- /container -->
			  <script>
                $(function() {
                	$("#attach").change(function() {
						var str = "";
                		$(this.files).each(function() {
                			str += "<p>" + this.name + "</p>";
						})
						$(this).next().html(str);
                	});
                })
              </script>
              <script>
				$(function() {
					lightbox.option({
						resizeDuration : 200,
						wrapAround : true,
						imageFadeDuration : 100
					})
					
					var $clone = $(".uploadDiv").clone();
					
					var regexp = /(.*?)\.(exe|sh|js|jsp)$/;
					var maxSize = 1024 * 1024 * 5;
					
					function validateFiles(fileName, fileSize){
						if(fileSize >= maxSize) {
							alert("파일 사이즈")
							return false;
						}
						if(regexp.test(fileName)){
							alert("해당 파일의 종류는 업로드할 수 없습니다.")
							return false;
						}
					}
					
					$(".uploadDiv").on("change", ":file", function() {
						var formData = new FormData();
						
						for(var i in this.files){
							if(validateFiles(this.files[i].name, this.files[i].size)){
								return false;
							}
							formData.append("files", this.files[i])
						}
						
						$.post({
							processData : false,
							contentType : false,
							data : formData,
							url : "/upload",
							dataType : "json"
						}).done(function(result) {
							console.log(result);
							//$(".uploadDiv").html($clone.html())

							var str = "";
							var thumbStr = "";
							for(var i in result){
								// object >> queryString
								// result[i]
								console.log(result[i])
								console.log($.param(result[i]))
								str += '<li class="list-group-item" data-uuid="'+ result[i].uuid +'" data-path="'+ result[i].path +'" data-image="'+ result[i].image +'" data-origin="'+ result[i].origin +'"><a href="/download?' + $.param(result[i]) + '">'
									+ result[i].origin+'</a><button type="button" class="close"><span>&times;</span></button></li>';
								if(result[i].image){
									var o = {...result[i]};
									o.uuid = 's_' + o.uuid;
									thumbStr += '<div class="col-6 col-sm-4 col-lg-3 col-xl-2" data-uuid="'+ result[i].uuid +'" data-path="'+ result[i].path +'" data-image="'+ result[i].image +'" data-origin="'+ result[i].origin +'">';
		                            thumbStr += '  	<figure class="d-inline-block " style="position : relative;">';
			                        thumbStr += '      	<figcaption><button type="button" class="close" style="position : absolute; top:15px; right:15px"><span>&times;</span></button></figcaption>';
			                        thumbStr += '      	<a href="/display?' + $.param(result[i]) + '" data-lightbox="img" data-title="'+ o.origin +'"><img alt="" src="/display?' + $.param(o) + '" class="mx-1 my-2 img-thumbnail"></a>';
		                            thumbStr += '  	</figure>';
                              		thumbStr += '</div>';
								}
							}
							$(".upload-files").append(str);
							$(".thumbs").html(thumbStr)
						})
					})
					
					// 파일 첨부 종료
					
					// 파일 삭제 이벤트
					$(".upload-files, .thumbs").on("click", ".close", function(){
						var $dom = $(this).closest("[data-uuid]");
						var uuid = $dom.data("uuid");
						var image = $dom.data("image");
						var path = $dom.data("path");
						
						$.post({
							url : "/deleteFile",
							data : {uuid:uuid, path:path, image:image},
							success : function(result){
								console.log(result)
								$("[data-uuid='" + uuid + "']").remove()
							}
						})
					})

					// 게시글 등록 이벤트
					$("#btnRegisterStore").click(function(){
						event.preventDefault();
						var str = "";
						var attrArr = ['uuid', 'origin', 'path', 'image'];
						$(".upload-files li").each(function(i){
							for(var j in attrArr){
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
				})
			</script>
		<jsp:include page="../common/footer.jsp"/>
</body>
</html>