<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Delete User</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<h1>Update User:</h1>
<h2>Give a Username:</h2>


	<form action="del_2" method="get">
		<label>Username</label> 
		<input type="text" name="username" /> 
		<br>		 
		<input type="submit" name="submit"  value="Update" />
	</form>
	
	<form action="back" >
		<input type="submit" name="Send"  value="Cancel" />
	</form>
	
</body>
</html>