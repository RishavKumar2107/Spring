<!-- Reference JSTL Tag Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title> Student Registration Form </title>
</head>
<body>
	<!--  ${student.firstName} internally calls student.getFirstName() -->
	The student is confirmed: ${student.firstName} ${student.lastName} 
	<br></br>
	Country: ${student.country}
	<br></br>
	Language: ${student.favoriteLanguage}
	<br></br>
	
	
	Operating Systems:

	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
	
			<li> ${temp} </li>
	
		</c:forEach>
	</ul>
	
	
	

</body>
</html>