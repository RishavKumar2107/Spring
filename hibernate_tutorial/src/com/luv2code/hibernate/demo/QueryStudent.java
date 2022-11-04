package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			System.out.println("Begin Transaction");
			session.beginTransaction();
			
			//query students
			System.out.println("querying...");
			//List<Student> theStudents = session.createQuery("from Student").getResultList();
			//List<Student> theStudents = session.createQuery("from Student s where s.lastName='Kumar'").getResultList();
			List<Student> theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
			
			for (Student theStudent : theStudents)
			{
				System.out.println(theStudent);
			}
		}
		finally {
			factory.close();
		}
	}

}
