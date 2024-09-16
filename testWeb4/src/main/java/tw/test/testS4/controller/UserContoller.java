package tw.test.testS4.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.test.bcrypt.BCrypt;
import tw.test.testS4.model.User;
import tw.test.testS4.service.UserService;

@RestController
public class UserContoller {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public void index2(@RequestParam String account,@RequestParam String password,@RequestParam String name) {
		String sql = "insert into user (account,password,name) values (?,?,?)";
		jdbcTemplate.update(sql,account,password,name);
	}
	
	@PostMapping("/user/updateIcon/{id}")
	public void updateIcon(@PathVariable Long id,MultipartFile icon) {
		String name = icon.getName();
		String type = icon.getContentType();
		long size = icon.getSize();
		
		String sql = "update user set icon = ? where id = ?";
		try {
			jdbcTemplate.update(sql,icon.getBytes(),id);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@PostMapping("/user/reg")
	public void userRegister(@RequestParam String account,@RequestParam String password,@RequestParam String name,MultipartFile icon) {
		String sql = "insert into user (account,password,name,icon) values (?,?,?,?)";
		try {
			jdbcTemplate.update(sql,account,BCrypt.hashpw(password,BCrypt.gensalt()),name,icon.getBytes());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {
		User user = userService.getUser(id);
		return user;
	}
}
