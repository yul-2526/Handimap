package subway.model;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;


public class SubwayApi {

	public ArrayList<SubwayLiftBean> getApi() {
			//http://openapi.seoul.go.kr:8088/6c44434d796b696d37374c78516e55/xml/tbTraficEntrcLft/1/5/
			// 본인이 받은 api키를 추가
			String key = "";
			System.out.println("getApi");
			ArrayList<SubwayLiftBean> suList = new ArrayList<SubwayLiftBean>();
			try{
				// parsing할 url 지정(API 키 포함해서)
				String url = "http://openapi.seoul.go.kr:8088/6c44434d796b696d37374c78516e55/xml/tbTraficEntrcLft/1/5/";
		        
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// 제일 첫번째 태그
				doc.getDocumentElement().normalize();
				System.out.println();
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("row");

				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
				
					Element eElement = (Element) nNode;
					
					
					String tYPE = getTagValue("TYPE", eElement);
					String nODE_WKT = getTagValue("NODE_WKT", eElement);
					String nODE_ID = getTagValue("NODE_ID", eElement);
					String nODE_CODE = getTagValue("NODE_CODE", eElement);
					String sGG_CD = getTagValue("SGG_CD", eElement);
					String sGG_NM = getTagValue("SGG_NM", eElement);
					String eMD_CD = getTagValue("EMD_CD", eElement);
					String eMD_NM = getTagValue("EMD_NM", eElement);
					String sW_CD = getTagValue("SW_CD", eElement);
					String sW_NM = getTagValue("SW_NM", eElement);
					
					System.out.println("노드링크 유형  : " + tYPE);
					System.out.println("노드 WKT	(좌표) : " + nODE_WKT);
					System.out.println("노드 ID : " + nODE_ID);
					System.out.println("노드 유형 코드 : " + nODE_CODE);
					System.out.println("시군구코드 : " + sGG_CD);
					System.out.println("시군구명 : " + sGG_NM);
					System.out.println("읍면동코드 : " + eMD_CD);
					System.out.println("읍면동명 : " + eMD_NM);
					System.out.println("지하철역코드 : " + sW_CD);
					System.out.println("지하철역명 : " + sW_NM);
					
					SubwayLiftBean subwayLiftBean = new SubwayLiftBean(tYPE, nODE_WKT, nODE_ID, nODE_CODE,
							sGG_CD, sGG_NM, eMD_CD, eMD_NM, sW_CD, sW_NM);
					suList.add(subwayLiftBean);
				}
				
			} catch (Exception e){	
				e.printStackTrace();
			}	
			return suList;
	}//getHohumDetail
	

  	 // tag값의 정보를 가져오는 함수
	public static String getTagValue(String tag, Element eElement) {

           	//결과를 저장할 result 변수 선언
           	String result = "";

	    	NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

	    	result = nlList.item(0).getTextContent();

	    	return result;
	}

	// tag값의 정보를 가져오는 함수
	public static String getTagValue(String tag, String childTag, Element eElement) {

		//결과를 저장할 result 변수 선언
		String result = "";

		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

		for(int i = 0; i < eElement.getElementsByTagName(childTag).getLength(); i++) {

			//result += nlList.item(i).getFirstChild().getTextContent() + " ";
			result += nlList.item(i).getChildNodes().item(0).getTextContent() + " ";
		}

		return result;
	}
}
