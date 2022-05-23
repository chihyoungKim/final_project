<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../views/common/head.jsp"/>
</head>
<body>
    <div class="site-mobile-menu">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close">
            	<span class="icofont-close js-menu-toggle"></span>
            </div>
        	<div class="site-mobile-menu-body"></div>
		</div>
    </div> <!-- /.untree_co-hero -->
    <jsp:include page="../views/common/nav.jsp"></jsp:include>
    <div class="untree_co-hero">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-12">
                    <div class="row align-items-center justify-content-between">
                        <div class="col-lg-5">
                            <h1 class="mb-4 heading" data-aos="fade-up" data-aos-delay="100">"오늘 뭐먹조?"</h1>
                            <div class="mb-4 desc" data-aos="fade-up" data-aos-delay="200">
                            	<p><a href="#" target="_blank" class="link-highlight">음식점 고르기 전</a></p>
                            </div>
                            <div class="input-group">
	                            <input class="form-control mr-1" type="text" id="address" placeholder="주소를 입력하세요">
								<button class="btn btn-primary btn-sm" type="button" onclick="execDaumPostcode()" >주소검색</button>
							</div>
							<div class="mb-3" id="map" style="width:438px; height:250px ;margin-top:10px;display:none"></div>
                        </div>
                        <div class="col-lg-6" data-aos="fade-up" data-aos-delay="100">
                            <div class="w3-content w3-section" >
								<img class="mySlides" src="/resources/assets/images/치킨.png" >
								<img class="mySlides" src="/resources/assets/images/피자.png" >
								<img class="mySlides" src="/resources/assets/images/중식.png" >
								<img class="mySlides" src="/resources/assets/images/한식.png" >
								<img class="mySlides" src="/resources/assets/images/돈까스.png" >
								<img class="mySlides" src="/resources/assets/images/보쌈.png" >
							</div>
                        </div>
                    </div>
                </div>
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div>	  
	<div class="untree_co-section">
	    <div class="container">
	    	<div class="row mb-5">
	     		<div class="col-lg-12 text-center">
	        	<ul class="custom-nav js-custom-dots list-unstyled">
	            	<li class="active"><a href="#">menu</a></li>
	        	</ul>
	        </div>
		</div>
	    <div class="owl-single no-dots owl-carousel">
			<div class="item">
	        	<div class="row mb-5">
	            	<div class="col-12 text-center">
	            	<h2 class="heading">Category</h2>
	        		</div>
	       		</div>
		        <div class="row">
		        	<div class="col-6 col-md-6 col-lg-4 mb-4">
			            <div class="product">
			            	<a href="/store/list/1" class="thumbnail"><img src="/resources/assets/images/치킨.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="/store/list/1">치킨</a></h3>
			            </div>
		        	</div>
			        <div class="col-6 col-md-6 col-lg-4 mb-4">
			        	<div class="product">
			            	<a href="/store/list/2" class="thumbnail"><img src="/resources/assets/images/피자.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="/store/list/2">피자</a></h3>
			            </div>
			        </div>
			        <div class="col-6 col-md-6 col-lg-4 mb-4">
			        	<div class="product">
			            	<a href="/store/list/3" class="thumbnail"><img src="/resources/assets/images/중식.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="/store/list/3">중국집</a></h3>
			            </div>
			        </div>
			        <div class="col-6 col-md-6 col-lg-4 mb-4">
				        <div class="product">
			                <a href="/store/list/4" class="thumbnail"><img src="/resources/assets/images/한식.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="/store/list/4">한식</a></h3>
			            </div>
			        </div>
			        <div class="col-6 col-md-6 col-lg-4 mb-4">
				        <div class="product">
			                <a href="/store/list/5" class="thumbnail"><img src="/resources/assets/images/돈까스.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="/store/list/5">일식/돈까스</a></h3>
			            </div>
			        </div>
			        <div class="col-6 col-md-6 col-lg-4 mb-4">
			     		<div class="product">
			            	<a href="/store/list/6" class="thumbnail"><img src="/resources/assets/images/보쌈.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="/store/list/6">족발/보쌈</a></h3>
			            </div>
			        </div>
			    </div>
		    </div>
	    </div>
    </div>
</div>
<jsp:include page="../views/common/footer.jsp"></jsp:include>
<script>
//W3school Automatic Slideshow
	var myIndex = 0;
	carousel();
	function carousel(){
	    var i;
	    var x = document.getElementsByClassName("mySlides");
	    for (i = 0; i < x.length; i++){
	        x[i].style.display = "none";
	    }
	    myIndex++;
	    if (myIndex > x.length ) {
	        myIndex = 1
	    }
	    x[myIndex-1].style.display = "block";
	    setTimeout(carousel, 1500); //Change image every 1.5 seconds
	};

//다음 카카오 주소 API
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };

    //지도를 미리 생성
    var map = new daum.maps.Map(mapContainer, mapOption);
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    //마커를 미리 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });

    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("address").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {
                        var result = results[0]; //첫번째 결과의 값을 활용
                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(result.y, result.x);
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
    }
    </script>
</body>

</html>