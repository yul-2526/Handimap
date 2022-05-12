package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {

	private final String command="main.tt";
	private String getPage="main";
	
	@RequestMapping(value=command)
	public String doAction() {
		
		return getPage;
	}
}
