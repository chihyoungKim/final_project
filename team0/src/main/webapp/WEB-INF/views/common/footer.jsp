<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="site-footer">
    <div class="container">
	    <div class="row">
    	    <div class="col-lg-7">
        		<div class="widget">
	            	<h3> Introduction </h3>
	           		<p>  [과정평가형국가기술자격]정보처리산업기사(Java프로그래밍기반 B) 교육과정의 최종 프로젝트로 <strong>'오늘뭐먹조?'</strong> 라는 배달 웹사이트를 제작하였습니다. </p>
	           		<p> 영등포휴먼교육센터 근처 음식점을 카테고리별로 검색할 수 있으며, 메뉴 및 수량 선택 후 주문이 가능합니다. 결제 완료 이후에는 결제 내역이 남아 리뷰를 작성할 수 있으며, 사장님과 일반회원을 구분하여 각각의 마이페이지를 제작하였습니다.   </p>
         		</div> <!-- /.widget -->
      		</div>
	        <div class="col-lg-5  d-flex justify-content-center ">
		        <div class="widget">
	    	        <h3>Contact</h3>
	            	<address>서울특별시 영등포구 영등포동3가 8-1 1호</address>
	            	<address>6층 휴먼교육센터</address>
	            	<ul class="list-unstyled links mb-4">
	              		<li><a href="tel://02-3667-3688">02-3667-3688</a></li>
	              		<li><a href="mailto:info@mydomain.com">info@human.com</a></li>
	            	</ul>
	          	</div> <!-- /.widget -->
	        </div> <!-- /.col-lg-3 -->
	    </div> <!-- /.row -->
	    <div>
	        <div class="widget ">
	          <h3 class="mb-3 d-flex justify-content-center ">Member : 김승종, 김치형, 이나현, 황규웅 </h3>
	          <ul class="list-unstyled social d-flex justify-content-center ">
	            <li><a href="http://www.uhducom.com/"><span class="fas fa-moon"></span></a></li>
	            <li><a href="http://www.wdkim.com/"><span class="fas fa-desktop"></span> </a></li>
	            <li><a href="https://inadang.com/"><span class="fas fa-egg"></span></a></li>
	            <li><a href="https://woongsun.com/"><span class="fas fa-star"></span></a></li>
	          </ul>
	        </div>
	    </div>
	    <div class="row mt-5">
		    <div class="col-12 text-center">
	    	    <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script>. All Rights Reserved. &mdash; Designed with love by Untree.co &bullet; License
	        	</p>
	        </div>
	    </div>
    </div> <!-- /.container -->
</div> <!-- /.site-footer -->
<div id="overlayer"></div>
	<div class="loader">
    	<div class="spinner-border" role="status">
      	<span class="sr-only">Loading...</span>
    </div>
</div>

	<script src="/resources/assets/js/jquery-3.4.1.min.js"></script>
	<script src="/resources/assets/js/popper.min.js"></script>
	<script src="/resources/assets/js/bootstrap.min.js"></script>
	<script src="/resources/assets/js/owl.carousel.min.js"></script>
	<script src="/resources/assets/js/jquery.animateNumber.min.js"></script>
	<script src="/resources/assets/js/jquery.waypoints.min.js"></script>
	<script src="/resources/assets/js/jquery.fancybox.min.js"></script>
	<script src="/resources/assets/js/aos.js"></script>
	<script src="/resources/assets/js/custom.js"></script>
	<script src="/resources/assets/js/review.js"></script>
	<script src="/resources/assets/js/cart.js"></script>
	<script src="/resources/assets/js/scroll.js"></script>
	<script src="/resources/assets/js/modernizr.custom.js"></script>
	<script src="/resources/assets/js/classie.js"></script>
	<script src="/resources/assets/js/modernizr.custom.26887.js"></script> 
	
	
	<script type="text/javascript" src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<script type="text/javascript" src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="/resources/assets/js/common.js"></script>
	
    <!-- 아이엠포트 -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

	<!-- kakao 주소 api 스크립트 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e94688a03c433ea3b07e95047a117103&libraries=services"></script> <!-- 자바스크립트키  -->
	<!-- <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=63fe7aacba1d69b3a0922487cac4d177&libraries=services"></script> RESTAPI키 -->
	
</body>
</html>