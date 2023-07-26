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
	<table border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>설명</td>
			<td>등급</td>
		</tr>
		<c:forEach items="${gameList}" var="game">
			<tr>
				<td>${game.GAME_NUM}</td>
				<td>${game.GAME_NAME}</td>
				<td>${game.GAME_DESC}</td>
				<td>${game.GAME_GRADE}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>