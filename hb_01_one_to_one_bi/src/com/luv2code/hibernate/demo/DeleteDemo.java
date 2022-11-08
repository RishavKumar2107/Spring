package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		int id=1;
		try {
			
			
					
			//start a transaction
			System.out.println("Begin Transaction");
			session.beginTransaction();
			
			//fetch the objects
			Instructor myInstructor = session.get(Instructor.class,id);
			
			//save the instructor
			//Note: this will also delete the InstructorDetail object
			//because of cascade
			
			if(myInstructor!=null)
				session.delete(myInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}

	}

}
