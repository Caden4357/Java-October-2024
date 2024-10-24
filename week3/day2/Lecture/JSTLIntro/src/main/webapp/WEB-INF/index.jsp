<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>JSTL Tags And More</h1>
		<h1>A list of teams</h1>
		<ul>
			<c:forEach items="${teamsFromBackend}" var="team">
				<c:choose>
					<c:when test="${team=='Celtics'}">
						<li>
							<c:out value="Current Champs" />
						</li>
					</c:when>
					<c:otherwise>
						<li><c:out value="${team}" /></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
		<form action="/guess/number" method="post">
			<label>Guess the number of the day</label>
			<input type="text" placeholder="lucky number..." name="luckyNumber"/>
			<button>Guess</button>
		</form>
		<a href="/session">Go To Session Intro Page</a>
	</div>
</body>
</html>