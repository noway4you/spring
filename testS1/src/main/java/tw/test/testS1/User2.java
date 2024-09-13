package tw.test.testS1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User2 {
	
	private Bike bike;
	
	public void rideBike() {
		bike.upSpeed();
	}
	
}
