<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- For JSTL Forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<header class="mt-5">
			<nav class="d-flex justify-content-between">
				<h2>
					Hello
					<c:out value="${user.username}" />
				</h2>

				<h2>Welcome To Dogs dot com</h2>


				<div class="w-25">
					<a href="/home">Home</a> | <a href="/dog/form">Add your dog</a> | <a
						href="#">Treats</a> | <a href="/logout">Logout</a>
				</div>

			</nav>
		</header>
		<h2>Edit <c:out value="${dog.name }"/></h2>
		<form:form action="/update/${dog.id}/dog" method="post" modelAttribute="dog">
		<input type="hidden" name="_method" value="put">
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