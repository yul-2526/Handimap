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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

public class weatherData {

	public ArrayList<weatherBean> getVillageWeather() throws IOException, ParseException  {
		ArrayList<weatherBean> datalist = new ArrayList<weatherBean>();
		DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		Date nowDate = new Date();
		String tempDate = sdFormat.format(nowDate);

		// JSON�����͸� ��û�ϴ� URLstr�� ����ϴ�.
		String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";

		String baseDate = tempDate; // "20200821"�̷������� api���� �����ϴ� ���� �״�� �����ø� �˴ϴ�.


		// ���� 23�� ���� 153���� �����͸� ��ȸ�ϸ� ���ð� ������ ������ �� �� ����
		weatherBean wb = new weatherBean();
		StringBuilder urlBuilder = new StringBuilder(apiUrl);
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=MbjQqZXxEGtJU04AVdLxb/S5iNdgPqNryD66KP2SDMJGJsfl9f3lPb0x9xgqSlc5Mf/TDxdzfrRjacwCzrR2zA==");
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*�� ������ ��� ��*/
		urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*��û�ڷ�����(XML/JSON) Default: XML*/
		urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8")); //���� ��¥�� ȣ���� �� ��¥�� ������ �����͸� �ҷ���
		urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0200", "UTF-8")); /*06�� ��ǥ(���ô���) */
		urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*���������� X ��ǥ��*/
		urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*���������� Y ��ǥ��*/

		/* GET������� �����ؼ� �Ķ���� �޾ƿ���*/
		URL url = new URL(urlBuilder.toString());
		// ��� �Ѿ���� Ȯ���ϰ� ������ �Ʒ� ��º� �ּ� ����
		System.out.println(url);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
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
		System.out.println("���: " + result);
		// ���ڿ��� JSON���� �Ľ��մϴ�. ������ �迭���·� ����� �����ͱ��� �Ľ��س��ϴ�.
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
		JSONObject parse_response = (JSONObject) jsonObj.get("response");
		JSONObject parse_body = (JSONObject) parse_response.get("body");// response �� ���� body ã�ƿ���
		JSONObject parse_items = (JSONObject) parse_body.get("items");// body �� ���� items �޾ƿ���
		// items�� ���� itemlist �� �޾ƿ��� itemlist : �ڿ� [ �� �����ϹǷ� jsonarray�̴�.
		JSONArray parse_item = (JSONArray) parse_items.get("item");

		JSONObject obj;
		String category; // ���� ��¥�� ���ؽð��� VillageWeather ��ü�� �����մϴ�.

		String day = "";
		String time = "";


		for (int i = 0; i < parse_item.size(); i++) {
			obj = (JSONObject) parse_item.get(i); // �ش� item�� �����ɴϴ�.

			boolean flag = false;

			Object fcstValue = obj.get("fcstValue");
			Object fcstDate = obj.get("fcstDate");
			Object fcstTime = obj.get("fcstTime");
			category = (String) obj.get("category"); // item���� ī�װ��� �˻��ؿɴϴ�.
			System.out.println("\n\n\n"+"category : "+category);
			// �˻��� ī�װ��� ��ġ�ϴ� ������ ���������� �����͸� �����մϴ�.
			// �����͵��� ���°� �޶� ���ڿ��� �����ؾ� ���մϴ�. ������ ����Ҷ� �ٽú�ȯ�ϴ°� �����ϴ�.

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
					System.out.println("����: "+ day + "  " +"Ÿ��: "+ time);
				}		

				wb.setBaseDate((obj.get("fcstDate")).toString());
				wb.setBaseTime((obj.get("fcstTime")).toString());

				String baseDate1 = (String)obj.get("baseDate");
				String baseTime = (String)obj.get("baseTime");
				String pop = (String)obj.get("pop");
				String reh = (String)obj.get("reh");
				String sky = (String)obj.get("sky");
				String tmp = (String)obj.get("tmp");
				String wsd = (String)obj.get("wsd");

				weatherBean weatherlist=new weatherBean(0, null,  baseDate1,  baseTime, null, null, pop,
						reh,  sky,  tmp,  wsd);
				datalist.add(weatherlist);
			}

		}
		return datalist;
	}
}
