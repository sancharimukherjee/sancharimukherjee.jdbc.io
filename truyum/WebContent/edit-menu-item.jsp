<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truyum</div>
		<img src="images/truyum-logo-dark.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>

	<div class="page-title">Edit Menu Item</div>
	<div class="body-content-colour">
		<form action="EditMenuItem" onsubmit="return validateeditMenu()"
			name="menuItemform" method="post">
			<div>
				<div class="form-field-spacing">

					<label for="name">Name</label>
					<div>
						<input type="text" class="text-box text-box-title" name="name"
							id="name" value="${menuItem.name}">
					</div>
				</div>
			</div>


			<div>
				<div class="form-field-spacing">

					<label for="price">Price</label>
					<div>
						<input type="text" class="text-box" name="price" id="price"
							value="${menuItem.price}">
					</div>
				</div>

				<div class="form-field-spacing">
					<label for="inStock">Active</label> <input class="radio"
						type="radio" name="inStock" value="yes"
						<c:if test="${menuItem.active}">checked</c:if>>Yes
					<!--   <input class="radio" type="radio" name="inStock" value="no">no 
                       <input class="radio" type="radio" name="inStock" value="yes" >yes-->
					<input class="radio" type="radio" name="inStock" value="no"
						<c:if test="${!menuItem.active}">checked</c:if>>No

				</div>
				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date of Launch</label>
					<div>
						<input type="text" class="text-box" name="dateOfLaunch"
							value=<fmt:formatDate value="${menuItem.dateOfLaunch}"
						pattern="dd/MM/yyyy"/>>
					</div>
				</div>

				<div class="form-field-spacing">
					<label for="category">Category</label>
					<div>
						<select name="category" class="dropdown">
							<option value="${menuItem.category}">${menuItem.category}</option>
							<option value="Starters">Starters</option>
							<option value="Main Course">Main Course</option>
							<option value="Dessert">Dessert</option>
							<option value="Drinks">Drinks</option>
						</select>
					</div>
				</div>
			</div>

			<div class="form-field-spacing">
				<c:if test="${menuItem.freeDelivery}">
					<input type="checkbox" name="freeDelivery" checked>
				</c:if>
				<c:if test="${!menuItem.freeDelivery}">
					<input type="checkbox" name="freeDelivery">
				</c:if>
				<label for="free delivery">Free Delivery</label>
			</div>
			<div>
				<input type="hidden" name="id" value="${menuItem.id}">
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