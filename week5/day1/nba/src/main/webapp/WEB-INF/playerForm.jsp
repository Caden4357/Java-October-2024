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
		<h1>Add A Player</h1>
		
		<form:form action="/new/player" method="post" modelAttribute="player"
			class="mx-auto w-50">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input class="w-100" path="name" />
			</p>
			<p>
				<form:label path="age">Age</form:label>
				<form:errors class="text-danger" path="age" />
				<form:input class="w-100" type="number" path="age" />
			</p>
			<p>
				<form:label path="position">position</form:label>
				<form:errors class="text-danger" path="position" />
				<form:input class="w-100" path="position" />
			</p>
			<p>
				<form:label path="team">Team:</form:label>
				<form:select path="team">
					<c:forEach var="team" items="${teams}">
						<option value="${team.id}">
							<c:out value="${team.name}"/>
						</option>
					</c:forEach>
				</form:select>
			</p>
			<button>Add</button>
		</form:form>
	</div>
</body>
</html>