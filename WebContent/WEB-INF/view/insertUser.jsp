<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>New User Information</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<h1>New User Information:</h1>

	<form action="lets" method="get">
		<label>UserName</label> <input type="text" name="username" /> <br>
		<label>First Name</label> <input type="text" name="fname" /> <br>
		<label>Last Name</label> <input type="text" name="lname" /> <br>
		<label>Password</label> <input type="password" name="password" /> <br>
		<label>role</label> <input type="text" name="role" /> <br> 
		<input type="submit" name="submit" value="Insert" />
	</form>

	<form action="back">
		<input type="submit" name="Send" value="Cancel" />
	</form>
</body>
</html>