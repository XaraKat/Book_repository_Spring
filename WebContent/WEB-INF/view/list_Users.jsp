<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<title>List Users</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Users</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Class</th>
					<th>|</th>
					<th>First Name</th>
					<th>|</th>
					<th>Last Name</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempUsers" items="${users}">

					<tr>
						<td>${tempUsers.username}</td>
						<th>|</th>
						<td>${tempUsers.fname}</td>
						<th>|</th>
						<td>${tempUsers.lname}</td>
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

	<sec:authorize access="hasAuthority('admin')">
		<a href="<c:url value="back"></c:url>">Back</a>
	</sec:authorize>
</body>
</html>