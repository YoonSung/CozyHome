<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Image Upload</title>
<link type="text/css" rel="stylesheet" href="/stylesheets/cozyhome.css"/>
</head>
<body>
	<form action="/board/list" method="post">
		<div id="upload">
			<h2>제목 : ${board.title}</h2>
			내용 : ${board.contents}<br/>
			이미지 : ${board.fileName}<br/>
			<img width="400px" src="/images/${board.fileName}"/>
		</div>
		<br/>
	<input type="submit" value="확인"/>
</form>
</body>
</html>