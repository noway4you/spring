package tw.test.testS4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import tw.test.testS4.Model.MyTest;
import tw.test.testS4.Model.MyTestResponse;
import tw.test.testS4.Service.TestService;

@RequestMapping("/test")
@RestController
public class TestController {
	
	@Autowired
	private TestService testService;

	@GetMapping("/01")
	public MyTest test01() {
		
		MyTest myTest = new MyTest();
		myTest.setId(1L);
		myTest.setName("AAA");
		myTest.addFriend("AAA-1").addFriend("AAA-2").addFriend("AAA-3");
		
		return myTest;
	}
	
	@PostMapping("/02")
	public MyTest test02(@RequestBody MyTest data,HttpSession httpSession) {
		
		MyTest myTest = new MyTest();
		myTest.setId(data.getId());
		myTest.setName(data.getName());
		
		httpSession.setAttribute("myTest",myTest);
		
		return myTest;
	}
	
	@PostMapping("/03")
	public MyTestResponse test03(HttpSession httpSession) {
		
		MyTestResponse myTestResponse = new MyTestResponse();
		
		if(httpSession.getAttribute("myTest")!=null) {
			MyTest myTest = (MyTest)httpSession.getAttribute("myTest");
			myTestResponse.setCode(0);
			myTestResponse.setMessage("success");
			myTestResponse.setMyTest(myTest);
		}else {
			myTestResponse.setCode(-1);
			myTestResponse.setMessage("fail");
		}
		
		return myTestResponse;
	}
	
	@PostMapping("/04")
	public MyTestResponse test04(HttpSession httpSession) {
		
		httpSession.invalidate();
		MyTestResponse myTestResponse = new MyTestResponse();
		myTestResponse.setCode(-1);
		myTestResponse.setMessage("logout");
		
		return myTestResponse;
	}
	
	@PostMapping("/05")
	public ResponseEntity<String> test05(@RequestParam("uploadFile") MultipartFile uploadFile) {
		
		try {
			testService.uploadFile(uploadFile);
			return ResponseEntity.status(HttpStatus.OK).body("upload success");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upload failed");
		}	
	}
	
}
