<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
				ps.setString(1, userInfo.get("UI_NAME"));
				ps.setString(2, userInfo.get("UI_ID"));
				ps.setString(3, userInfo.get("UI_PWD"));
				ps.setString(4, userInfo.get("UI_IMG_PATH"));
				ps.setString(5, userInfo.get("UI_DESC"));
				ps.setString(6, userInfo.get("UI_BIRTH"));
				
</body>
</html>