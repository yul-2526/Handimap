package Wheel.model;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

//by 아영, 전동 휠체어 충전소, 20220506
public class WheelDao {
	/*
	 * http://api.data.go.kr/openapi/tn_pubr_public_electr_whlchairhgh_spdchrgr_api
	 * ?serviceKey=vpC1HzmjzfY5KKNIZaNfFNP7VLZaGPLhYSlHI%2BacovhkCn%2BqbE6qKwU%2BYX2GBM6V7pM6%2BU7MzUU7NLL%2F11Q7Tw%3D%3D
	 * &pageNo=1
	 * &numOfRows=100
	 * &type=json
	 * */
	public String getList() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_electr_whlchairhgh_spdchrgr_api"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=vpC1HzmjzfY5KKNIZaNfFNP7VLZaGPLhYSlHI%2BacovhkCn%2BqbE6qKwU%2BYX2GBM6V7pM6%2BU7MzUU7NLL%2F11Q7Tw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*XML/JSON 여부*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        //getResponseCode가 200이상 300이하일때는 정상적으로 작동합니다.

        BufferedReader rd;
        InputStreamReader in = new InputStreamReader((InputStream) conn.getContent(), "UTF-8");
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
