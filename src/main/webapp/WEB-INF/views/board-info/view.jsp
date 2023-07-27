<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
view
	<div class="container">
		<table class="table" style="text-align: center;">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">내용</th>
					<th scope="col">최종수정일</th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
						<td>${board.biNum}</td>
						<td>${board.biTitle }</td>
						<td>${board.uiNum }</td>
						<td>${board.credat }</td>
						<td>${board.biContent }</td>
						<td>${board.lmodat }</td>
					</tr>
				
				<tr>
					<td colspan="6" align="right" onclick="goPage('/board-info/update')"><button
							type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<td colspan="6" align="right" onclick="goPage('/board-info/delete')"><button
							type="button" class="btn btn-primary">삭제</button></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>