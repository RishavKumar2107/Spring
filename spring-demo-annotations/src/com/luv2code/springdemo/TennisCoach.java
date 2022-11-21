package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//spring will automatically register this bean
//bean id : thatSillyCoach
@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backend volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

	
	//2.Setter injection
	//when compiler see @Autowired , it knows that it has to resolve the dependencies so it look for 
	//class that implements FortuneService
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	//code will execute after constructor and after injection
	//of dependencies
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println("init method called ");
	}
	
	@PreDestroy
	public void doMyCleanUpStaff()
	{
		System.out.println("destroy method called ");
	}
	

  
}
