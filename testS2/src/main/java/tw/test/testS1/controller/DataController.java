package tw.test.testS1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.test.testS1.model.Data;
import tw.test.testS1.model.User;
import tw.test.testS1.model.UserReturn;
import tw.test.testS1.service.DataService;
import tw.test.testS1.service.UserService;

@RestController
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@PostMapping("/addData")
	public Data addData(@RequestBody String url) {
		
		return dataService.addData(url);
		
	}
	
}
