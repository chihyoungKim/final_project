<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<nav class="site-nav nav-power">
    <div class="container-fluid">
        <div class="site-navigation text-center">
        	<sec:authorize access="isAnonymous()">
	            <a href="/index" class="logo menu-absolute m-0">오늘뭐먹조<span class="text-primary">?</span></a>
	            <a href="/member/login" class="btn-book btn btn-primary btn-sm menu-absolute">로그인정보</a>
        	</sec:authorize>
        	
             <sec:authorize access="isAuthenticated()">
	             <a href="/member/notice" class="btn-book btn btn-primary btn-sm menu-absolute">mypage</a>
	             <a href="/store/notice" class="btn-book btn btn-primary btn-sm menu-absolute">사장님</a>
	             <a href="/index" class="logo menu-absolute m-0">오늘뭐먹조<span class="text-primary">?</span></a>
	             <form action="/logout" method="post" onsubmit="return confirm('로그아웃하시겠습니까?')">
	                 <button class="btn-book btn btn-primary btn-sm menu-absolute ">Logout</button>
	             <sec:csrfInput/>
	             </form>
             </sec:authorize>
        </div>
    </div>
</nav>