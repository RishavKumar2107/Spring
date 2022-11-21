package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//spring will automatically register this bean
//default bean id : cricketCoach
@Component
public class CricketCoach implements Coach {

	FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Bowl 10 overs";
	}
	
	//Three types of Dependency Injection Supported with Java Annotation
	//1.Constructor injection
	//spring will scan for a component that implements FortuneService interface
	//example HappyFortuneService meets the requirement
	@Autowired
	public CricketCoach(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}

	//2.Setter injection implemented in TennisCoach Class
	//3. Field Injection implemented in SwimmingCoach Class
	//Inject Dependencies by setting field values on your class directly
	public String getDailyFortune()
	{
		return fortuneService.getDailyFortune();	
	}
  
}
