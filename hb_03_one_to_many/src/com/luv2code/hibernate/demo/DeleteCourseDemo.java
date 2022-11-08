package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
			
			//start transaction
			System.out.println("Begin Transaction");
			session.beginTransaction();
			
			int id=10;
			Course course = session.get(Course.class,id);
			
			session.delete(course);
	
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
