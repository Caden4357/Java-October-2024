<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- For JSTL Forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
	<h1>Add A Musician</h1>
		<form:form action="/create/musician" method="post"
			modelAttribute="musician">
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input path="name" />
			</p>
			<button>Add</button>
		</form:form>
	</div>
</body>
</html>