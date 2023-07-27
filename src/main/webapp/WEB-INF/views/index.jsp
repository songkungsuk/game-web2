<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	후 끝났다.. 다른거나 공부해야지
	<h1>내 세션아이디</h1><%=session.getId()%>
	<%=session.getMaxInactiveInterval()%>
	<c:if test="${user !=null}">
		<h3>${user.UI_NAME}님안녕하세요.</h3>
		<ul>
			<li><a href="/user-info/my">내정보</a></li>
			<li><a href="/board-info/list">게시판</a></li>
			<li><a href="/user-info/logout">로그아웃</a></li>
		</ul>
	</c:if>
	<c:if test="${user == null}">
		<button onclick="location.href='/user-info/login'">로그인</button>
	</c:if>
	<a href="/user-info/list">리스트보기</a>
</body>
</html>