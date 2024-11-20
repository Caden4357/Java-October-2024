<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class=container>
		<h1>TvDb</h1>
		<form action="/search/title" method="post" class="mb-5">
			<input value="Search..." name="searchQuery" />
			<button>Search</button>
		</form>
		<a href="/reset/shows">Reset</a>
		<form:form action="/shows" method="post" modelAttribute="show">
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
		<div class="d-flex justify-content-between">
			<c:if test="${empty searchedShows}">
				<table class="table table-striped table-dark">
					<tr>
						<th>Name</th>
						<th>Network</th>
						<th>Number Of Seasons</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="show" items="${showsFromBackend}">
						<tr>
							<td><c:out value="${show.name }" /></td>
							<td><c:out value="${show.network }" /></td>
							<td><c:out value="${show.numOfSeasons }" /></td>
							<td><a class="btn btn-primary" href="/edit/${show.id}/show">Edit</a>
								<form action="/delete/${show.id}/show" method="post">
									<input type="hidden" name="_method" value="delete"> <input
										class="btn btn-danger" type="submit" value="Delete">
								</form> <a class="btn btn-success" href="/view/${show.id}/show">View</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${not empty searchedShows}">
				<table class="table table-striped table-dark">
					<tr>
						<th>Name</th>
						<th>Network</th>
						<th>Number Of Seasons</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="show" items="${searchedShows}">
						<tr>
							<td><c:out value="${show.name }" /></td>
							<td><c:out value="${show.network }" /></td>
							<td><c:out value="${show.numOfSeasons }" /></td>
							<td><a class="btn btn-primary" href="/edit/${show.id}/show">Edit</a>
								<form action="/delete/${show.id}/show" method="post">
									<input type="hidden" name="_method" value="delete"> <input
										class="btn btn-danger" type="submit" value="Delete">
								</form> <a class="btn btn-success" href="/view/${show.id}/show">View</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>