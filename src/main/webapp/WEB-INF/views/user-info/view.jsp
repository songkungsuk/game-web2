<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
user 상세화면
${user }<br>
${user.UI_NUM} <br>
${user.UI_NAME} <br>
${user.UI_ID} <br>
${user.UI_PWD} <br>
${user.UI_IMG_PATH} <br>
${user.UI_DESC} <br>
${user.UI_BIRTH} <br>
${user.CREDAT} <br>
${user.CRETIM} <br>
${user.LMODAT} <br>
${user.LMOTIM} <br>
<button onclick="location.href='/user-info/update?uiNum=${user.UI_NUM}'">수정</button>
<form action="/user-info/delete" method="post">
<input type="hidden" name="UI_NUM" value="${user.UI_NUM}">
<button>삭제</button>
</form>
</body>
</html>