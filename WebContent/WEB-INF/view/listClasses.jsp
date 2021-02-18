<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Classes</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Your Classes</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Class</th>
					<th>|</th>
					<th>Description</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempClasses" items="${classes}">

					<tr>
						<td>${tempClasses.classes}</td>
						<th>|</th>
						<td>${tempClasses.description}</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<h2>Proceed To Selecting A book?</h2> 
	
	<form action="classInfo" method="GET">

		<input list="chosenclasses" name="chosenclasses">
		<datalist id="chosenclasses">

			<c:forEach var="tempClasses" items="${classes}">
				<tr>
					<option value=${tempClasses.classes}>
				</tr>
			</c:forEach>
		</datalist>
		<input type="submit" value="Choose Class" />
	</form>
	
	<form action="shoch_books">
		<input type="submit" name="Send" value="Show Chosen Books" />
	</form>
	
	<form action="back2">
		<input type="submit" name="Send" value="Back" />
	</form>
	
	
</body>
</html>