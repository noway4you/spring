package tw.test.testS1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

/* Do validation */
@RestController
public class S10 {
	
	@RequestMapping("/S10_1")
	public String S10_1(@RequestBody @Valid User user) {
		
		return "S10_1";
	}

	@RequestMapping("/S10_2/{id}")
	public String S10_2(@PathVariable @Min(10) @Max(11) Integer id) {
		return id.toString();
	}
	
	@RequestMapping("/S10_3")
	public String S10_3(@RequestBody @Valid User user) {
		return user.getName();
	}
	
	@RequestMapping("/S10_4")
	public String S10_4(@RequestBody @Valid User user) {
		return "user : " + user.getName() + "\nemail : " + user.getEmail();
	}
	
	@RequestMapping("/S10_5")
	public String S10_5(@RequestBody @Valid User user) {
		return "user : " + user.getName() + "\nTWID : " + user.getTwid();
	}
}
