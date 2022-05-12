package subway.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Element;


public class SubwayWheelApi {
/*{"header":{"resultCnt":22,"resultCode":"00","resultMsg":"정상 처리되었습니다."},"body":[
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"1","mvPathDvNm":"출입구-승강장","mvTpOrdr":1,"mvDst":null,"mvContDtl":"1) 1번 출입구 근처 엘리베이터 이용"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"1","mvPathDvNm":"출입구-승강장","mvTpOrdr":2,"mvDst":null,"mvContDtl":"2) 개집표기 통과하여 1번 출입구 근처 엘리베이터 이용"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"1","mvPathDvNm":"출입구-승강장","mvTpOrdr":3,"mvDst":null,"mvContDtl":"3) 지하 2층 승강장으로 이동"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"1","mvPathDvNm":"출입구-승강장","mvTpOrdr":4,"mvDst":null,"mvContDtl":"4) 지하 2층으로 이동"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"1","mvPathDvNm":"출입구-승강장","mvTpOrdr":1,"mvDst":null,"mvContDtl":"1) 1번 출입구 근처 엘리베이터 이용"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"1","mvPathDvNm":"출입구-승강장","mvTpOrdr":2,"mvDst":null,"mvContDtl":"2) 지하 2층으로 이동"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"1","mvPathDvNm":"출입구-승강장","mvTpOrdr":3,"mvDst":null,"mvContDtl":"3) 개집표기 통과하여 4번 출입구 근처 엘리베이터 이용"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"1","mvPathDvNm":"출입구-승강장","mvTpOrdr":4,"mvDst":null,"mvContDtl":"4) 지하 2층 승강장으로 이동"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":1,"mvDst":null,"mvContDtl":"1) 연신내 방면 승강장에서 엘리베이터 탑승 후 지하1층 3호선 대합실 이동"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":2,"mvDst":null,"mvContDtl":"2) 개집표기 통과 후 1번출입구 옆 엘리베이터 탑승"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":3,"mvDst":null,"mvContDtl":"3) 지상으로 이동 후 8번출입구 옆 엘리베이터 탑승"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":4,"mvDst":null,"mvContDtl":"4) 지하1층으로 이동"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":5,"mvDst":null,"mvContDtl":"5) 좌측 개집표기 통과 후 엘리베이터 탑승"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":6,"mvDst":null,"mvContDtl":"6) 지하4층으로 이동"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":1,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":7,"mvDst":null,"mvContDtl":"7) 독바위 방면 승강장 이용"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":1,"mvDst":null,"mvContDtl":"1) 녹번 방면 승강장에서 엘리베이터 탑승 후 지하1층 3호선 대합실 이동"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":2,"mvDst":null,"mvContDtl":"2) 개집표기 통과 후 1번출입구 옆 엘리베이터 탑승"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":3,"mvDst":null,"mvContDtl":"3) 지상으로 이동 후 8번출입구 옆 엘리베이터 탑승"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":4,"mvDst":null,"mvContDtl":"4) 지하1층으로 이동"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":5,"mvDst":null,"mvContDtl":"5) 좌측 개집표기 통과 후 엘리베이터 탑승"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":6,"mvDst":null,"mvContDtl":"6) 지하4층으로 이동"},
 * {"railOprIsttCd":"S1","lnCd":"3","stinCd":"322","mvPathMgNo":2,"mvPathDvCd":"3","mvPathDvNm":"환승경로","mvTpOrdr":7,"mvDst":null,"mvContDtl":"7) 독바위 방면 승강장 이용"}]}
*/
	public ArrayList<SubwayWheelBean> getApi() {
		ArrayList<SubwayWheelBean> suList = new ArrayList<SubwayWheelBean>();
		try {
			StringBuilder urlBuilder = new StringBuilder("http://openapi.kric.go.kr/openapi/vulnerableUserInfo/stationWheelchairLiftMovement"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=$2a$10$o6QhwYA3.vnxjtZekJvGf.kaQKnjHADg3aHilTXVMwyMEnTq3mmuO");
			urlBuilder.append("&" + URLEncoder.encode("format","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占�(xml/json)*/
			urlBuilder.append("&" + URLEncoder.encode("railOprIsttCd","UTF-8") + "=" + URLEncoder.encode("S1", "UTF-8")); /*�뜝�룞�삕�뜝�룞�삕*/       
			urlBuilder.append("&" + URLEncoder.encode("lnCd","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*�뜝�룞�삕�뜝�룞�삕*/       
			urlBuilder.append("&" + URLEncoder.encode("stinCd","UTF-8") + "=" + URLEncoder.encode("322", "UTF-8")); /*�뜝�룞�삕�뜝�룞�삕*/       
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
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

			String myData = sb.toString();
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject)parser.parse(myData);

			JSONObject jsonObj = (JSONObject)obj;
			JSONArray jsonBody = (JSONArray)jsonObj.get("body");
			System.out.println("lnCd \t mvContDtl \t mvDst \t mvPathDvCd \t mvPathDvNm "
					+ "\t mvPathMgNo \t mvTpOrdr \t railOprIsttCd \t stinCd \t");
			for(int i=0;i<jsonBody.size();i++) {
				JSONObject item = (JSONObject)jsonBody.get(i);
				
				String lnCd = (String)item.get("lnCd");
				String mvContDtl = (String)item.get("mvContDtl");
				String mvDst = (String)item.get("mvDst");
				String mvPathDvCd = (String)item.get("mvPathDvCd");
				String mvPathDvNm = (String)item.get("mvPathDvNm");
				Long mvPathMgNo = (Long)item.get("mvPathMgNo");
				Long mvTpOrdr = (Long)item.get("mvTpOrdr");
				String railOprIsttCd = (String)item.get("railOprIsttCd");
				String stinCd = (String)item.get("stinCd");
				
				System.out.print(lnCd+"\t");
				System.out.print(mvContDtl+"\t");
				System.out.print(mvDst+"\t");
				System.out.print(mvPathDvCd+"\t");
				System.out.print(mvPathDvNm+"\t");
				System.out.print(mvPathMgNo+"\t");
				System.out.print(mvTpOrdr+"\t");
				System.out.print(railOprIsttCd+"\t");
				System.out.print(stinCd+"\t");
				
				SubwayWheelBean subwayWheelBean = new SubwayWheelBean(lnCd, mvContDtl, mvDst, mvPathDvCd, mvPathDvNm,
						mvPathMgNo, mvTpOrdr, railOprIsttCd, stinCd);
				suList.add(subwayWheelBean);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			return suList;
	}//getHohumDetail
}
