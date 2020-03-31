<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initian-scale=1">
	<title>JSP 페이지</title>
</head>
<body>
	<header>
		<h2>Model Attribute</h2>
	</header>
	
	<section>
		<p><b>User ID : ${usersVO.userId}</b></p>
		<p><b>User Password : ${usersVO.password}</b></p>
		<p><b>User Name : ${usersVO.userName}</b></p>
		<p><b>User Role : ${usersVO.userRole}</b></p>
	</section>
</body>
</html>