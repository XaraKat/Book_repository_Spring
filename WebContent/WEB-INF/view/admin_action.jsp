<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actions</title>
</head>
<body>
	<h1>Choose an option:</h1>


	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" id="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>

	<br>
	<sec:authorize access="hasAuthority('admin')">
		<a href="<c:url value="User_list"></c:url>">Show Users</a>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAuthority('admin')">
		<a href="<c:url value="inse_rtUser"></c:url>">Insert Users</a>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAuthority('admin')">
		<a href="<c:url value="del_user"></c:url>">Delete Users</a>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAuthority('admin')">
		<a href="<c:url value="up_user"></c:url>">Update Users</a>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAuthority('admin')">
		<a href="<c:url value="book_ch"></c:url>">Show Students That Have No Books Yet</a>
	</sec:authorize> 
</body>
</html>