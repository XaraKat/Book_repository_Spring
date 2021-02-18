<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<title>Email Stubents</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<h1>
		From:
		<sec:authentication property="principal.username" />
	</h1>
	<h2>To: All</h2>

	<label>Subject: </label>
	<input type="text" name="sub" />
	<br>
	<label>Email Body: </label>
	<br>
	<input type="text" name="body"
		style="font-size: 18pt; height: 420px; width: 200px;" />
	<br>

	<form action="back">
		<input type="submit" name="Send" value="Cancel" />
	</form>

	<form action="back">
		<input type="submit" name="Send" value="Send" />
	</form>

</body>
</html>