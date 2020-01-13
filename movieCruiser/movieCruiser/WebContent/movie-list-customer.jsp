<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie List Customer</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movieCruiser-logo.png"> <a href="ShowFavorites">Favorites</a>
		<a href="ShowMovieListCustomer">Movies</a>
	</div>
	<div class="page-title">Movies</div>
	<c:if test="${addFavoritesStatus}">
		<div class="success-message">Item added to Favorites
			successfully</div>
	</c:if>
	<table class="table">
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${movieList}" var="movies">
			<tr>
				<td>${movies.name}</td>
				<td class="currency">$.<fmt:formatNumber
						value="${movies.gross}" /></td>
				<td>${movies.genre}</td>
				<td><c:if test="${movies.hasTeaser}">Yes</c:if> <c:if
						test="${!movies.hasTeaser}">No</c:if></td>
				<td><a href="AddToFavorites?id=${movies.id}">Add to
						Favorites</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>