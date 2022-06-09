package wheel.model;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

//by 아영, 전동 휠체어 충전소 위치 불러오기
public class WheelAPI {
	
	public String getList() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_electr_whlchairhgh_spdchrgr_api"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=vpC1HzmjzfY5KKNIZaNfFNP7VLZaGPLhYSlHI%2BacovhkCn%2BqbE6qKwU%2BYX2GBM6V7pM6%2BU7MzUU7NLL%2F11Q7Tw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*XML/JSON 여부*/
//        urlBuilder.append("&" + URLEncoder.encode("fcltyNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시설명*/
//        urlBuilder.append("&" + URLEncoder.encode("ctprvnNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시도명*/
//        urlBuilder.append("&" + URLEncoder.encode("signguNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구명*/
//        urlBuilder.append("&" + URLEncoder.encode("signguCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구코드*/
//        urlBuilder.append("&" + URLEncoder.encode("rdnmadr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*소재지도로명주소*/
//        urlBuilder.append("&" + URLEncoder.encode("lnmadr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*소재지지번주소*/
//        urlBuilder.append("&" + URLEncoder.encode("latitude","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*위도*/
//        urlBuilder.append("&" + URLEncoder.encode("longitude","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*경도*/
//        urlBuilder.append("&" + URLEncoder.encode("instlLcDesc","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*설치장소설명*/
//        urlBuilder.append("&" + URLEncoder.encode("weekdayOperOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*평일운영시작시각*/
//        urlBuilder.append("&" + URLEncoder.encode("weekdayOperColseHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*평일운영종료시각*/
//        urlBuilder.append("&" + URLEncoder.encode("satOperOperOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*토요일운영시작시각*/
//        urlBuilder.append("&" + URLEncoder.encode("satOperCloseHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*토요일운영종료시각*/
//        urlBuilder.append("&" + URLEncoder.encode("holidayOperOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*공휴일운영시작시각*/
//        urlBuilder.append("&" + URLEncoder.encode("holidayCloseOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*공휴일운영종료시각*/
//        urlBuilder.append("&" + URLEncoder.encode("smtmUseCo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*동시사용가능대수*/
//        urlBuilder.append("&" + URLEncoder.encode("airInjectorYn","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*공기주입가능여부*/
//        urlBuilder.append("&" + URLEncoder.encode("moblphonChrstnYn","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*휴대전화충전가능여부*/
//        urlBuilder.append("&" + URLEncoder.encode("institutionNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관리기관명*/
//        urlBuilder.append("&" + URLEncoder.encode("institutionPhoneNumber","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관리기관전화번호*/
//        urlBuilder.append("&" + URLEncoder.encode("referenceDate","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*데이터기준일자*/
//        urlBuilder.append("&" + URLEncoder.encode("instt_code","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*제공기관코드*/
//        urlBuilder.append("&" + URLEncoder.encode("instt_nm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*제공기관기관명*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
      //getResponseCode가 200이상 300이하일때는 정상적으로 작동합니다.
        BufferedReader rd;
        InputStreamReader in = new InputStreamReader((InputStream)conn.getContent(), "UTF-8");
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(in);
        }  else {
         rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
      }
        
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
		return sb.toString();
    }
}
