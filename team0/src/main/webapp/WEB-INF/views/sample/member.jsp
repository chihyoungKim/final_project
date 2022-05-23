<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2022. 4. 27.오전 11:40:06</title>
</head>
<body>
<h1>sample/member</h1>
<form action="/logout" method="post">
<security:csrfInput/>
<button>logout</button>
</form>
</body>
</html>