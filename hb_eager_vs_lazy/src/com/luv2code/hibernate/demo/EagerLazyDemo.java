package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
/** lazy load console
 * Begin Transaction
	Hibernate: select instructor0_.id as id1_1_0_, instructor0_.email as email2_1_0_, instructor0_.first_name as first_na3_1_0_, instructor0_.instructor_detail_id as instruct5_1_0_, instructor0_.last_name as last_nam4_1_0_, instructor1_.id as id1_2_1_, instructor1_.hobby as hobby2_2_1_, instructor1_.youtube_channel as youtube_3_2_1_ from instructor instructor0_ left outer join instructor_detail instructor1_ on instructor0_.instructor_detail_id=instructor1_.id where instructor0_.id=?
	Instructor :Instructor [id=1, firstName=Susain, lastName=Public, email=susain@gmail.com]
	Hibernate: select courses0_.instructor_id as instruct3_0_0_, courses0_.id as id1_0_0_, courses0_.id as id1_0_1_, courses0_.instructor_id as instruct3_0_1_, courses0_.title as title2_0_1_ from course courses0_ where courses0_.instructor_id=?
	[Course [id=11, title=C++], Course [id=12, title=Java]]
	Done
 *
 *Eager Load Console
 *Begin Transaction
	Hibernate: select instructor0_.id as id1_1_0_, instructor0_.email as email2_1_0_, instructor0_.first_name as first_na3_1_0_, instructor0_.instructor_detail_id as instruct5_1_0_, instructor0_.last_name as last_nam4_1_0_, courses1_.instructor_id as instruct3_0_1_, courses1_.id as id1_0_1_, courses1_.id as id1_0_2_, courses1_.instructor_id as instruct3_0_2_, courses1_.title as title2_0_2_, instructor2_.id as id1_2_3_, instructor2_.hobby as hobby2_2_3_, instructor2_.youtube_channel as youtube_3_2_3_ from instructor instructor0_ left outer join course courses1_ on instructor0_.id=courses1_.instructor_id left outer join instructor_detail instructor2_ on instructor0_.instructor_detail_id=instructor2_.id where instructor0_.id=?
	Instructor :Instructor [id=1, firstName=Susain, lastName=Public, email=susain@gmail.com]
	[Course [id=11, title=C++], Course [id=12, title=Java]]
	Done
 *
 *
 *We can clearly differentiate in Lazy Load after we call System.out.println(tempInstructor.getCourses());
 *then courses are fetched from DB
 *but in Eager Load everything was loaded in memory and when we called getCourses no DB request was done because
 *all the Entity are loaded in memory 
 */


public class EagerLazyDemo {

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
			
			int id=1;
			Instructor tempInstructor = session.get(Instructor.class,id);
			System.out.println("Instructor :"+tempInstructor);
			//System.out.println(" Courses: " + tempInstructor.getCourses());
			
			//close the session
			
			//session.close();
			
			//since session is closed ,lazy load should fail
			
			System.out.println(tempInstructor.getCourses());
			
			// 	solution
			// 	option 1: call getter method while session is open
			// 	uncomment line 56
			//	solution 1 will load the courses when session was open
			// 	after the session is closed 
			//	System.out.println(tempInstructor.getCourses()); won't throw any error
			//	because courses are already in memory
			
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

