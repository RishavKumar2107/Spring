package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DanceJavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// load the spring configuration class
				AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext(SportConfig.class);
						
				//danceCoach refers to danceCoach Bean we define in SportConfig class
				Coach theCoach = context.getBean("danceCoach", Coach.class);
				
				// call methods on the bean
				System.out.println(theCoach.getDailyWorkout());
				
				System.out.println(theCoach.getDailyFortune());
				
				// close the context
				context.close();
	}

}
