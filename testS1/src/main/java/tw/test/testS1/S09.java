package tw.test.testS1;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Restful
 * POST   >> create
 * GET    >> read
 * PUT    >> update
 * DELETE >> delete
 */

@RestController
public class S09 {

	@GetMapping("/users")
	public String S09() {
		return "S09";
	}
	
	@GetMapping("/users/{id}")
	public String S09_2(@PathVariable Integer id) {
		return "S09_2";
	}
	
	@GetMapping("/users/{id}/bikes")
	public String S09_3(@PathVariable Integer id) {
		return "S09_3";
	}
	
	@GetMapping("/users/{id}/bikes/{bid}")
	public String S09_4(@PathVariable Integer id,@PathVariable Integer bid) {
		return "S09_4";
	}
	
	@PostMapping("/user")
	public String S09_5(@RequestBody User user) {
		return "S09_5";
	}
	
	@PutMapping("/user/{id}")
	public String S09_6(@PathVariable Integer id,@RequestBody User user) {
		return "S09_6";
	}
	
	@DeleteMapping("/user/{id}")
	public String S09_7(@PathVariable Integer id) {
		return "S09_7";
	}
	
}
