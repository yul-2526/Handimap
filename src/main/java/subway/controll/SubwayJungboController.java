package subway.controll;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import subway.model.SubwayApi;
import subway.model.SubwayLiftBean;


@Controller
public class SubwayJungboController {
	private final String command="subwayJungbo.sb";
	private final String goPage ="subwayJungbo";
	
	@RequestMapping(value=command)
	public String doAction(HttpServletRequest request) {
		
		SubwayApi subwayApi = new SubwayApi();
		ArrayList<SubwayLiftBean> subwayLiftList = subwayApi.getApi();
		request.setAttribute("subwayLiftList", subwayLiftList);
		
		return goPage;
	}
}
