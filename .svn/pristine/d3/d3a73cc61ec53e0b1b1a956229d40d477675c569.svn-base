<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="edu.ben.model.User"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<link rel="stylesheet" href="css/custom.css">
<link type="text/css" rel="stylesheet"
	href="/HeadphonesAdmin/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
.search-bar {
	margin-top: 7px;
}

#navButtons {
	font-family: bookman;
}
</style>
</head>
<body>

	<%
		User user = (User) request.getSession().getAttribute("user");
	%>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<nav class="navbar navbar-inverse">
		<div class="row">
			<div class="navbar-header">
				<a class="navbar-brand" href="HomeServlet">Headphones</a>
			</div>
			<div class="search-bar col-xs-2">
				<form method="get" action="SearchBarServlet">
					<div class="input-group">
						<span class="input-group-btn">
							<button id="navButtons" class="btn btn-default" type="submit">Go!</button>
						</span> <input type="text" class="form-control" name="search"
							placeholder="Search for...">
					</div>
				</form>
			</div>

			<div class="col-xs-8">
				<form method="get" action="ProductServlet">
					<ul class="nav navbar-nav navbar-right">
						<li id="navButtons" class="dropdown"><a
							class="dropdown-toggle" data-toggle="dropdown" href="#">Brands
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="ProductServlet?value=beats">Beats</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="ProductServlet?value=bose">Bose</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="ProductServlet?value=sony">Sony</a></li>
							</ul></li>
						<li id="navButtons" class="dropdown"><a
							class="dropdown-toggle" data-toggle="dropdown" href="#">Style
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="ProductServlet?value=in-ear">In-Ear</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="ProductServlet?value=on-ear">On-Ear</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="ProductServlet?value=over-ear">Over-Ear</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="ProductServlet?value=wireless">Wireless</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="ProductServlet?value=wired">Wired</a></li>
							</ul></li>
						<li><a id="navButtons" href="build-headphones.jsp"><span
								class="glyphicon glyphicon-wrench"></span> Customize Headphones</a></li>
						<c:if test="${userSession != null}">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="LogoutServlet"><span
									class="glyphicon glyphicon-user"></span> Welcome,
									${userSession}<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<c:if test="${user.admin gt 0}">
										<li><a id="navButtons" href="AdminHomeServlet"><span
												class="glyphicon glyphicon-log-out"></span>Admin Site</a></li>
									</c:if>
									<li><a id="navButtons" href="LogoutServlet"><span
											class="glyphicon glyphicon-log-out"></span>Logout</a></li>
								</ul>
						</c:if>
						<c:if test="${userSession == null}">

							<li><a id="navButtons" href="login.jsp"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>
							<li><a id="navButtons" href="registration.jsp"><span
									class="glyphicon glyphicon-user"></span> Register</a></li>
						</c:if>

						<li><a id="navButtons" href="mycart.jsp"><span
								class="glyphicon glyphicon-shopping-cart"></span> Cart
								(${cart.size})</a></li>
					</ul>
				</form>
			</div>
		</div>
	</nav>

</body>
</html>
