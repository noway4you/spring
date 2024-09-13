package tw.test.testS1;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S05 {
	
	@RequestMapping("/S05")
	public Student S05() {
		Student s1 = new Student();
		s1.setName("AAA");
		s1.setAge(18);
		s1.setGender(false);
		List<GBike> bikes = s1.getBikes();
		GBike g1 = new GBike(); g1.setGear(4); g1.setSpeed(1.2);
		GBike g2 = new GBike(); g2.setGear(4); g2.setSpeed(1.2);
		GBike g3 = new GBike(); g3.setGear(4); g3.setSpeed(1.2);
		bikes.add(g1); bikes.add(g2); bikes.add(g3);
		return s1;
	}
	
}	