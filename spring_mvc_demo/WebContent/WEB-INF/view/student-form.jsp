<!-- Reference to spring mvc tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!-- 
- form:form , form:input all these are spring mvc tags
- modelAttribute = "student", it must matches to StudentController > theModel.addAttribute("student", theStudent);
- firstName and lastName are the proeperties of Student Class
 -->

<!DOCTYPE html>

<html>

<head>
	<title> Student Registration Form </title>
</head>
<body>
	
	<form:form action="processForm" modelAttribute="student">
		
		First Name: <form:input path="firstName" />
		<br></br>
		Last Name: <form:input path="lastName" />
		<!-- When Form is loaded Spring MVC will call 
		student.getFirstName() and student.getLastName()
		 -->
		 
		 <br></br>
		 
		 <!-- On submit spring will call student.setCountry() 
		  <form:select path="country">
		 <form:option value="Brazil" label="Brazil" />
		 <form:option value="India" label="India" />
		 <form:option value="France" label="France" />
		 </form:select>
		 -->
		 
		  <!-- On form load spring will call student.getCountryOptions(), 
		  On form submit spring will call student.setCountry() -->
		  <form:select path="country">
			 <form:options items="${student.countryOptions}" />
		  </form:select>
		 <br></br>
		
		<%-- 
		 Java <form:radiobutton path="favLanguage" value="Java" />
		 C# <form:radiobutton path="favLanguage" value="C#" />
		 Ruby <form:radiobutton path="favLanguage" value="Ruby" /> --%> 
		 
		 <!--  reading radio button list from Java Class instead of hardcoding.
		 On form load spring will call student.getFavoriteLanguageOptions(), 
		  On form submit spring will call student.setFavoriteLanguage() -->
		 <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
		 
		 <br></br>
		 <%--  Checkboxes , internally student.setOperatingSystem() called on form submission --%>
		 Linux <form:checkbox path="operatingSystems" value="linux" />
		 
		 Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		 
		 MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
		 
		 <br></br>
		 
		<input type="submit" value="submit" />
		<!-- When Form is submitted Spring MVC will call 
		student.setFirstName() and student.setLastName()
		 -->
		 
	</form:form>
	

</body>

</html>