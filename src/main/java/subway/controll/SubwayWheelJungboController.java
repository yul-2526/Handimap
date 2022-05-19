package subway.controll;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import subway.model.SubwayApi;
import subway.model.SubwayLiftBean;
import subway.model.SubwayWheelApi;
import subway.model.SubwayWheelBean;


@Controller
public class SubwayWheelJungboController {
	private final String command="subwayWheelJungbo.sb";
	private final String goPage ="subwayWheelJungbo";
	
	@RequestMapping(value=command)
	public String doAction(
			HttpServletRequest request,
			@RequestParam(value="lnCd",required=false)String lnCd,
			@RequestParam(value="stinCd",required=false)String stinCd) {
		
		SubwayWheelApi subwayApi = new SubwayWheelApi();
		ArrayList<SubwayWheelBean> subwayLiftList = subwayApi.getApi();
		//ArrayList<SubwayWheelBean> subwayLiftList = subwayApi.getApi(lnCd,stinCd);
		request.setAttribute("subwayLiftList", subwayLiftList);
		
		return goPage;
	}
}
