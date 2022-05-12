package subway.controll;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import subway.model.SubwayApi;
import subway.model.SubwayLiftBean;
import subway.model.SubwayWheelApi;
import subway.model.SubwayWheelBean;


@Controller
public class SubwayWheelJungboController {
	private final String command="subwayWheelJungbo.sb";
	private final String goPage ="subwayWheelJungbo";
	
	@RequestMapping(value=command)
	public String doAction(HttpServletRequest request) {
		
		SubwayWheelApi subwayApi = new SubwayWheelApi();
		ArrayList<SubwayWheelBean> subwayLiftList = subwayApi.getApi();
		request.setAttribute("subwayLiftList", subwayLiftList);
		
		return goPage;
	}
}
