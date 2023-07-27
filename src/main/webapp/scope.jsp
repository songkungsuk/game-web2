<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>SCOPE</h1>
<%
Map<String, String> map = new HashMap<>();
map.put("name", "홍길동");
map.put("age", "33");
map.put("address", "seoul");
//session.setAttribute("RQuser", map);
%>
${RQuser}
${RQuser.name}
${RQuser.age}
${RQuser.address}

</body>
</html>