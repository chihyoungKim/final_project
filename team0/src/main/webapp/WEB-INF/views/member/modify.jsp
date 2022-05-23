<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
	<div class="navBorder"></div>
		<div class="dmdk clearfix">
			<div class="col-3 p-0" id="sidebar">
				<jsp:include page="../member/sidebar.jsp"></jsp:include>
			</div>
			<div class="col-9 float-right mt-3">
			  <!-- banner -->
		      <section class="banner_main">
		         <div class="container">
			        <div class="d-flex justify-content-center ">
			            <div class="col-md-10" >
			               <form id="request" class="main_form align-items-center " method="post" name="frm">
			                  <div class="row input-group">
			                     <div class="col-md-12  ">
			                     	<label for="id">아이디</label>
			                        <input class="contactus mb-5" placeholder="아이디" type="text" id="id" name="id" value="${member.id}" readonly>
			                     </div>
			                     <div class="col-md-12 list">
			                     	<span id="pwError"></span>
			                     	<label for="password">비밀번호</label>
			                        <input class="contactus mb-5 check" placeholder="비밀번호" id="pw" type="password" name="password" >
			                     </div>
			                     <div class="col-md-12 list">
			                     	<span id="pwCheckError"></span>
			                     	<label for="password">비밀번호확인</label>
			                        <input class="contactus mb-5 check" placeholder="비밀번호 확인" type="password" id="pwCheck" name="password2" >
			                     </div>
			                     <div class="col-md-12 list">
			                     	<span id="nameError"></span>
			                     	<label for="name">이름</label>
			                        <input class="contactus mb-5 check" placeholder="이름" type="text" name="name" id="name" value="${member.name}" >
			                     </div>
			                     <div class="col-md-12 list">
			                     	<span id="phoneNumError"></span>
			                     	<label for="phoneNum">전화번호(-빼고 입력해주세요)</label>
			                        <input class="contactus mb-5 check" placeholder="전화번호(-빼고 입력해주세요)" type="text" name="tel" id="phoneNum" value="${member.tel}" >
			                     </div>
			                     <div class="col-md-12 list">
			                     	<span id="emailError"></span>
			                     	<label for="email">이메일</label>
			                        <input class="contactus mb-5 check" placeholder="이메일" type="email" name="email" id="email" value="${member.email}" >
			                     </div>
			                     <div class="col-md-12 ">
			                    	 <label for="nickName">닉네임</label>
			                        <input class="contactus mb-5 " placeholder="닉네임" type="text" name="nickName" value="${member.nickName}" >
			                     </div>
			                     <div class="col-sm-12">
			                        <button class="btn btn-block send_btn mb-3" id="send_btn">수정하기</button>
			                    </div>
			                 </div>
			              </form>
			           </div>
			        </div>
		         </div>
		      </section>
		      <!-- end banner -->
			
			</div> 
		</div><!-- /container -->
		<footer>
			<jsp:include page="../common/footer.jsp"/>
		</footer>
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
				frm.pw.onkeyup = function() {
					innerReset(error);
					var pwLimit = /^[a-zA-Z0-9~!@#$%^&*()_-]{10,20}$/; //정규식(a~z, A~Z, 0~9, ~!@#$%^&*()_- 만 입력가능)
					if(!pwLimit.test(input[1].value)) {
						document.getElementById(errorId[1]).innerHTML = "10~20자의 영문 소대문자, 숫자와 특수기호 '~!@#$%^&*()_-'만 사용 가능합니다.";
					}
				}
	
				// 비밀번호 확인 입력문자 유효성검사
				frm.pwCheck.onkeyup = function() {
					innerReset(error);
				}
	
	
				frm.email.onkeyup = function() {
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
					var emailLimit = /[0-9a-zA-Z-_.]/; // 정규식 0~9, a~z, A~Z, -, _, .내에서만 입력가능
	
	
					if(!pwLimit.test(input[1].value)) {
						document.getElementById(errorId[1]).innerHTML = "10~20자의 영문 소대문자, 숫자와 특수기호 '~!@#$%^&*()_-'만 사용 가능합니다.";
						console.log(input[1].value);
						frm.pw.focus();
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