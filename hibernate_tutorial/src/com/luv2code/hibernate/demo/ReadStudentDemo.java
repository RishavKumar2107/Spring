package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
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
				
				//retrieve a student obj from DB using primary key
				System.out.println("retrieve a  Student Obj");
				Student myStudent = session.get(Student.class,2);
				
				//commit the transaction
				session.getTransaction().commit();
				System.out.println("Done");
				
				
				System.out.println(myStudent);
			}
			finally {
				factory.close();
			}
	}
	
}
