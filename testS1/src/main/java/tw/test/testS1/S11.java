package tw.test.testS1;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S11 {
	
	@RequestMapping("/S11_1")
	public ResponseEntity<String> S11_1() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("ok");
	}
	
	@RequestMapping("/S11_2")
	public ResponseEntity<User> S11_2() {
		User user = new User();
		user.setId(12L);
		user.setName("AAA");
		user.setTwid("a987654321");
		user.setEmail("123@321");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}
	
	@RequestMapping("/S11_3")
	public String S11_3() {
		throw new RuntimeException();
	}
	
	@RequestMapping("/S11_4")
	public String S11_4() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
	
	@RequestMapping("/S11_5")
	public String S11_5() throws IOException {
		throw new IOException();
	}
	
}
