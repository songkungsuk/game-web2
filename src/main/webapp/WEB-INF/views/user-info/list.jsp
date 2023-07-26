<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>userList</h1>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>설명</td>
			<td>생일</td>
			<td>만든날</td>
			<td>만든시간</td>
			<td>마지막수정일</td>
			<td>마지막수정시간</td>
		</tr>

		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.UI_NUM}</td>
				<td>${user.UI_NAME}</td>
				<td><a href="/user-info/view?uiNum=${user.UI_NUM}">${user.UI_ID}</a></td>
				<td>${user.UI_PWD}</td>
				<td>${user.UI_DESC}</td>
				<td>${user.UI_BIRTH}</td>
				<td>${user.CREDAT}</td>
				<td>${user.CRETIM}</td>
				<td>${user.LMODAT}</td>
				<td>${user.LMOTIM}</td>
			</tr>
		</c:forEach>
		<tr><td><a href="/user-info/insert">등록</a></td></tr>
	</table>
</body>
</html>