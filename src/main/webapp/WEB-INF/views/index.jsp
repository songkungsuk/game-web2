<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>후 끝났다.. 다른거나 공부해야지
<h1>내 세션아이디</h1><%=session.getId() %>
<%=session.getMaxInactiveInterval() %>
<c:if test="${user !=null}">
	${user.UI_NAME}님 안녕하세요.
	<button onclick="location.href='/user-info/logout'">로그아웃</button>
</c:if>
<c:if test="${user == null}">
	<button onclick="location.href='/user-info/login'">로그인</button>
</c:if>
<a href="/user-info/list">리스트보기</a>
</body>
</html>