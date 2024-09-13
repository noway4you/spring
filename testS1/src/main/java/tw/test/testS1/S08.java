package tw.test.testS1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class S08 {
	
	@RequestMapping("/S08_1")
	public String S08_1(@RequestParam(name="xxx") Integer x,@RequestParam(name="yyy",required = false,defaultValue = "0") Integer y,@RequestParam String name) {
		return name + ": x + y = " + (x + y);
	}
	
	@RequestMapping("/S08_2")
	public String S08_2(@RequestBody User user) {
		return "id = " + user.getId() + "\nname = " + user.getName();
	}
	
	@RequestMapping("/S08_3")
	public String S08_3(@RequestHeader String x , @RequestBody User user) {
		return x + ": id = " + user.getId() + "\tname = " + user.getName();
	}
	
	@RequestMapping("/S08_4/user/{uid}")
	public String S08_4(@PathVariable Integer uid) {
		return uid.toString();
	}
	
	@RequestMapping("/S08_5/user")
	public String S08_5(@PathParam("x") Integer x,@PathParam("y") Integer y) {
		return "x + y = " + (x+y);
	}
}
