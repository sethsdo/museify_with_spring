<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	</head>

	<body>
		<div class="container">
			<h4><a href="/dashboard">Dashboard</a></h4>
			<hr>
			<form:form method="POST" action="/add/new" modelAttribute="song">
				<form:label path="title">Title
					<form:errors path="title" />
					<form:input path="title" />
				</form:label><br>
			
				<form:label path="artist">Artist
					<form:errors path="artist" />
					<form:input path="artist" /></form:label><br>
			
				<form:label path="raiting">Raiting
					<form:errors path="raiting" />
					<form:select path="raiting">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option> 
						<option value="5">5</option>
					</form:select>
				</form:label><br>
			
				<input type="submit" value="Submit" />
			</form:form>
		</div>
	</body>
</html>