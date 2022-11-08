package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the objects
			Instructor tempInstructor = new Instructor("Susain","Public","susain@gmail.com");

			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.youtube.com","Video Games");
			
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start transaction
			System.out.println("Begin Transaction");
			session.beginTransaction();
		
			session.save(tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
