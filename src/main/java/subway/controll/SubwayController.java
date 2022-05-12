package subway.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SubwayController {
	private final String command="main.sb";
	private final String goPage ="main";
	
	@RequestMapping(value=command)
	public String doAction() {
		
		return goPage;
	}
}
