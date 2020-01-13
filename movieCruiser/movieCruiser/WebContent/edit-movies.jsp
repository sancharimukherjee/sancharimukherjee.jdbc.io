<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movieCruiser-logo.png"> <a href="ShowMovieListAdmin">Movies</a>
	</div>
	<h3 class="b">Edit Movie</h3>
	<div class="body-content-colour">
		<form action="EditMovie" onsubmit="return validateForm()"
			name="editMovie" method="post">
			<div>
				<div class="form-field-spacing">

					<label for="name">Name</label>
					<div>
						<input type="text" class="text-box text-box-title" name="title"
							value="${movies.name}">
					</div>
				</div>
			</div>
			<div>
				<div class="form-field-spacing">

					<label for="gross">Gross($)</label>
					<div>
						<input type="text" class="text-box" name="gross" id="gross"
							value="${movies.gross}">
					</div>
				</div>
				<div class="form-field-spacing">
					<label for="inStock">Active</label>
					<div>
						<input class="radio" type="radio" name="inStock" value="yes"
							<c:if test="${movies.active}">checked</c:if>>Yes <input
							class="radio" type="radio" name="inStock" value="no"
							<c:if test="${!movies.active}">checked</c:if>>No
					</div>
				</div>
				<div class="form-field-spacing">
					<label for="">Date of Launch</label>
					<div>
						<input type="text" class="text-box" name="dateOfLaunch"
							value=<fmt:formatDate value="${movies.dateOfLaunch}"
						pattern="dd/MM/yyyy"/>>
					</div>
				</div>
				<div class="form-field-spacing">
					<label for="genre">Genre</label>
					<div>
						<select name="genre" class="dropdown">
							<option value="${movies.genre}">${movies.genre}</option>
							<option value="Science Fiction">Science Fiction</option>
							<option value="Superhero">Superhero</option>
							<option value="Romance">Romance</option>
							<option value="Comedy">Comedy</option>
							<option value="Adventure">Adventure</option>
							<option value="Thriller">Thriller</option>
						</select>
					</div>
				</div>
			</div>
			<div class="form-field-spacing">
				<c:if test="${movies.hasTeaser}">
					<input type="checkbox" name="hasTeaser" checked>
				</c:if>
				<c:if test="${!movies.hasTeaser}">
					<input type="checkbox" name="hasTeaser">
				</c:if>
				<label for="hasTeaser">Has Teaser</label>
			</div>
			<div>
				<input type="hidden" name="id" value="${movies.id}">
			</div>
			<div>
				<input type="submit" class="button success-button" value="Save">
			</div>
		</form>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>