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
			<a href="#" class="choice c_login">LOGIN</a>
			<a href="#" class="choice c_join">JOIN</a>
			<span class="devider">OR</span>
		</div>

		<div class="loginArea">
			<form action="/login" method="post">
				<p>
					<input type="text" name="id" id="id" size="10" placeholder="Email" />
				</p>
				<p>
					<input type="password" name="pw" id="pw" size="10"
						placeholder="Password" />
				</p>
				<p>
					<input type="submit" value="Enter House" />
				</p>
			</form>
		</div>
		
		<div class="joinArea">
			<form action="/join" method="post">
				<p>
					<input type="text" name="rid" id="rid" size="10" placeholder="Email" />
				</p>
				<p>
					<input type="text" name="nickname" size="10" placeholder="Nickname" />
				</p>
				<p>
					<input type="password" name="rpw" size="10"
						placeholder="Password" />
				</p>
				<p>
					<input type="password" name="rpwRe" id="rpwRe" size="10"
						placeholder="Password Confirm" />
				</p>
				<p>
					<input type="submit" value="Create own Home" />
				</p>
			</form>
		</div>
		
	</div>
	<script src="/javascripts/index.js"></script>
</body>
</html>