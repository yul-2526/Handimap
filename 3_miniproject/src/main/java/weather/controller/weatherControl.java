package weather.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import weather.model.weatherBean;
import weather.model.weatherDao;
import weather.model.weatherData;

@Controller
public class weatherControl {
	private final String command = "main.wt";
	private String getPage = "weatherMain";

	@Autowired
	private weatherDao wDao;

	@RequestMapping(value=command)
	public String doAction(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) throws IOException, ParseException {

			weatherData weatherData = new weatherData();
			ArrayList<weatherBean> weatherTestInfoArr = new ArrayList<weatherBean>();
			int count = 0;
			for(int j=10;j<101;j=j+10) { 
				weatherTestInfoArr = weatherData.getVillageWeather();
				System.out.println("j"+j);
				
				for(int i=0;i<weatherTestInfoArr.size();i++) {
					weatherBean weatherBean = weatherTestInfoArr.get(i);
					int cnt = wDao.insertWeather(weatherBean);
					if(cnt>0) {
						System.out.println("gga");
						count++;
					}
				}
			}
		
		String url = request.getContextPath()+command;
	
		List<weatherBean> bohumJujangInfoArr = new ArrayList<weatherBean>();

		bohumJujangInfoArr = wDao.selectTodayWeather();
	
		request.setAttribute("bohumJujangInfoArr",bohumJujangInfoArr);
		return getPage;
	}
}
