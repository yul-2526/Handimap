package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//by �ƿ�, ȸ������ ������ �̵�
@Controller
public class SignUpController {
	
	private final String command = "signup.tt";
	private String getPage = "SignUp";
	
	@RequestMapping(value=command)
	public String doAction() {
		
		return getPage;
	}
	

}
