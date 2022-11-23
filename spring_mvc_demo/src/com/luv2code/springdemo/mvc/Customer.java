package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import com.luv2code.springdemo.mvc.validation.CourseCode;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * 
 * @author risha
 *
 * Customer Class is to demonstrate Validation Rules 
 *
 */

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
	
	@CourseCode
	private String courseCode;
	
	
	//reason for refactoring int to Integer is because 
	//Just because Integer is an Object, so it can be null.
	//You can't null primitive types
	//
	@NotNull(message="is required")
	@Min(value=0 , message="must be greater than or equal to zero")
	@Max(value=10 , message="must be less than or equal to ten")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{6}",message="only 6char/digits")
	private String postalCode;
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
}
