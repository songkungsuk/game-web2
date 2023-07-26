<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user-info/update" method="post">
<input type="hidden" name="UI_NUM" value="${user.UI_NUM}">
이름<input type="text" name="UI_NAME" value="${user.UI_NAME}"><br>
아이디<input type="text" name="UI_ID" value="${user.UI_ID}"><br>
비밀번호<input type="text" name="UI_PWD" value="${user.UI_PWD}"><br>
경로<input type="text" name="UI_IMG_PATH" value="${user.UI_IMG_PATH}"><br>
설명<input type="text" name="UI_DESC" value="${user.UI_DESC}"><br>
생년월일<input type="text" name="UI_BIRTH" value="${user.UI_BIRTH}"><br>
<button>수정</button>
<button type="button" onclick="location.href='/user-info/view?uiNum=${user.UI_NUM}'">뒤로가기</button>
</form>
</body>
</html>