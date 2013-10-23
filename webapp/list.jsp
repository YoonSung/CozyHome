<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Photo</title>
<link type="text/css" rel="stylesheet" href="/stylesheets/reset.css" />
<link type="text/css" rel="stylesheet" href="/stylesheets/cozyhome.css" />

<script src="http://www.google.com/jsapi"></script>
<script>
 google.load( "webfont", "1" );
 google.setOnLoadCallback(function() {
  WebFont.load({ custom: {
   families: [ "NanumGothic" ],
   urls: [ "http://fontface.kr/NanumGothic/css" ]
  }});
 });
</script>

</head>
<body>
	<div id="fixedTop">
	<div id="formWrapper">
			<div id="formArea">
				<form action="/board" method="post" enctype="multipart/form-data">
					<div id="inputArea">
						<input type="text" name="title" id="title" placeholder="제목" /> <br />
						<textarea name="contents" rows="4" cols="30" placeholder="내용"></textarea>
					</div>
					<br /> <input type="file" name="file" id="file"> <br /> <input
						type="reset" value="지웁니다"> <br />
					<div id="submitArea">
						<input type="submit" value="SUBMIT" />
						<div id="divTransition2"></div>
					</div>
				</form>
			</div>
		</div>
	
	</div>
	<div id="wrap">
		<div id="bgImg"></div>
		<c:forEach var="data" items="${boardAllData}">
			<div id="upload">
				<div id="showSetting">
					<button onclick="location.href='/board/modify/${data.id}'">글수정</button>
					<button onclick="location.href='/board/delete/${data.id}'">글삭제</button>
				</div>

				<div id="showTitle">
					<h2>${data.title}</h2>
				</div>
				
				<c:if test="${not empty data.fileName }">
					<img src="/images/${data.fileName}" />
				</c:if>

				<div id="showContents">${data.contents}</div>
				<br /> <br />

				<c:if test="${not empty data.comments}">
					<c:forEach var="data2" items="${data.comments}">
						<div id="showComment">
							${data2.comment}
							<button
								onclick="location.href='/board/comment/modify/${data2.id}'">수정</button>
							<button
								onclick="location.href='/board/comment/delete/${data2.id}'">삭제</button>
						</div>
						<br />
					</c:forEach>
				</c:if>

				<label for="comment">의견더하기</label><br />
				<form action="/board/comment/${data.id}" method="post">
					<textarea name="comment" id="comment"></textarea>
					<input type="submit" value="댓글입력" />
				</form>

			</div>
			<br />
		</c:forEach>
	</div>
</body>
</html>