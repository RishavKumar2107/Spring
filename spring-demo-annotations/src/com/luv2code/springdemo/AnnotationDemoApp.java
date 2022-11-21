package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// load the spring configuration file
				ClassPathXmlApplicationContext context = 
						new ClassPathXmlApplicationContext("applicationContext.xml");
						
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
