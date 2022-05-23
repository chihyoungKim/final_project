<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="ko">
   	<head>
		<meta name="google-signin-client_id" content="347160871077-577pujh4td24j5iv9dog5kp903esu6rh.apps.googleusercontent.com">
    	<jsp:include page="../common/head.jsp"></jsp:include>
      
   </head>
   <!-- body -->
   <body class="main-layout">
     <jsp:include page="../common/nav.jsp"></jsp:include>
      <!-- loader  -->
    <!--   <div class="loader_bg">
         <div class="loader"><img src="/resources/assets/images/loading.gif" alt="#" /></div>
      </div> -->
      <!-- end loader -->
 
      <!-- banner -->
      <section class="banner_main">
         <div class="container">
	        <div class="row d_flex ">
	        <div class="col-md-6">
               <div class="text-bg">
                  <h1>저기압일땐<br>
					  고기앞으로<br>
					  가기위해 -></h1>
                  <h3>★ 집밥귱선생님의 오마카세 ㅎㅅㅎ ★</h3>
               </div>
            </div>
	            <div class="col-md-6" style="margin-top: 100px;">
	               <form id="request" class="main_form align-items-center" method="post" action="/login">
	                  <div class="row">
	                     <div class="col-md-12 ">
	                     	<label for="username">아이디</label>
	                        <input class="contactus mb-5" placeholder="아이디" type="text" name="username"> 
	                     </div>
	                     <div class="col-md-12 ">
	                     	<label for="password">비밀번호</label>
	                        <input class="contactus mb-5" placeholder="비밀번호" type="password" name="password">
	                     </div>
						<!-- <div class="md-3">
							<div class="col-sm-12" style="display: inline;">
								 <a href="javascript:kakaoLogin();" ><img src="/resources/assets/images/kakao_login_large.png" alt="카카오계정 로그인" class="login_btn" /></a>
							</div>
							<div class="col-sm-12 " style="display: inline;">
								<div id="naver_id_login"></div>
							</div>
							<div class="g-signin2 mb-3" data-onsuccess="onSignIn"></div>
						</div> -->
						<sec:csrfInput/>
	                    <div class="col-sm-12 ">
	                        <button class="btn btn-block send_btn mb-3" id="send_btn">로그인</button>
	                        <a class="btn btn-block send_btn mb-3" id="send_btn" href="/member/contract">회원가입</a>
	                    </div>
						<div class="btn-wrap btn-wrap-column col-md-12 mb-3">
							<a href="javascript:kakaoLogin();">
								<button type="button" class="btn btn-long icon-layout icon-kakao" >카카오로 시작하기</button>
							</a> <!--disabled(클래스 아님) 비활성화-->
						</div>
	                 </div>
	              </form>
	           </div>
	        </div>
         </div>
      </section>
      <!-- end banner -->

      <!--  footer -->
      <footer>
         <jsp:include page="../common/footer.jsp"/>
      </footer>
      <!-- end footer -->
      
       
      <!--  login api -->
      <!-- <script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
      <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script> -->
  	  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
      <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	  <<!-- script src="https://apis.google.com/js/platform.js" async defer></script> -->
	  
       
	   <script>
	   		/* kakao */
	        window.Kakao.init('8078298f58e4ab6bfa88c7240345f660');
	
	        function kakaoLogin() {
	            window.Kakao.Auth.login({
	                scope: 'profile_nickname,profile_image, account_email, gender, age_range, birthday', //동의항목 페이지에 있는 개인정보 보호 테이블의 활성화된 ID값을 넣습니다.
	                success: function(response) {
	                    console.log(response) // 로그인 성공하면 받아오는 데이터
	                    window.Kakao.API.request({ // 사용자 정보 가져오기 
	                        url: '/v2/user/me',
	                        success: (res) => {
	                            const kakao_account = res.kakao_account;
	                            console.log(kakao_account)
	                        }
	                    });
	                    // window.location.href='/ex/kakao_login.html' //리다이렉트 되는 코드
	                },
	                fail: function(error) {
	                    console.log(error);
	                }
	            });
	        }
	    	
        /* google */
		function onSignIn(googleUser) {
				var profile = googleUser.getBasicProfile();
				console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
				console.log('Name: ' + profile.getName());
				console.log('Image URL: ' + profile.getImageUrl());
				console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
				
				var idToken = googleUser.getAuthResponse().idToken;
				console.log("ID Token: " + idToken);
		}
		</script>

   </body>
</html>



