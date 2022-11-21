package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//3 ways of configuring spring container
//Full XML Config , XML Component Scan , Java Configuration Class
//Below is an example of Java Config Class


//@Confuration tells hey spring this is a java configuration class
@Configuration
//commenting ComponentScan when we specify @Bean 
//because we simply want to use two bean that we have created
//in SportConfig class
//@ComponentScan("com.luv2code.springdemo")
public class SportConfig {
	
	
	//below code is to demonstrate define @Bean with java code (No component Scan)
	//note:Dance Coach has no annotations defined eg @Component
	
	//define bean for happy fortune service
	//bean id : happyFortuneService 
	@Bean
	public FortuneService happyFortuneService()
	{
		return new HappyFortuneService();
	}
	//define bean for DanceCoach and inject Dependencies
	//bean id : danceCoach 
	@Bean
	public Coach danceCoach()
	{
	  DanceCoach danceCoach = new DanceCoach(happyFortuneService());
	  return danceCoach;
	}
}
