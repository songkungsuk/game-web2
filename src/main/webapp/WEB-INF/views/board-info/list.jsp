<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
	<h1>list</h1>
	<div class="container">
		<table class="table" style="text-align: center;">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.biNum}</td>
						<td>${board.biTitle }</td>
						<td>${board.uiNum }</td>
						<td>${board.credat }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right" onclick="goPage('/board-info/insert')"><button
							type="button" class="btn btn-primary">등록</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script>
		function goPage(url){
			location.href = url;
		}
	</script>
</body>
</html>