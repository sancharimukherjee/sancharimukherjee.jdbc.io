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
<title>MenuItem</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truyum</div>
		<img src="images/truyum-logo-dark.png"> <a
			href="ShowMenuItemListCustomer">Menu</a>
		<a href="ShowCart">Cart</a>
	</div>

	<div class="cart">
		<h1>Cart</h1>
		<div class="editMenuItemStatus">
			No Item in Cart.Use 'Add to Cart' option in <a
				href="ShowMenuItemListCustomer">Menu
				Item List</a>
		</div>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>