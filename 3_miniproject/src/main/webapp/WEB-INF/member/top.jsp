<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp" %>
    
<!--by 아영, 메인페이지 top입니다. 20220504 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style type="text/css">
	.btt{
		background-color: #41AF45;
		color: #FFFFFF; 
		border-radius: 50px;
	}
	
</style>   
</head> 
<body> 
  <div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
        <img src="<%=request.getContextPath() %>/resources/로고4.png" width="150px" height="80px">
      </a>

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="main.tt" class="nav-link px-2 link-dark">Home&nbsp;&nbsp;</a></li> 
        <li><a href="main.wt" class="nav-link px-2 link-dark">&nbsp;&nbsp;날씨&nbsp;&nbsp;</a></li>
        <li><a href="main.wh" class="nav-link px-2 link-dark">&nbsp;&nbsp;휠체어&nbsp;&nbsp;</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">&nbsp;&nbsp;병원&nbsp;&nbsp;</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">&nbsp;&nbsp;지하철</a></li>
      </ul>

      <div class="col-md-3 text-end">
        <button type="button" class="btn me-2 btt">로그인</button>
        <button type="button" class="btn btt">회원가입</button>
      </div>
    </header>
  </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
