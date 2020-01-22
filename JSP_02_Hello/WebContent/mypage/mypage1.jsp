<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/*
EL(Expression Language) Tag
page.jsp보단 더 나중에 사용하던 코드(지금도 사용하는 코드)
JSP에서 디자이너와 개발자의 협업중에 많은 문제들이 발생한다
JSP(HTML) 디자이너에게 JAVA 코드의 학습을 강요하고 이런 과정에서 문제들이 일어나기 때문이다

Java 진영에서는 이러한 문제를 줄이기 위해
HTML 코드 내에서 최소한의 Java 문법만을 사용하여 디자이너와 협업할 수 있도록
EL Tag 라는 특별한 언어 구조를 만들어냈다
현재 MVC 패턴에서도 대부분의 코드는 EL Tag로 구현되고 있다

${변수, 연산식, 등등...} => System.out.println과 같은 역할
문자열은 작음따옴표, 큰따옴표 상관 없다
*/
%>
<h3>${param.strName}의 페이지</h3>
<h3>${ 30 + 40}</h3>
<h3>${100 * 100 }</h3>
<h3>${"대한민국"}</h3>
<h3>${'대한민국'}</h3>
<h3>${param.num1 + param.num2}</h3>

</body>
</html>