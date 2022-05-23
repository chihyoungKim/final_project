<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		      <section class="banner_main ">
		         <div class="container">
			        <div class="d-flex justify-content-center">
			            <div class="col-md-10" >
			               <form id="request" class="main_form align-items-center " method="post" name="frm">
			                  <div class="row input-group ">
			                     <div class="col-md-12  ">
			                     	<label for="id">아이디</label>
			                        <input class="contactus mb-5 " placeholder="아이디" type="text" id="id" name="id" value="${member.id}" readonly>
			                     </div>
			                     <div class="col-md-12 list">
			                     	<label for="name">이름</label>
			                        <input class="contactus mb-5 " placeholder="이름" type="text" name="name" id="name" value="${member.name}" readonly>
			                     </div>
			                     <div class="col-md-12 list">
			                     	<label for="phoneNum">전화번호</label>
			                        <input class="contactus mb-5 " placeholder="전화번호" type="text" name="tel" id="phoneNum" value="${member.tel}" readonly>
			                     </div>
			                     <div class="col-md-12 list">
			                     		<label for="email">이메일</label>
			                        <input class="contactus mb-1 " placeholder="이메일" type="email" name="email" id="email" value="${member.email}" readonly>
			                        <c:if test="${member.emailAuth == 0}">
				                        <button class="btn btn-danger mb-5" type="button" id="btnEmail">이메일 인증</button>
			                        </c:if>
			                        <c:if test="${member.emailAuth == 1}">
				                        <button class="btn btn-success mb-5" type="button" disabled>인증된 메일</button>
			                        </c:if>
			                     </div>
			                     <div class="col-md-12 ">
			                     	<label for="nickName">닉네임</label>
			                        <input class="contactus mb-5" placeholder="닉네임" type="text" name="nickName" value="${member.nickName}" readonly>
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
			$(function() {
				$("#btnEmail").click(function() {
					var $btnEmail = $(this);
					var str = '<img src="https://i.stack.imgur.com/qq8AE.gif" width="24px">';
        			console.log("제발!")
					var data = {email : $("#email").val(), id : $("#id").val()}
					$.ajax("/member/memberAuth", {
						data:data,
						method:"get",
						beforeSend : function() {
							$btnEmail.prop("disabled", true).html(str+"발송중");
						},
						success : function(data) {
							$btnEmail.prop("disabled", false).html("이메일 인증");
							console.log(data)
						}
					})
				})
			});
		</script>
</body>
</html>