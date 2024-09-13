package tw.test.testS1;

import java.util.Random;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BigLottery2 implements Lottery,InitializingBean{

	public BigLottery2() {
		System.out.println("BigLottery2");
	}
	
	@Override
	public Integer createLottery() {
		int lottery = new Random().nextInt(1,40);
		return lottery;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
	}
	
	
}
