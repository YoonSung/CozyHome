<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Photo</title>
<link type="text/css" rel="stylesheet" href="/images/cozyhome.css"/>
</head>
<body>
<c:forEach var="data" items="${boardAllData}">
	<div id="upload">
		<h2>제목 : ${data.title}</h2>
		내용 : ${data.contents}<br/>
		이미지 : ${data.fileName}<br/>
		<img width="400px" src="/images/${data.fileName}"/>
		<form action="/board/modify" method="post">
		<input type="submit" value="수정"/>
		<form action="/board/delete" method="post">
		<input type="submit" value="삭제"/>
		</form>
	</div>
	<br/>
</c:forEach>
</body>
</html>