package tw.test.testS1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// IoC + DI
// IoC => First Method : Component => class name = bean name ,or can bean("input the name by yourself")
//     => Second Method: Configuration + Bean
// DI  => AutoWired
@RestController
public class S02 {
	
	@Autowired
	private MySetting mySetting;
	
	@RequestMapping("/S02")
	public String S02() {
		return String.format("<h1>%s</h1>",mySetting.getTitle());
	}
	
}
