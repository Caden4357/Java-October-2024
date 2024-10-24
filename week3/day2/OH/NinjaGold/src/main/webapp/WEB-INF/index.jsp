<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<h1 class="header-title">Ninja Gold</h1>
		<h2 class="text-primary">Your Gold: <c:out value="${gold}"/> </h2>
		<div class="d-flex justify-content-between">
			<form action="/take/turn"
				class="border border-2 border-secondary p-3">
				<h3>Farm</h3>
				<p>Earn 10-20 gold</p>
				<button>Find Gold</button>
			</form>
			<form action="/take/turn"
				class="border border-2 border-secondary p-3">
				<h3>Cave</h3>
				<p>Earn 5-10 gold</p>
				<button>Find Gold</button>
			</form>
			<form action="/take/turn"
				class="border border-2 border-secondary p-3">
				<h3>House</h3>
				<p>Earn 2-5 gold</p>
				<button>Find Gold</button>
			</form>
			<form action="/take/turn"
				class="border border-2 border-secondary p-3">
				<h3>Quest</h3>
				<p>Earn/loose up to 50 gold</p>
				<button>Go on quest</button>
			</form>
		</div>
		
		<div class="border border-2 border-secondary p-2 mt-5">
			<h2>Activities</h2>
		</div>
	</div>
</body>
</html>