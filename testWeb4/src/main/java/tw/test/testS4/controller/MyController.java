package tw.test.testS4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// not restapi type , so use controller
@Controller
public class MyController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/index2")
	public String index2() {
		return "index2";
	}
	
	@GetMapping("/user/reg")
	public String reg() {
		return "reg";
	}
}
