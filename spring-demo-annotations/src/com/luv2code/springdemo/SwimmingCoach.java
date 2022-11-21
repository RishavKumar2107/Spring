package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements  Coach {

	//3. Field Injection
	//Inject Dependencies by setting field values on your class directly
	@Autowired
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "swim for 1hr";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}
