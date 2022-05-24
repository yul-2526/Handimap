package weather.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import weather.model.weatherBean;
import weather.model.weatherDao;

@Controller
public class weatherMain {

	private final String command="main.wt";
	private String getPage="weatherMain";
	
	@Autowired
	private weatherDao wdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(HttpServletRequest request) {
		System.out.println("weatherMain 도착");
		ModelAndView mav=new ModelAndView();
		//데이터베이스에서 step1,2,3 가져와서 셀렉트한 값을 보내야함. 그걸로 셀렉트박스 내용 채우기

		List<weatherBean> step1=wdao.selectStep1();
		
		for(int i=0;i<step1.size();i++) {
			List<weatherBean> step2=wdao.selectStep2(step1.get(i).toString());
			mav.addObject("step2",step2);
		}
//		for(int i=0;i<step1.size();i++) {
//		System.out.println("step1:"+step1.get(i));
//		}
//		for(int i=0;i<step2.size();i++) {
//		System.out.println("step2:"+step2.get(i));
//		}
//		for(int i=0;i<step3.size();i++) {
//		System.out.println("step3:"+step3.get(i));
//		}
		
		mav.addObject("step1",step1);
		mav.setViewName(getPage);
		
		System.out.println("weatherMain 끝");
		return mav;
	}
}
