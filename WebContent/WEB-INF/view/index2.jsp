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
<title>Welcome page</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mystyles.css" />
</head>
<body>
	<h1>
		Welcome
		<sec:authentication property="principal.username" />
		,
		<sec:authentication property="principal.authorities" />
		!
	</h1>


	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" id="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
 
	<sec:authorize access="hasAuthority('student')">
		<a href="<c:url value="/showClasses1"></c:url>">Show Classes</a>
	</sec:authorize>
 

</body>
</html>