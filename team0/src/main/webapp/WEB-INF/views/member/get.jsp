<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="ko">
   	<head>
		<!-- <meta name="google-signin-client_id" content="347160871077-577pujh4td24j5iv9dog5kp903esu6rh.apps.googleusercontent.com"> -->
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
	               <form id="request" class="main_form align-items-center " method="post" name="frm">
	                  <div class="row input-group">
	                     <div class="col-md-12 ">
							<span id="idError"></span>
							<label for="id"></label>
	                        <input class="contactus check" placeholder="아이디" type="text" id="id" name="id" readonly>
	                     </div>
	                     <div class="col-md-12 list">
							<span id="pwError"></span>
	                        <input class="contactus check" placeholder="비밀번호" id="pw" type="password" name="password">
	                     </div>
	                     <div class="col-md-12 list">
							<span id="pwCheckError"></span>
	                        <input class="contactus check" placeholder="비밀번호 확인" type="password" id="pwCheck" name="password2">
	                     </div>
	                     <div class="col-md-12 list">
							<span id="nameError"></span>
	                        <input class="contactus check" placeholder="이름" type="text" name="name" id="name">
	                     </div>
	                     <div class="col-md-12 list">
							<span id="phoneNumError"></span>
	                        <input class="contactus check" placeholder="전화번호" type="text" name="tel" id="phoneNum">
	                     </div>
	                     <div class="col-md-12 list">
							<span id="emailError"></span>
	                        <input class="contactus check" placeholder="이메일" type="email" name="email" id="email">
	                        <button>이메일 인증~</button>
	                     </div>
	                     <div class="col-md-12 ">
	                        <input class="contactus" placeholder="닉네임" type="text" name="nickName">
	                     </div>
	                     <div class="col-md-12 ">
	                        <input class="contactus" placeholder="사장이름" type="text" name="bossName">
	                     </div>
						
						<sec:csrfInput/>
	                    <div class="col-sm-12">
	                        <button class="send_btn" id="send_btn">회원가입</button>
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
      
      <script>
		window.onload = function() {
			var frm = document.frm;
			var input = document.querySelectorAll('.check')

			var errorId = ["idError", "pwError", "pwCheckError", "nameError", "phoneNumError", "emailError"];
			var error = document.querySelectorAll('.list > span')

			function innerReset(error) {
				for(var i = 0; i < error.length; i++) {
					error[i].innerHTML = "";
				}
			}

			innerReset(error);

			

			// 비밀번호 입력문자 유효성검사
			frm.pw.onkeydown = function() {
				innerReset(error);
				var pwLimit = /^[a-zA-Z0-9~!@#$%^&*()_-]{10,20}$/; //정규식(a~z, A~Z, 0~9, ~!@#$%^&*()_- 만 입력가능)
				if(!pwLimit.test(input[1].value)) {
					document.getElementById(errorId[1]).innerHTML = "10~20자의 영문 소대문자, 숫자와 특수기호 '~!@#$%^&*()_-'만 사용 가능합니다.";
				}
			}

			// 비밀번호 확인 입력문자 유효성검사
			frm.pwCheck.onkeydown = function() {
				innerReset(error);
			}

			// 휴대번호 입력문자 유효성검사
			frm.phoneNum.onkeydown = function() {
				innerReset(error);
				var pnumLimit = /01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/; // 정규식(^$--> 문자의미, 01, (6자리중 "1자리"), 0~9--> "8자리")
				if(!pnumLimit.test(input[4].value)) {
					document.getElementById(errorId[4]).innerHTML = "올바른 형식이 아닙니다. 다시 확인해주세요.";
				}
			}

			frm.email.onkeydown = function() {
				innerReset(error);
				var emailLimit = /[0-9a-zA-Z-@_.]/; // 정규식 0~9, a~z, A~Z, -, _, .내에서만 입력가능
				if(!emailLimit.test(input[5].value)) {
					document.getElementById(errorId[5]).innerHTML = "올바른 형식이 아닙니다. 영문, 숫자, (-)(_)(.) 입력만 가능합니다.";
				}
			}

			frm.onsubmit = function() {
				var errorStr = [" 아이디를", " 비밀번호를", " 비밀번호 확인을", " 성함을", " 휴대폰번호를", " 이메일을"];
				innerReset(error);

				for(var i = 0; i < input.length - 1; i++) {
					if(!input[i].value) {
						document.getElementById(errorId[i]).innerHTML = errorStr[i] + " 입력해 주세요.";
						input[i].focus();
						return false;
					}
				}
				if(frm.pw.value != frm.pwCheck.value) {
					document.getElementById("pwCheckError").innerHTML = "비밀번호가 일치하지 않습니다.";
					frm.pwCheck.focus();
					return false;
				}

				var pwLimit = /^[a-zA-Z0-9~!@#$%^&*()_-]{10,20}$/;///[a-zA-Z0-9]{10, 20}/; //정규식(a~z, A~Z, 0~9,~!@#$%^&*()_-특수문자 만 입력가능)
				var pnumLimit = /01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/; // 01로 시작, 0,1,6,7,8,9 중 한자리, 0~9에서 8자리 입력
				var emailLimit = /[0-9a-zA-Z-_.]/; // 정규식 0~9, a~z, A~Z, -, _, .내에서만 입력가능

				

				if(!pwLimit.test(input[1].value)) {
					document.getElementById(errorId[1]).innerHTML = "10~20자의 영문 소대문자, 숫자와 특수기호 '~!@#$%^&*()_-'만 사용 가능합니다.";
					console.log(input[1].value);
					frm.pw.focus();
					return false;
				}

				if(!pnumLimit.test(input[4].value)) {
					document.getElementById(errorId[4]).innerHTML = "올바른 형식이 아닙니다. 다시 확인해주세요.";
					console.log(input[4].value);
					frm.phoneNum.focus();
					return false;
				}
				
				if(!emailLimit.test(input[5].value)) {
					document.getElementById(errorId[5]).innerHTML = "올바른 형식이 아닙니다. 영문, 숫자, (-)(_)(.) 입력만 가능합니다.";
					console.log(input[5].value);
					frm.email.focus();
					return false;
				}
				alert("회원가입이 완료되었습니다! :D")
			}

		} 
      </script>
   	
		
   </body>
</html>



