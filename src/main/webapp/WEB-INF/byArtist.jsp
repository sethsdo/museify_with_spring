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

			<h4>
				<a href="/create/new">Add New</a> |
				<a href="/search/topTen">Top </a>
			</h4>
			<form:form method="POST" action="/search">
				<input type='text' id="name" name='name'>
				<input type="submit" value="Search">
			</form:form>
			<table class="table">
				<c:forEach items="${songs}" var="song">
					<tr>
						<td>
							<a href="/song/${song.id}">
								<c:out value="${song.title}" />
							</a>
						</td>
						<td>
							<c:out value="${song.raiting}" />
						</td>
						<td>
							<a href="/song/delete/${song.id}">
								<ul>delete</ul>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>