<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../member/top.jsp"%>
날씨예보 메인
<table>
<c:forEach items="${datalist }" varStatus="status" var="jujang">
	<tr>
		<td>${jujang.baseDate }</td>
		<td>${jujang.baseTime }</td>
		<td>${jujang.pop }</td>
		<td>${jujang.reh }</td>
		<td>${jujang.sky }</td>
		<td>${jujang.tmp }</td>
		<td>${jujang.wsd }</td>
	</tr>
</c:forEach>
</table>

<%@ include file="../member/bottom.jsp"%>