<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="/stylesheets/reset.css" />
<link type="text/css" rel="stylesheet" href="/stylesheets/index.css" />
<title>CozyHome</title>
</head>
<body>
	<div class="bgImg"></div>
	<div class="interactBox">
		<h1 class="title">
			<strong>Welcome.</strong> Please login.
		</h1>
		<p>
			<span>Cozy Home</span> is waiting for you.
		</p>

		<div class="choiceBlock">
			<a href="#" class="choice_login">login</a>
			<span>OR</span>
			<a href="#" class="choice_join">register</a>
		</div>

		<div class="inputArea">
			<form action="/board/list" method="post">
				<p>
					<input type="text" name="id" id="id" size="10" placeholder="Email" />
				</p>
				<p>
					<input type="password" name="pw" id="pw" size="10"
						placeholder="Password" />
				</p>
				<p>
					<input type="submit" value="login" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>