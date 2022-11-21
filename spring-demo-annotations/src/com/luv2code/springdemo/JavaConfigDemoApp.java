package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// load the spring configuration class
				AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext(SportConfig.class);
						
				// retrieve bean from spring container
				Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
				
				// retrieve bean by ref default bean id
				//Coach theCoach = context.getBean("cricketCoach", Coach.class);
				//Coach theCoach = context.getBean("swimmingCoach", Coach.class);
				
				// call methods on the bean
				System.out.println(theCoach.getDailyWorkout());
				
				System.out.println(theCoach.getDailyFortune());
				
				// close the context
				context.close();
	}

}
