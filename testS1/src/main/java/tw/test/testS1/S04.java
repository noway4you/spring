package tw.test.testS1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S04 {
	
	@Autowired
	@Qualifier("bigLottery2")
	private Lottery lottery1;
	
	@Autowired
	@Qualifier("bigLottery3")
	private Lottery lottery2;
	
	@Autowired
	private MySetting mySetting;
	
	@RequestMapping("/S04")
	public String S04() {
		System.out.println(mySetting.getBiglottery2() + ":" + lottery1.createLottery());
		System.out.println(mySetting.getBiglottery3() + ":" + lottery2.createLottery());
		((BigLottery3)lottery2).m1();
		((BigLottery3)lottery2).poker1();
		return "S04";
	}
	
}	
