package Wheel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//by �ƿ�, ���� ��ü�� ������ list, 20220506
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
