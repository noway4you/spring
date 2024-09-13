package tw.test.testS1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// start => 1.Component => bean , 2.Configuration => execute => return => bean , 3.none => ok
@RestController
public class S01 {
	
	@Autowired
	private Bike gBike;
	
	@Autowired
	private Bike mBike;
	
	@RequestMapping("/S01")
	public String myWeb() {
		gBike.upSpeed();
		GBike bike = (GBike)gBike;
		System.out.println(bike.getSpeed());
		
		mBike.downSpeed();
		
		return "bike.getSpeed()";
	}
	
	@RequestMapping("/S01_2")
	public String myWeb2() {
		return "<h1><a href='https://www.google.com.tw'>Google<a></h1>";
	}
	
}
