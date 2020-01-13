<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/style.css">
<script src="js/script.js"></script>
<title>Favorites</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movieCruiser-logo.png"> <a href="ShowFavorites">Favorites</a>
		<a href="ShowMovieListCustomer">Movies</a>
	</div>
	<div class="page-title">Favorites</div>
	<c:if test="${deleteFavoritesStatus}">
		<div class="success-message">Items removed from Favorites
			successfully</div>
	</c:if>
	<table class="table" id="tableID">
		<tr>
			<th>Name</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th></th>
		</tr>
		<c:forEach items="${favorites.movieList}" var="movies">
			<tr>
				<td>${movies.name}</td>
				<td class=" currency">$.<fmt:formatNumber
						value="${movies.gross}" pattern="#,##,##,##,###.00" />
				</td>
				<td>${movies.genre}</td>
				<td><a href="RemoveFavorites?id=${movies.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td><h4>No. of Favorites:</h4></td>
			<td><h4>${favorites.total}</h4></td>
			<td></td>
		</tr>		
	</table>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>