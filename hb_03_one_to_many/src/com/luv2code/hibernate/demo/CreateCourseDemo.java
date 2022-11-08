package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCourseDemo {

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
		
			
			//get the instructor from DB
			
			//create some courses
			
			//add course to instructor
			
			//save the courses
			
			int id=1;
			Instructor tempInstructor = session.get(Instructor.class,id);
			
			Course tempCourse1 = new Course("Java");
			Course tempCourse2 = new Course("C++");
			
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
	
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
