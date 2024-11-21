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
		<h1>
			<c:out value="${dog.name}" />
			's Info
		</h1>
		<c:if test="${dog.isPlayful }">
			<p>
				<c:out value="${dog.name}" />
				is a
				<c:out value="${dog.age}" />
				year old
				<c:out value="${dog.breed}" />
				and loves to play
				<c:out value="${dog.name}" />
				's Owner is
				<c:out value="${dog.owner.username}" />
			</p>
		</c:if>
		<c:if test="${!dog.isPlayful }">
			<p>
				<c:out value="${dog.name}" />
				is a
				<c:out value="${dog.age}" />
				year old
				<c:out value="${dog.breed}" />
				and loves to relax
				<c:out value="${dog.name}" />
				's Owner is
				<c:out value="${dog.owner.username}" />
			</p>
		</c:if>
		<form:form action="/create/comment/${dog.id }" method="post"
			modelAttribute="comment">
			<p>
				<form:label path="content">Post:</form:label>
				<form:errors path="content" />
				<form:input type="text" path="content" />
			</p>
			<input type="hidden" name="dog" value="${dog.id}" />
			<input type="hidden" name="user" value="${userId}" />
			<input type="submit" value="Submit" />
		</form:form>
		<c:forEach var="comment" items="${dog.comments}">
			<p>
				<c:out value="${comment.user.username}" />
				Says:
				<c:out value="${comment.content}" />
				<c:if test="${comment.user.id == userId}">
					<form action="/delete/${comment.id}/comment/${dog.id}"
						method="post">
						<input type="hidden" name="_method" value="delete"> <input
							class="btn btn-danger" type="submit" value="Delete">
					</form>
				</c:if>
			</p>

		</c:forEach>
	</div>
</body>
</html>