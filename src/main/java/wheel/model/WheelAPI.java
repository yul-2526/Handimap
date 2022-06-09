package wheel.model;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

//by �ƿ�, ���� ��ü�� ������ ��ġ �ҷ�����
public class WheelAPI {
	
	public String getList() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_electr_whlchairhgh_spdchrgr_api"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=vpC1HzmjzfY5KKNIZaNfFNP7VLZaGPLhYSlHI%2BacovhkCn%2BqbE6qKwU%2BYX2GBM6V7pM6%2BU7MzUU7NLL%2F11Q7Tw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*������ ��ȣ*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*�� ������ ��� ��*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*XML/JSON ����*/
//        urlBuilder.append("&" + URLEncoder.encode("fcltyNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�ü���*/
//        urlBuilder.append("&" + URLEncoder.encode("ctprvnNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�õ���*/
//        urlBuilder.append("&" + URLEncoder.encode("signguNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�ñ�����*/
//        urlBuilder.append("&" + URLEncoder.encode("signguCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�ñ����ڵ�*/
//        urlBuilder.append("&" + URLEncoder.encode("rdnmadr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���������θ��ּ�*/
//        urlBuilder.append("&" + URLEncoder.encode("lnmadr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�����������ּ�*/
//        urlBuilder.append("&" + URLEncoder.encode("latitude","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*����*/
//        urlBuilder.append("&" + URLEncoder.encode("longitude","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�浵*/
//        urlBuilder.append("&" + URLEncoder.encode("instlLcDesc","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*��ġ��Ҽ���*/
//        urlBuilder.append("&" + URLEncoder.encode("weekdayOperOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���Ͽ���۽ð�*/
//        urlBuilder.append("&" + URLEncoder.encode("weekdayOperColseHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���Ͽ����ð�*/
//        urlBuilder.append("&" + URLEncoder.encode("satOperOperOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*����Ͽ���۽ð�*/
//        urlBuilder.append("&" + URLEncoder.encode("satOperCloseHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*����Ͽ����ð�*/
//        urlBuilder.append("&" + URLEncoder.encode("holidayOperOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�����Ͽ���۽ð�*/
//        urlBuilder.append("&" + URLEncoder.encode("holidayCloseOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�����Ͽ����ð�*/
//        urlBuilder.append("&" + URLEncoder.encode("smtmUseCo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���û�밡�ɴ��*/
//        urlBuilder.append("&" + URLEncoder.encode("airInjectorYn","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�������԰��ɿ���*/
//        urlBuilder.append("&" + URLEncoder.encode("moblphonChrstnYn","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�޴���ȭ�������ɿ���*/
//        urlBuilder.append("&" + URLEncoder.encode("institutionNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���������*/
//        urlBuilder.append("&" + URLEncoder.encode("institutionPhoneNumber","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*���������ȭ��ȣ*/
//        urlBuilder.append("&" + URLEncoder.encode("referenceDate","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*�����ͱ�������*/
//        urlBuilder.append("&" + URLEncoder.encode("instt_code","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*��������ڵ�*/
//        urlBuilder.append("&" + URLEncoder.encode("instt_nm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*������������*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
      //getResponseCode�� 200�̻� 300�����϶��� ���������� �۵��մϴ�.
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
