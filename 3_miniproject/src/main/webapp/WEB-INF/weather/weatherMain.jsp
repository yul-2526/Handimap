<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
//현재날짜
		DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		Date nowDate = new Date();
		String tempDate = sdFormat.format(nowDate);

		//현재시간기준 basetime
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
		LocalTime timeset=LocalTime.now();
		String nowTime=timeset.format(formatter);
		
		String now_baseTime="";
		if(nowTime.equals("00")||nowTime.equals("01")||nowTime.equals("02")) {
			now_baseTime="2300";
			Calendar day = Calendar.getInstance();
			day.add(Calendar.DATE , -1);
			String beforeDate = new java.text.SimpleDateFormat("yyyyMMdd").format(day.getTime());

			tempDate=beforeDate;
		}if(nowTime.equals("05")||nowTime.equals("03")||nowTime.equals("04")) {
			now_baseTime="0200";
			
		}if(nowTime.equals("08")||nowTime.equals("06")||nowTime.equals("07")) {
			now_baseTime="0500";
			
		}if(nowTime.equals("11")||nowTime.equals("09")||nowTime.equals("10")) {
			now_baseTime="0800";
			
		}if(nowTime.equals("14")||nowTime.equals("12")||nowTime.equals("13")) {
			now_baseTime="1100";
			
		}if(nowTime.equals("17")||nowTime.equals("15")||nowTime.equals("16")) {
			now_baseTime="1400";
			
		}if(nowTime.equals("20")||nowTime.equals("18")||nowTime.equals("19")) {
			now_baseTime="1700";
			
		}if(nowTime.equals("21")||nowTime.equals("22")||nowTime.equals("23")) {
			now_baseTime="2000";
			
		}
		String baseDate = tempDate; 
%>
<%@ include file="../member/top.jsp"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>클릭 이벤트 등록하기</title>
    
</head>
<body>
<div id="map" style="width:500px;height:400px;"></div>
<p><em>지도를 클릭해주세요!</em></p> 
<p id="result"></p>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7426c5924815071d4e836ca8f4031ab3&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var nx_1='';
var ny_1='';

//alert('nx_click:'+nx_click+'ny_click:'+ny_click	);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng;
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('result'); 
    resultDiv.innerHTML = message;
    
    var x=(latlng.getLat()).toString();
    var y=(latlng.getLng()).toString();
    
    alert('x:'+x+'y:'+y); 
    
    const nx_click=x.slice(0,2);
    const ny_click=y.slice(0,3);

     	alert('nx_click:'+nx_click+'ny_click:'+ny_click);   

     	//날씨api
        var xhr = new XMLHttpRequest();
        var url = 'http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst'; /*URL*/
        var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'MbjQqZXxEGtJU04AVdLxb/S5iNdgPqNryD66KP2SDMJGJsfl9f3lPb0x9xgqSlc5Mf/TDxdzfrRjacwCzrR2zA=='; /*Service Key*/
        queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
        queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('1000'); /**/
        queryParams += '&' + encodeURIComponent('dataType') + '=' + encodeURIComponent('JSON'); /**/
        queryParams += '&' + encodeURIComponent('base_date') + '=' + encodeURIComponent('<%=baseDate%>'); /**/
        queryParams += '&' + encodeURIComponent('base_time') + '=' + encodeURIComponent('<%=now_baseTime%>'); /**/
        queryParams += '&' + encodeURIComponent('nx') + '=' + encodeURIComponent(nx_click); /**/
        queryParams += '&' + encodeURIComponent('ny') + '=' + encodeURIComponent(ny_click); /**/
        xhr.open('GET', url + queryParams);
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                alert('Status: '+this.status+'Headers: '+JSON.stringify(this.getAllResponseHeaders())+'Body: '+this.responseText);
            }
        };

        xhr.send(''); 

});


</script>


</body>
</html>
<%@ include file="../member/bottom.jsp"%>