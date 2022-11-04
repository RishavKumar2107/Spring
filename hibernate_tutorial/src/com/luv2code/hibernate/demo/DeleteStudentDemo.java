package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
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
					
					
					System.out.println("delete the student of id = x");
					Student myStudent = session.get(Student.class, id);
					
					//approach 1 (query method)
					//delete entry for student having id = 2
					session.createQuery("delete from Student where id = 2").executeUpdate();
						
					//approach 2 (object retrieval method)
					int studentId=1;
					//retreive object
					Student student = session.get(Student.class, id);
					//delete the student
					session.delete(student);
					
					//commit the transaction
					session.getTransaction().commit();
					System.out.println("Done");
					
				}
				finally {
					factory.close();
				}
	}
}
