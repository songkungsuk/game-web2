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
insert
<div class="container">
<form action="/board-info/insert" method="post">
<div class="form-group">
    <label for="biTitle">제목</label>
    <input type="text" class="form-control" id="biTitle" name="biTitle" placeholder="제목">
  </div>
  <div class="form-group">
    <label for="biContent">내용</label>
    <textarea rows="25" class="form-control" id="biContent" name="biContent" placeholder="내용"></textarea>
  </div>
  <button type="submit" class="btn btn-primary">등록</button>
</form>
</div>
</body>
</html>