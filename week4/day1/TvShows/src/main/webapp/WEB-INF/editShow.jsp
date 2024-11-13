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
		<h1>Edit Show</h1>
		<form:form action="/update/${show.id}/show" method="post"
			modelAttribute="show">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input type="text" path="name" />
			</p>
			<p>
				<form:label path="network">Network</form:label>
				<form:errors path="network" />
				<form:input path="network" />
			</p>
			<p>
				<form:label path="numOfSeasons">Number Of Seasons</form:label>
				<form:errors path="numOfSeasons" />
				<form:input type="number" path="numOfSeasons" />
			</p>
			<p>
				<form:label path="stillInProduction">Still In Production</form:label>
				<form:errors path="stillInProduction" />
				<form:checkbox path="stillInProduction" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>