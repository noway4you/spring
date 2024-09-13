package tw.test.testS1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class TestS1Application{
	
	// IOC => prefer to use instance class to write
	public static void main(String[] args) {
		SpringApplication.run(TestS1Application.class, args);
	}

}
