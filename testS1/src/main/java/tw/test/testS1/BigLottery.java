package tw.test.testS1;

import java.util.Random;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class BigLottery implements Lottery{
	
	@Override
	public Integer createLottery() {
		int lottery = new Random().nextInt(1, 38+1);
		return lottery;
	} 
}
