package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

		// add an initbinder ... to convert trim input strings
		// remove leading and trailing whitespace
		// resolve issue for our validation
		//init binder works as a preprocessor
		//it will preprocess each web request to out controller
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			//preprocess every string form data
			//remove leading and trailing white space
			//if string has only whitespace then trim it to null
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
			
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}
		
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	//@Valid tells to perform 
	//validation rules on Customer object
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult)
	{
		System.out.println("Binding Result = "+theBindingResult);
		if(theBindingResult.hasErrors())
			return "customer-form";
		else
			return "customer-confirmation";
			
	}
	
}
