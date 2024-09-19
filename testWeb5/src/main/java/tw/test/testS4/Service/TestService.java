package tw.test.testS4.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tw.test.testS4.Model.Test;
import tw.test.testS4.Repository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;
	
	public Test uploadFile(MultipartFile file) throws IOException {
		String filename = file.getOriginalFilename();
		byte[] uploadData = file.getBytes(); 
		
		Test test = new Test("AAA",uploadData);
		
		return testRepository.save(test);
	}
	
}
