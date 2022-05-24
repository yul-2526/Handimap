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
	private final String command = "getWeather.wt";
	private String getPage = "weatherMain";

	@Autowired
	private weatherDao wDao;


	@RequestMapping(value=command)
	public String doAction(@RequestParam(value="addressRegion", required=false) String step1,
							@RequestParam(value="addressDo", required=false) String step2) 
							throws IOException, ParseException {

			weatherData weatherData = new weatherData();
			ArrayList<weatherBean> weatherTestInfoArr = new ArrayList<weatherBean>();
			int count = 0;
			for(int j=10;j<101;j=j+10) { 
				weatherTestInfoArr = weatherData.getVillageWeather(step1, step2);
				System.out.println("j"+j);
				
				for(int i=0;i<weatherTestInfoArr.size();i++) {
					weatherBean weatherBean = weatherTestInfoArr.get(i);

				}
			}

		return getPage;
	}
}