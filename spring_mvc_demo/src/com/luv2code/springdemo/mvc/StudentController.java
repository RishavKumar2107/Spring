package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author risha
 *
 * This class is to Demonstrate Spring Form Tags and Data Binding
 *
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController {

		@RequestMapping("/showForm")
		public String showForm(Model theModel) {
			
			//create a student object
			//that will be pass to the form
			//to make use of it
			Student theStudent = new Student();
			
			//add Student object to the model
			theModel.addAttribute("student", theStudent);
			
			return "student-form";
		}
		
		
		//@ModelAttribute bind the model attribute to parameter being passed in
		//this binds form data to the Object
		@RequestMapping("/processForm")
		public String processForm(@ModelAttribute("student") Student theStudent) {
			//Logging data
			System.out.println(theStudent.getFirstName()+ " "+theStudent.getLastName()+"->"+theStudent.getCountry());
			return "student-confirmation";
		}
			
	
}
