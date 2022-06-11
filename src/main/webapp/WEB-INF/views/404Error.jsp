<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- by 아영, 에러페이지 지정, 20220507 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>페이지를 찾을 수 없습니다.</title>
</head>
<body> 
<br><br> 
<hr>
<input type="button" class="btn btn-outline-danger" onClick="javascript:history.back()" value="이전 페이지로" style="margin-left: 46%;">
<img src="<%=request.getContextPath() %>/resources/5203299.jpg" width="100%"><br>
<br>
<a href='https://kr.freepik.com/vectors/web'>Web 벡터는 storyset - kr.freepik.com가 제작함</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>