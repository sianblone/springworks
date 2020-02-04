<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initian-scale=1">
	<title>JSP 페이지</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<style>
		body {
			border: 1px solid #aaa;
		}
	</style>
	<script>
		$(function() {
			$("#btn-write").click(function() {
				document.location.href="${rootPath}/bbs/input"
			})
		})
	</script>
</head>

<header class="jumbotron text-center">
		<h3>Build Board System</h3>
</header>

<ul class="nav">
	<li class="nav-item"><a class="nav-link" href="${rootPath}/">Home</a></li>
	<li class="nav-item justify-content-end"><a class="nav-link" href="${rootPath}/member/login">로그인</a></li>
	<li class="nav-item"><a class="nav-link" href="${rootPath}/member/join">회원가입</a></li>
</ul>

<body class="container-fluid">

	<section>
		<c:choose>
			<c:when test="${BODY == 'BBS_INPUT'}">
				<%@ include file="/WEB-INF/views/include/bbs_input.jsp" %>
			</c:when>
			<c:when test="${BODY == 'BBS_LIST'}">
				<%@ include file="/WEB-INF/views/include/bbs_list.jsp" %>
			</c:when>
			<c:when test="${BODY == 'BBS_VIEW'}">
				<%@ include file="/WEB-INF/views/include/bbs_view.jsp" %>
			</c:when>
		</c:choose>
	</section>
</body>
</html>