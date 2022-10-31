package com.luv2code.springdemo.mvc;
import java.util.LinkedHashMap;

public class Student {

	String firstName , lastName , country;
	
	private LinkedHashMap<String,String> countryOptions;

	public Student() {
		countryOptions = new LinkedHashMap<>();
		
		//(value,label)
		countryOptions.put("BR", "Brazil");
		countryOptions.put("IN", "India");
		countryOptions.put("CH", "China");
	}

	//when form is loaded it will call getCountryOptions()
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
	
}
