package wheel.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import wheel.model.WheelDao;

//by 아영, 전동 휠체어 충전소 list, 20220506
@Controller
public class WheelListController {
	
	private final String command = "/main.wh";
	private String getPage = "wheelList";
	@Autowired
	WheelDao wdao;
	
	@RequestMapping(command)
	public String doAction() {
		System.out.println(1);
		
		try {
			System.out.println(wdao.getList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getPage;
	}

}
