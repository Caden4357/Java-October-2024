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
		<a href="/">Home</a>
		<h1>
			Show:
			<c:out value="${show.name}"></c:out>
		</h1>
		<h3>
			Network:
			<c:out value="${show.network}"></c:out>
		</h3>
		<h3>
			Number Of Seasons:
			<c:out value="${show.numOfSeasons}"></c:out>
		</h3>
		<h3>
			Still In Production:
			<c:out value="${show.stillInProduction}"></c:out>
		</h3>
	</div>
</body>
</html>