package Wheel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//by 아영, 전동 휠체어 충전소 list, 20220506
@Controller
public class WheelListController {
	
	private final String command = "/main.wh";
	private String getPage = "wheelList";
	
	@RequestMapping(command)
	public String doAction() {
		System.out.println(1);
		return getPage;
	}

}
