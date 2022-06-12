package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//by 아영, 회원가입 페이지 이동
@Controller
public class SignUpController {
	
	private final String command = "signup.tt";
	private String getPage = "SignUp";
	
	@RequestMapping(value=command)
	public String doAction() {
		
		return getPage;
	}
	

}
