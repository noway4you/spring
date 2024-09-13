package tw.test.testS1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConf1 {
	
	@Bean("gBike")
	public Bike getGBike() {
		GBike gbike = new GBike();
		gbike.setGear(4);
		gbike.setSpeed(12.0);
		
		System.out.println("getGBike:" + gbike.getGear() + ",speed = " + gbike.getSpeed());

		return gbike;
	}
	
	@Bean("mBike")
	public Bike getMBike() {
		System.out.println("getMBike!");
		return new MBike();
	}

}