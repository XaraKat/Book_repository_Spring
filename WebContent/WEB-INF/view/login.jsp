<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta charset="utf-8">
<meta name="robots" content="index, follow">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description"
	content="Spectre.css CSS Framework is a lightweight, responsive and modern CSS framework for faster and extensible development. Spectre provides basic styles for typography and elements, flexbox based responsive layout system, pure CSS components and utilities with best practice coding and consistent design language.">
<link rel="shortcut icon" href="../img/favicons/favicon.ico">
<link rel="icon" href="../img/favicons/favicon.png">
<link rel="stylesheet" href="../dist/spectre.min.css">
<link rel="stylesheet" href="../dist/spectre-icons.min.css">
<link rel="stylesheet" href="../dist/spectre-exp.min.css">
<link rel="stylesheet" href="../dist/docs.min.css">
<div class="ui segment">

	<h3>Login</h3>


	<form:form action="${pageContext.request.contextPath}/authUser"
		method="POST">
		<c:if test="${param.error != null}">
			<i>Try Again</i>

		</c:if>
		<div class="field">
			<label>User Name</label> <input type="text" name="username" />
		</div>
		<div class="field">
			<label>Password</label> <input type="password" name="password" />
		</div>
		
		<div class="field">
			<input type="submit" value="Login" />
		</div>
	</form:form>
</div>