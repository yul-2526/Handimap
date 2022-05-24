package weather.model;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


public class weatherData {
	
	@Autowired
	private weatherDao wdao;
	
	public ArrayList<weatherBean> getVillageWeather(String step1, String step2) throws IOException, ParseException  {
		ArrayList<weatherBean> datalist = new ArrayList<weatherBean>();
		HttpHeaders resHeaders = new HttpHeaders(); 
		//resHeaders.add("Content-Type", "application/json;charset=UTF-8");
		
		System.out.println("step1:"+step1);
		System.out.println("step2:"+step2);
		
		//선택한 지역의 x,y좌표 셀렉트
		String cx=wdao.getNx(step1,step2);
		String cy=wdao.getNy(step1,step2);
		
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
		
		System.out.println("now_baseTime:"+now_baseTime);
		// JSON데이터를 요청하는 URLstr을 만듭니다.
		String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";

		String baseDate = tempDate; // "20200821"이런식으로 api에서 제공하는 형식 그대로 적으시면 됩니당.


		// 전날 23시 부터 153개의 데이터를 조회하면 오늘과 내일의 날씨를 알 수 있음
		weatherBean wb = new weatherBean();
		StringBuilder urlBuilder = new StringBuilder(apiUrl);
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=MbjQqZXxEGtJU04AVdLxb/S5iNdgPqNryD66KP2SDMJGJsfl9f3lPb0x9xgqSlc5Mf/TDxdzfrRjacwCzrR2zA==");
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8")); //현재 날짜를 호출해 그 날짜에 보도딘 데이터를 불러옴
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(now_baseTime, "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(cx, "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(cy, "UTF-8")); /*예보지점의 Y 좌표값*/
	
		 /* GET방식으로 전송해서 파라미터 받아오기*/
		URL url = new URL(urlBuilder.toString());
		// 어떻게 넘어가는지 확인하고 싶으면 아래 출력분 주석 해제
		System.out.println(url);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		//conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		String result = sb.toString();
		
		System.out.println("결과:"+result);
		
		// 문자열을 JSON으로 파싱합니다. 마지막 배열형태로 저장된 데이터까지 파싱해냅니다.
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
		JSONObject parse_response = (JSONObject) jsonObj.get("response");
		JSONObject parse_body = (JSONObject) parse_response.get("body");// response 로 부터 body 찾아오기
		JSONObject parse_items = (JSONObject) parse_body.get("items");// body 로 부터 items 받아오기
		// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다.
		JSONArray parse_item = (JSONArray) parse_items.get("item");
																	
		JSONObject obj;
		String category; // 기준 날짜와 기준시간을 VillageWeather 객체에 저장합니다.
		
		String day = "";
		String time = "";
		

		
		for (int i = 0; i < parse_item.size(); i++) {
			obj = (JSONObject) parse_item.get(i); // 해당 item을 가져옵니다.
			boolean flag = false;
			Object fcstValue = obj.get("fcstValue");
			Object fcstDate = obj.get("fcstDate");
			Object fcstTime = obj.get("fcstTime");
			category = (String) obj.get("category"); // item에서 카테고리를 검색해옵니다.
			// 검색한 카테고리와 일치하는 변수에 문자형으로 데이터를 저장합니다.
			// 데이터들이 형태가 달라 문자열로 통일해야 편합니다. 꺼내서 사용할때 다시변환하는게 좋습니다.
//			System.out.println("카테고리:"+category);

			switch (category) {
			case "POP":
				flag = true;
				break;
			case "REH":
				flag = true;
				break;
			case "SKY":
				flag = true;
				break;
			case "TMP":
				flag = true;
				break;
			case "WSD":
				flag = true;
				break;
			default:
				break;
			}
			if(flag) {
				if (!day.equals(fcstDate.toString())) {
					day = fcstDate.toString();
				}
				if (!time.equals(fcstTime.toString())) {
					time = fcstTime.toString();
					//System.out.println("데이: "+ day + "  " +"타임: "+ time);
				}		

//				wb.setBaseDate((obj.get("fcstDate")).toString());
//				wb.setBaseTime((obj.get("fcstTime")).toString());

				String baseDate1 = (String)obj.get("baseDate");
				String baseTime = (String)obj.get("baseTime");
				String pop = (String)obj.get("pop");
				String reh = (String)obj.get("reh");
				String sky = (String)obj.get("sky");
				String tmp = (String)obj.get("tmp");
				String wsd = (String)obj.get("wsd");

				//datalist.add(weatherlist);
			}

		}
		return datalist;
	}
}
		