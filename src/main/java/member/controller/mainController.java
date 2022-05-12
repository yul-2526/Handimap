package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//by 아영, 메인 페이지 이동, 20220505
@Controller
public class mainController {

	private final String command="main.tt";
	private String getPage="main";
	
	@RequestMapping(value=command)
	public String doAction() {
		
		return getPage;
	}
}
