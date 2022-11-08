package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;


//uni-directional
public class CreateDemo {

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
			
			//create the objects
			//Instructor tempInstructor = new Instructor("Chad","Darby","darby@gmail.com");
			Instructor tempInstructor = new Instructor("Rahul","Raman","rahul@gmail.com");
			
			
			/**InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.youtube.com","Luv 2 Code");**/
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.youtube.com","Guitar");
			
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			//start a transaction
			System.out.println("Begin Transaction");
			session.beginTransaction();
			
			//save the instructor
			//Note: this will also save the InstructorDetail object
			//because of cascade
			session.save(tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}

	}

}
