package tw.test.testS1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.test.testS1.model.User;
import tw.test.testS1.model.UserReturn;
import tw.test.testS1.service.UserService;

/* controller -> service -> dao -> database | model */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public UserReturn addUser(@RequestBody User user) {
		
		return userService.addUser(user);
		
	}
}
