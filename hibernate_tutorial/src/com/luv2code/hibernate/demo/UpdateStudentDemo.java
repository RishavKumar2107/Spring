package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				//create session
				Session session = factory.getCurrentSession();
				int id = 1;
				try {
					
					//start transaction
					System.out.println("Begin Transaction");
					session.beginTransaction();
					
					
					System.out.println("update the student of id = x");
					Student myStudent = session.get(Student.class, id);
					
					//update first name to "Spider"
					// no query is done , we only call setter method
					myStudent.setFirstName("Spider");
					
					//update emails for all students
					session.createQuery("update Student set email='foo@gmail.com'")
										.executeUpdate();
						
					//update emails for  student where id = 1
				   session.createQuery("update Student set email='rishavkr20@gmail.com' where id=1")
											.executeUpdate();
					//commit the transaction
					session.getTransaction().commit();
					System.out.println("Done");
					
				}
				finally {
					factory.close();
				}
	}

}
