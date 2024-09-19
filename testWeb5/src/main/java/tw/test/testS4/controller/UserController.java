package tw.test.testS4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.test.testS4.Model.ResponseUser;
import tw.test.testS4.Model.User;
import tw.test.testS4.Repository.UserRepository;
import tw.test.testS4.Service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/isexist/{account}")
	public ResponseUser isExist(@PathVariable String account) {
		return userService.isExistUser(account);
	}
	
	@PostMapping("/register")
	public ResponseUser reg(@RequestBody User user) {
		return userService.regUser(user);
	}
	
	@PostMapping("/login")
	public ResponseUser login(@RequestBody User user) {
		return userService.loginUser(user);
	}
	
	@PutMapping("/update")
	public User update(@RequestBody User user) {
		User userDB = userService.updateUser(user);
		return userDB;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		userService.deleteUser(id);
		return "delete";
	}
	
	@GetMapping("/getAccount/{key}")
	public List<User> getAccountByKey(@PathVariable String key) {
		return userRepository.findByAccountContaining(key);
	}
	
	@GetMapping("/get/{key}")
	public List<User> getAccountOrNameByKey(@PathVariable String key) {
		return userRepository.findByAccountOrNameLike(key,key);
	}
	
	
}
