package info.sliceoflife.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// Array of strings
	private String[] data = {
		"Beware of the wolf in sheep's clothing",
		"Diligence is thother of good luck",
		"The journey is the reward"
	};
	
	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick random fortune out of the array
		int index = myRandom.nextInt(data.length);
		return data[index];
	}
	
	

}
