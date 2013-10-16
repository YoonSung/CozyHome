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
		<button onclick="location.href='/board/modify/${data.id}'">수정</button>
		<button onclick="location.href='/board/delete/${data.id}'">삭제</button><br/><br/>
		
		<c:if test="${not empty data.comments}">
			<c:forEach var="data2" items="${data.comments}">
				<p>${data2.comment}</p>
			</c:forEach>	
		</c:if>
		
		<label for="comment">의견더하기</label><br/>
		<form action="/board/comment/${data.id}" method="post">
		<textarea name ="comment" id="comment" rows="10" cols="50"></textarea>
			<input type="submit" value="댓글입력"/>
		</form>
	</div>
	<br/>
</c:forEach>
</body>
</html>