<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/main" method="post">
		<label for="id">ID</label>
		<input type="text" name="id" id="id" size="10" /> <br />
		<label for="pw">PW</label>
		<input type="password" name="pw" id="pw" size="10" /> <br />
		<br /> <input type="submit" value="로그인" />
	</form>
</body>
</html>