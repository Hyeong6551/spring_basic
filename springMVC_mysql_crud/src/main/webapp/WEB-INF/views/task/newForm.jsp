<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/tasks/result" method="post">
이름 : <input type="text" name="name" />
<input type="submit" value="확인" />
</form>
</body>
</html>