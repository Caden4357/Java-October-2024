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
		<div>
			<table class="table table-striped table-dark">
				<tr>
					<th>Name</th>
					<th>Breed</th>
					<th>Age</th>
					<th>Owner</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="dog" items="${dogs}">
					<tr>
						<td><c:out value="${dog.name }" /></td>
						<td><c:out value="${dog.breed }" /></td>
						<td><c:out value="${dog.age }" /></td>
						<td><c:out value="${dog.owner.username}" /></td>
						<td>
							<c:if test="${dog.owner.id == userId}">
								<a class="btn btn-primary" href="/edit/${dog.id}/dog">Edit</a>
								<form action="/delete/${dog.id}/dog" method="post">
									<input type="hidden" name="_method" value="delete"> 
									<input class="btn btn-danger" type="submit" value="Delete">
								</form>
							</c:if> 
							<a class="btn btn-success" href="/view/${dog.id}/dog">View</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>