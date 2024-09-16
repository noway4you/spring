package tw.test.testS4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.test.bcrypt.BCrypt;
import tw.test.testS4.model.UserV2;
import tw.test.testS4.repository.UserRepository;
import tw.test.testS4.service.UserService;

@RestController
public class UserControllerV2 {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/userJPA/add")
	public String add(@RequestBody UserV2 user) {
		
		userRepository.save(user);
		
		return "add";
	}
	
	@PostMapping("/userJPA/add2")
	public UserV2 add2(@RequestBody UserV2 user) {
		return userService.addUser(user);
	}
	
	@DeleteMapping("/userJPA/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "ok";
	}
	
	@PutMapping("/userJPA/select/{id}")
	public String updateUser(@PathVariable Long id,@RequestBody UserV2 user) {
		
		user.setId(id);
		user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
		userRepository.save(user);
		
		return "select1";
	}
	
	@PutMapping("/userJPA/select2")
	public String updateUser(@RequestBody UserV2 user) {
		
		user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
		userRepository.save(user);
		
		return "select2";
	}
	
	@GetMapping("/userJPA/selectAll")
	public List<UserV2> query(){
		return (List<UserV2>)userRepository.findAll();
	}
}
