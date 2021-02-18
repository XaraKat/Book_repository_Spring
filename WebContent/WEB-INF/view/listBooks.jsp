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
					<th>Address</th>
					<th>|</th>
					<th>Address</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempBooks" items="${books}">
					<tr>
						<td>${tempBooks.book_name}</td>
						<th>|</th>
						<td>${tempBooks.address}</td>
						<th>|</th>
						<td>${tempBooks.numb_avail}</td>
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


	<form action="summ" method="GET">
		<input list="chooseBook" name="chooseBook">
		<datalist id="chooseBook">

			<c:forEach var="tempBooks" items="${books}">
				<tr>
					<option value=${tempBooks.book_name}>
				</tr>
			</c:forEach>
		</datalist>

		<input list="chooseBook2" name="chooseBook2">
		<datalist id="chooseBook2">

			<c:forEach var="tempBooks" items="${books}">
				<tr>
					<option value=${tempBooks.book_name}>
				</tr>
			</c:forEach>
		</datalist>
		<input type="submit"  value="Submit" />
	</form>

</body>
</html>