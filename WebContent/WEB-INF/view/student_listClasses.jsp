<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student's List Classes</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mystyles.css" />
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
					<th>Semester</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempClasses" items="${semester_classes}">

					<tr>
						<td>${tempClasses.classes}</td>
						<th>|</th>
						<td>${tempClasses.semester}</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" id="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>

	<form action="back2">
		<input type="submit" name="Send" value="Back" />
	</form>

	<form action="stud_classInfo" method="GET">

		<input list="chosenclasses" name="chosenclasses">
		<datalist id="chosenclasses">

			<c:forEach var="tempClasses" items="${semester_classes}">
				<tr>
					<option value=${tempClasses.classes}>
				</tr>
			</c:forEach>
		</datalist>
		<input type="submit" value="Choose Class" />
	</form>
</body>
</html>