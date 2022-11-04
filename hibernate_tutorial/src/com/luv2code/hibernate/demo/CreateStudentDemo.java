package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student obj
			System.out.println("Creating a new Student Obj");
			Student tempStudent = new Student("Anny","Roy","anny@gmail.com");
			
			//start transaction
			System.out.println("Begin Transaction");
			session.beginTransaction();
			
			//save the student
			System.out.println("Saving the student");
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}

	}

}
