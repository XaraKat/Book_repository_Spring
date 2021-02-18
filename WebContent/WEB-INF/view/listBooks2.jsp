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
			<h2>Your Books</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Book Name</th>
					<th>|</th>
					<th>Class</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempchosen_Books" items="${chosen_books}">
					<tr>
						<td>${tempchosen_Books.book}</td>
						<th>|</th>
						<td>${tempchosen_Books.classes}</td>
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

</body>
</html>