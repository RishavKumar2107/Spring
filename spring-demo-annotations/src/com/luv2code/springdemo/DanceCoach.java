package com.luv2code.springdemo;

public class DanceCoach implements Coach {

	//applying constructor injection
	FortuneService fortuneService;
	
	public DanceCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Stretch for 10mins";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}
