package tw.test.testS1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/S07_1")
@RestController
public class S07 {
	
	@RequestMapping("/S07")
	public String S07() {
		return "S07";
	}
	
}
