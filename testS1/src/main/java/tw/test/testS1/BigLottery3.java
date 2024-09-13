package tw.test.testS1;

import java.util.Random;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class BigLottery3 implements Lottery{
	
	public BigLottery3() {
		System.out.println("BigLottery3");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init()");
	}
	
	public void m1() {
		System.out.println("m1()");
	}
	
	public void poker1() {
		for (int a=0; a<1000; a++) {
			// 洗牌
			int[] poker = new int[52];
			for (int i=0; i<poker.length; i++) {
				int temp = (int)(Math.random()*52);
				// 檢查機制
				boolean isRepeat = false;
				for(int j = 0; j < i; j++) {
					if (temp == poker[j]) {
						// 重複了
						isRepeat = true;
						break;
					}
				}
				
				if (!isRepeat) {
					poker[i] = temp;
					System.out.println(poker[i]);
				}else {
					i--;
				}
			}
		}
	}
	
	@Override
	public Integer createLottery() {
		int lottery = new Random().nextInt(1,50);
		return lottery;
	} 
}
