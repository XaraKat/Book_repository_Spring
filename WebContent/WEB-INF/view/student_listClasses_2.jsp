<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student's List Classes</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Students:</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Username</th>
					<th>|</th>
					<th>Class</th>
					<th>|</th>
					<th>Semester</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempClasses" items="${semester_classes}">

					<tr>
						<td>${tempClasses.username}</td>
						<th>|</th>
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

	&nbsp;
	<sec:authorize access="hasAuthority('admin')">
		<a href="<c:url value="send"></c:url>">Send email To All</a>
	</sec:authorize>
	&nbsp;
	
	<sec:authorize access="hasAuthority('admin')">
		<a href="<c:url value="back"></c:url>">Back</a>
	</sec:authorize>
</body>
</html>