<!DOCTYPE html>

<html>

<head>
	<title> Customer Registration Form </title>
</head>
<body>
	<!--  ${customer.firstName} internally calls customer.getFirstName() -->
	The Customer is confirmed: ${customer.firstName} ${customer.lastName} 
	<br></br>
	Free Passes : ${customer.freePasses}
	<br></br>
	Postal Code: ${customer.postalCode}
	<br></br>
	Course Code :${customer.courseCode }
	
</body>
</html>