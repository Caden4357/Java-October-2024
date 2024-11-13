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
		<h1>Add your band</h1>
		<a href="/musician/form">Add A Musician</a>
		<h2>Bands:</h2>
		<c:forEach var="band" items="${bands}">
			<p>
				<a href="/band/${band.id}"> <c:out value="${band.bandName}" />
				</a>
			</p>
		</c:forEach>
		<h2>Musicians:</h2>
		<c:forEach var="musician" items="${musicians}">
			<p>
				<a href="#"> <c:out value="${musician.name}" />
				</a>
			</p>
		</c:forEach>
		<form:form action="/create/band" method="post" modelAttribute="band">
			<p>
				<form:label path="bandName">Name:</form:label>
				<form:errors class="text-danger" path="bandName" />
				<form:input path="bandName" />
			</p>
			<form:select path="genre">
				<option value="Pop">Pop</option>
				<option value="Rock">Rock</option>
				<option value="Punk">Punk</option>
				<option value="Country">Country</option>
				<option value="Hip-Hop/Rap">Hip-Hop/Rap</option>
				<option value="R&B">R&B</option>
			</form:select>
			<button>Add</button>
		</form:form>
	</div>
</body>
</html>