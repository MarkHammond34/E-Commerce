<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="edu.ben.model.User"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/custom.css">
<link type="text/css" rel="stylesheet"
	href="/HeadphonesAdmin/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="admin/table-style.css">
<link rel="stylesheet" href="css/admin.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
.search-bar {
	margin-top: 7px;
}
</style>
</head>
<body>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<nav class="navbar navbar-default">
		<div class="row">
			<div class="navbar-header">
				<a class="navbar-brand" href="">Headphones Admin</a>
			</div>
			<div class="col-xs-8">
				<ul class="nav navbar-nav navbar-right">

					<c:if test="${userSession != null}">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="LogoutServlet"><span
								class="glyphicon glyphicon-user"></span> Welcome, ${userSession}<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a id="navButtons" href="LogoutServlet"><span
										class="glyphicon glyphicon-log-out"></span>Logout</a></li>
							</ul>
					</c:if>
					<li><a id="navButtons" href="AdminUserServlet"><span
							class=""></span>Users</a></li>
					<li><a id="navButtons" href="AdminProductServlet"><span
							class=""></span>Products</a></li>
					<li><a id="navButtons" href="AdminOrderServlet"><span
							class=""></span>Orders</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>
