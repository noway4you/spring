package tw.test.testS1;

import org.springframework.stereotype.Component;

@Component
public class Bike1 implements Bike{
	
	@Override
	public void upSpeed() {
		System.out.println("bike1:upSpeed");
	}

	@Override
	public void downSpeed() {
		System.out.println("bike1:downSpeed");
	}
	
}
