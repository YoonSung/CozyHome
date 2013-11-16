<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Photo</title>
<link type="text/css" rel="stylesheet" href="/stylesheets/reset.css" />
<link type="text/css" rel="stylesheet" href="/stylesheets/list.css" />

<script src="http://www.google.com/jsapi"></script>
<script>
	google.load("webfont", "1");
	google.setOnLoadCallback(function() {
		WebFont.load({
			custom : {
				families : [ "NanumGothic" ],
				urls : [ "http://fontface.kr/NanumGothic/css" ]
			}
		});
	});
</script>

</head>
<body>
	<div id="fixedTop">
		<div class="formWrapper">
			<div class="formArea">
				<form action="/board" method="post" enctype="multipart/form-data">
					<div class="inputArea">
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
	<div class="wrap">
		<div class="bgImg"></div>
		<c:forEach var="data" items="${boardAllData}">
			<div class="upload">
				<div class="showSetting">
					<button onclick="location.href='/board/modify/${data.id}'">글수정</button>
					<button onclick="location.href='/board/delete/${data.id}'">글삭제</button>
				</div>

				<div id="showTitle">
					<h2>${data.title}</h2>
				</div>

				<c:if test="${not empty data.fileName }">
					<img src="/images/${data.fileName}" />
				</c:if>

				<div class="showContents">${data.contents}</div>
				<br /> <br />

				<c:if test="${not empty data.comments}">
					<div id="commentBox">
						<div class="commentTitle">
							<p class="commentNum">0</p>
							<p class="commentNum">개의 댓글</p>
							<a class="commentControl" href="#">댓글 보여줘</a>
						</div>
						<div class="commentBody">
							<c:forEach var="data2" items="${data.comments}">
								<div class="showComment">
									${data2.comment} 
									<input type="hidden" value="${data2.id}" /> 
									<input type="button" class="commentDelBtn" value="삭제" />
									<input type="button" class="commentModifyBtn" value="수정"/>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>

				<div class="commentWrite">
					<label for="comment">의견더하기</label><br />
					<form action="/board/comment/${data.id}" method="post">
						<textarea name="comment" class="comment"></textarea>
						<input type="hidden" value="${data.id}" /> <input type="submit"
							value="댓글입력" />
					</form>
				</div>
			</div>
			<br />
		</c:forEach>
	</div>
	<script src="/javascripts/list.js"></script>
</body>
</html>