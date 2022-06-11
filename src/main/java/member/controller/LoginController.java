package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//by 아영, 로그인 페이지 이동
@Controller
public class LoginController {

	private final String command="login.tt";
	private String getPage="Login";

	@RequestMapping(value=command)
	public String doAction() {

		return getPage;
	}
}


