<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
	<style>
		#join-form {
			display: flex;
			flex-direction: column;
			width: 420px;
			height: 445px;
			margin: 0 auto;
		}
		.form_item {
			margin-bottom: 10px;
		}
		.form_item label {
			color: var(--label-text-color);
			font-weight: 700;
		}
		.form_item input {
			box-sizing: border-box;
			display: block;
			width: 100%;
			background-color: var(--input-bg-color);
			/* border: var(--border-width-input) solid var(--border-color-input); */
			border: none;
			line-height: 1.5;
		}
		.btn_box {
			display: flex;
			justify-content: center;
		}
		.btn_box button {
			width: 100%;
			margin-top: 20px;
			padding: 10px;
			border: none;
			background-color: var(--button-bg-color);
			color: var(--button-color);
			cursor: pointer;
		}
		.btn_box button:hover {
			background-color: var(--button-hover-bg-color);
		}
		.message {
			display: none;
			margin-left: 10px;
			font-weight: bold;
			font-size: small;
		}
	</style>
	<script>
		$(function() {
			function regId(username) {
				let regex = /^[a-zA-Z0-9]{4,12}$/
				return regex.test(username)
			}
			
			$("#username").on("keyup", function() {
				$(this).val( $(this).val().replace(/[^a-zA-Z0-9]/g, "") )
			})
			
			$(document).on("click", "#btn-join", function() {
				let username = $("#username")
				let password = $("#password")
				let re_password = $("#re_password")
				
				if(username.val() == "") {
					alert("아이디를 입력하세요.")
					username.focus()
					return false
				} else if ( !regId(username.val()) ) {
					alert("아이디는 4~12자의 영문 대소문자와 숫자로만 입력하세요.")
					username.focus()
					return false
				} else if (password.val() == "") {
					alert("비밀번호를 입력하세요.")
					password.focus()
					return false
				} else if (re_password.val() == "") {
					alert("비밀번호 확인을 입력하세요.")
					re_password.focus()
					return false
				} else if (password.val() != re_password.val()) {
					alert("비밀번호가 다릅니다.\n다시 확인해주세요.")
					re_password.focus()
					return false
				}
				
				$("#join-form").submit()
			})
			
			// 현재 입력박스에서 포커스가 벗어났을때 발생하는 이벤트
			// 아이디 중복 확인
			$(document).on("blur", "#username", function() {
				let username = $(this).val()
				
				if( !regId(username) ) {
					$("#m_username").text("* 아이디는 4~12자의 영문 대소문자와 숫자로만 입력하세요")
					$("#m_username").css("color", "var(--color-danger)")
					$(".message").css("display", "block")
					return false
				}
				
				$.ajax({
					url : "${rootPath}/user/idcheck",
					type : "GET",
					data : {username : username},
					success : function(result) {
						if(result) {
							$("#m_username").text("* 이미 사용중인 ID입니다")
							$("#m_username").css("color", "var(--color-danger)")
							$(".message").css("display", "block")
						} else {
							$("#m_username").text("* 사용 가능한 ID입니다")
							$("#m_username").css("color", "var(--color-success)")
							$(".message").css("display", "block")
						}
					},
					error : function() {
						$("#m_username").text("* 서버 통신 오류")
						$("#m_username").css("color", "var(--color-danger)")
						$(".message").css("display", "block")
					}
				})
			})
		})
	</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_nav.jspf" %>
	<h2>회원가입</h2>
	<form:form id="join-form" action="${rootPath}/join/join-s1" method="POST" autocomplete="off">
		<!--
		<input name="${_csrf.parameterName}" value="${_csrf.token}">
		-->
		
		<div class="form_item">
			<label for="username">ID</label>
		</div>
		
		<div class="form_item">
			<input id="username" name="username"/>
			<span id="m_username" class="message"></span>
		</div>
		
		<div class="form_item">
			<label for="password">비밀번호</label><br/>
		</div>
		
		<div class="form_item">
			<input id="password" name="password" type="password" />
		</div>
		
		<div class="form_item">
			<label for="re_password">비밀번호 확인</label><br/>
		</div>
		
		<div class="form_item">
			<input id="re_password" name="re_password" type="password" >
		</div>
		
		<div class="form_item btn_box">
			<button id="btn-join" type="button">회원가입</button>
		</div>
	</form:form>
</body>
</html>