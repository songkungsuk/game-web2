<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/user-info/insert" method="post">
		<input type="text" name="UI_NAME" placeholder="이름"> <br>
		<input type="text" name="UI_ID" placeholder="아이디"> <br>
		 <input	type="text" name="UI_PWD" placeholder="비밀번호"> <br> 
		<input	type="text" name="UI_IMG_PATH" placeholder="경로"> <br> 
		<textarea name="UI_DESC" placeholder="소개"></textarea> <br>
		<input	type="date" name="UI_BIRTH" placeholder="생년월일"> <br>
		<button>등록</button>
		<button type="reset">취소</button>

	</form>
</body>
</html>