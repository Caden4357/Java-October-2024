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
		<h1>NBA</h1>
		<a href="/player/form">Add A Player</a>
		<a href="/coach/form">Add A Coach</a>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>City</th>
					<th>State</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="team" items="${teams}">
					<tr>
						<td><c:out value="${team.name}" /></td>
						<td><c:out value="${team.city}" /></td>
						<td><c:out value="${team.state}" /></td>
						<td><a class="btn btn-success" href="/team/${team.id}">View</a>
							<form action="/delete/${team.id}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									class="btn btn-danger" type="submit" value="Delete">
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form action="/new/team" method="post" modelAttribute="team"
			class="mx-auto w-50">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input class="w-100" path="name" />
			</p>
			<p>
				<form:label path="city">City</form:label>
				<form:errors class="text-danger" path="city" />
				<form:input class="w-100" path="city" />
			</p>
			<p>
				<form:label path="state">State</form:label>
				<form:errors class="text-danger" path="state" />
				<form:input class="w-100" path="state" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>