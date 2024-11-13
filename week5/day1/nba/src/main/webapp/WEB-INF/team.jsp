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
	<div>
		<h1>
			<c:out value="${team.name}" />
		</h1>
		<h2>Players:</h2>
		<c:forEach var="player" items="${team.players}">
			<h2>
				<c:out value="${player.name}" />
			</h2>
		</c:forEach>
		<h2>Coaches:</h2>
		<c:forEach var="coach" items="${team.coaches}">
			<h2>
				Name: <c:out value="${coach.name}" />
			</h2>
			<h2>
				Title: <c:out value="${coach.title}" />
			</h2>
		</c:forEach>
	</div>
</body>
</html>