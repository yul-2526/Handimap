package subway.controll;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import subway.model.SubwayBean;
import subway.model.SubwayDao;
import utility.Filing;


@Controller
public class SubwayJujangController {
	private final String command="jujang.sb";
	private final String goPage ="jujang";
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	SubwayDao subwayDao;
	
	@RequestMapping(value=command)
	public String doAction(HttpServletRequest request) {
		
		Filing filing = new Filing();
		ArrayList<SubwayBean> subwayList = filing.excelSubwayRead(request);
		
		for(int i = 0;i<subwayList.size();i++) {
			subwayDao.insertSubway(subwayList.get(i));
		}
		List<SubwayBean> sList = subwayDao.selectSubway();
		
		System.out.println("sList"+sList.size());
		request.setAttribute("subwayList", sList);
		return goPage;
	}
}
