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
		<h2>Add your dog</h2>
		<form:form action="/create/dog" method="post" modelAttribute="dog">
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input type="text" path="name" />
			</p>
			<p>
				<form:label path="breed">Breed</form:label>
				<form:errors path="breed" />
				<form:input path="breed" />
			</p>
			<p>
				<form:label path="age">Age</form:label>
				<form:errors path="age" />
				<form:input type="number" path="age" />
			</p>
			<p>
				<form:label path="isPlayful">Likes To Play?</form:label>
				<form:errors path="isPlayful" />
				<form:checkbox path="isPlayful" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>