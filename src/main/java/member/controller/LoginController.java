package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//by �ƿ�, �α��� ������ �̵�
@Controller
public class LoginController {

	private final String command="login.tt";
	private String getPage="Login";

	@RequestMapping(value=command)
	public String doAction() {

		return getPage;
	}
}


