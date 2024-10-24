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
		<h1>Session Intro</h1>
		<h2>
			Lucky Number Of The Day:
			<c:out value="${luckyNumber}" />
		</h2>
		<h2>
			Guess:
			<c:out value="${guess}" />
		</h2>

		<c:if test="${guess==luckyNumber}">
			<p>
				<c:out value="You got it!" />
			</p>
		</c:if>
		<c:if test="${guess!=luckyNumber}">
			<p>
				<c:out value="Try again." />
			</p>
		</c:if>
		<a href="/">Go Back</a>
	</div>
</body>
</html>