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
		<h1>
			Band:
			<c:out value="${band.bandName}" />
		</h1>
		<h2>
			Genre:
			<c:out value="${band.genre}" />
		</h2>
		<h3>Musicians:</h3>
		<c:forEach var="musician" items="${band.musicians}">
			<p>
				<a href="#"> <c:out value="${musician.name}" />
				</a>
			</p>
		</c:forEach>
		<form action="/add/musician/to/${band.id}" method="post">
			<select name="musicianId">
				<c:forEach var="musician" items="${musicians}">
					<option value="${musician.id}">
						<c:out value="${musician.name}"/>
					</option>
				</c:forEach>
			</select>
			<button>Add</button>
		</form>
	</div>
</body>
</html>