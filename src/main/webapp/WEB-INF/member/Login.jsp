<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, 그리고 Bootstrap 기여자들">
<meta name="generator" content="Hugo 0.88.1">
<meta name="appleid-signin-client-id" content="[CLIENT_ID]">
<meta name="appleid-signin-scope" content="[SCOPES]">
<meta name="appleid-signin-redirect-uri" content="[REDIRECT_URI]">
<meta name="appleid-signin-state" content="[STATE]">
<title>HandiMap 로그인 페이지</title>

<style>
.form-signin {
	margin-left : 42%;
	width : 250px;
}

.form-floating{
	padding-bottom: 10px;
}

.signin-button {
     width: 210px;
     height: 40px;
     margin-left : 8%;    
}

</style>

<script type="text/javascript" src="https://appleid.cdn-apple.com/appleauth/static/jsapi/appleid/1/en_US/appleid.auth.js"></script>
<link href="signin.css" rel="stylesheet">
</head>

<%@ include file="top.jsp"%>
<br><br>
<body class="text-center">

<main class="form-signin"> 

	<img src="<%=request.getContextPath() %>/resources/로고4.png" width="250px" height="150px">
	<br><br><br>
	
		<form method="post" action="login.tt">
			<div class="form-floating">
				<input type="text" class="form-control" id="id" name="id" placeholder="ID">
					<label for="floatingInput">ID</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="pw" name="pw" placeholder="Password">
					<label for="floatingPassword">Password</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					아이디 기억하기
				</label>
			</div>
			<button class="w-100 btn btn-lg" type="submit" style="background-color: #41AF45; color: #FFFFFF;">Login
			</button>
		</form>
		<br>
		<form method="post" action="kakaoLogin.tt">
		  	<a id="custom-login-btn">
				<img src="https://www.gb.go.kr/Main/Images/ko/member/certi_kakao_login.png" width="210" height="40" alt="카카오 로그인 버튼" style="margin-bottom: 5px;"/>
			</a>
		</form> 
		
		<form action="apple.tt">
			<div id="appleid-signin" class="signin-button" data-color="black" data-border="true" data-type="sign-in" alt="애플 로그인 버튼"></div>
		</form>
		
	</main>

	<br>
	<br>
	<br>
	<%@ include file="bottom.jsp"%>