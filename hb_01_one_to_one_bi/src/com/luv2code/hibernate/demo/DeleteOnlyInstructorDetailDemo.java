package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;


//Bi-directional
public class DeleteOnlyInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int id = 2;
			//start a transaction
			System.out.println("Begin Transaction");
			session.beginTransaction();
			
			//get the instructor detail object
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, id);
			//print the instructor Detail
			System.out.println(theInstructorDetail);
			//get the instructor obj
			Instructor theInstructor = theInstructorDetail.getTheInstructor();
			
			System.out.println(theInstructor);
			//remove the associated object reference
			//break bi-directional link
			//instructor --X--> instructorDetail
			//			 <----	
			
			theInstructorDetail.getTheInstructor().setInstructorDetail(null);
			
			
			//delete the instructor detail
			System.out.println("Deleting InstructorDetail obj...");
			session.delete(theInstructorDetail);
			
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		finally {
			//handle connection leak issue
			session.close();
			
			factory.close();
		}

	}

}
