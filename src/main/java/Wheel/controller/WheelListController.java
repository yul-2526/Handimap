package Wheel.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Wheel.model.WheelDao;

//by 아영, 전동 휠체어 충전소 list, 20220506
@Controller
public class WheelListController {
	
	private final String command = "/main.wh";
	private String getPage = "wheelList";
	
	@RequestMapping(command)
	public String doAction() {
		System.out.println(1);
		WheelDao wheelDao = new WheelDao();
		try {
			wheelDao.getList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getPage;
	}

}
