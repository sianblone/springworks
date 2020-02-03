<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="">
	<div class="input-group">
		<form:input class="form-control" path="bbs_date" placeholder="날짜" />
	</div>
	
	<div class="input-group">
		<form:input class="form-control" path="bbs_time" placeholder="시간" />
	</div>
	
	<div class="input-group">
		<form:input class="form-control" path="bbs_writer" placeholder="작성자" />
	</div>
	
	<div class="input-group">
		<form:input class="form-control" path="bbs_subject" placeholder="제목" />
	</div>
	
	<div class="input-group">
		<form:textarea class="form-control" path="bbs_content" placeholder="내용" />
	</div>
</form:form>