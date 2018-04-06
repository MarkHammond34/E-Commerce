<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ben.model.Cart"%>
<!DOCTYPE html>
<html lang=en>
<head>
<style>
.carousel .item {
	height: 400px;
}

.item img {
	height: 100% !important;
	width: 100% !important;
}
</style>

<link rel="stylesheet"
	href="/HeadphonesAdmin/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/custom.css">

<jsp:include page="/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<%
		if (request.getSession().getAttribute("cart") == null) {
			request.getSession().setAttribute("cart", new Cart());
		}
	%>

	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<a href="ProductServlet?value=beats" alt="Beats"> <img
						src="images/Beats/beatsbackground.jpg">
					</a>
				</div>

				<div class="item">
					<a href="ProductServlet?value=sony" alt="Sony"> <img
						src="images/Sony/sonybackground.jpg" alt="Sony">
					</a>

				</div>

				<div class="item">
					<a href="ProductServlet?value=bose" alt="Bose"> <img
						src="images/Bose/bosebackground.jpg" alt="Bose">
					</a>
				</div>
				<div class="item">
					<a href="build-headphones.jsp" alt="Bose"> <img
						src="images/addtext_com_MTUyMTI1MTIxNTM.jpg" alt="Bose">
					</a>
				</div>

			</div>

		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<br>
	<div class="container">
		<p class="headphone-header" align="left">Most Recent:</p>
		<br>
		<div class="row">
			<c:forEach var="product" items="${mostRecent}">
				<div class="col-xs-4">
					<div class="container center">
						<div class="w3-card-4 w3-dark-grey" style="width: 30%">
							<div class="w3-container w3-center">
								<h3>${product.brand}${product.model}</h3>
								<img src="images/${product.brand}/${product.model}.jpg"
									alt="Headphone" width="250" height="250">
								<h5>Description</h5>

								<div class="w3-section">
									<form action="cart" method="post">
										<input type="hidden" name="productBrand"
											value="${product.brand}"> <input type="hidden"
											name="productModel" value="${product.model}"> <input
											type="hidden" name="productPrice" value="${product.price}">
										<input type="hidden" name="productQty" value="1"> <input
											type="hidden" name="productID" value="${product.productID}">

										<button class="w3-button w3-green" name="submit">Add
											to Cart</button>
										<button type="button" class="w3-button w3-red"
											data-toggle="modal" data-target="#${product.productID}">Extended
											View</button>
									</form>
								</div>
							</div>
						</div>
						<div id="${product.productID}" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">${product.model}</h4>
									</div>
									<div class="modal-body">
										<div class="row">
											<div class="col-xs-6">
												<img src="images/${product.brand}/${product.model}.jpg"
													alt="Headphone" width="250" height="250">
											</div>
											<div class="col-xs-6">
												<h3>Product ID: ${product.productID}</h3>
												<p>Description goes here</p>
												<p>Product price: ${product.price}</p>
												<p>Quantity</p>
												<div class="row">
													<div class="col-xs-6">
														<form action="cart" method="post">
															<!-- select qty from extended view -->
															<select class="form-control" name="productQty">
																<option value="1">1</option>
																<option value="2">2</option>
																<option value="3">3</option>
															</select>
													</div>
													<div class="col-xs-6">
														<!-- add these values to form so that you can submit to cart -->
														<input type="hidden" name="productBrand"
															value="${product.brand}"> <input type="hidden"
															name="productModel" value="${product.model}"> <input
															type="hidden" name="productPrice"
															value="${product.price}"> <input type="hidden"
															name="productID" value="${product.productID}">
														<button class="w3-button w3-green" name="submit">Add
															to Cart</button>
														</form>
														<!-- leave form end tag here! for submit button to work
																	yeah i know it looks weird with intersecting tags -->
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<br>
		<p class="headphone-header" align="left">Most Popular:</p>
		<br>
		<div class="row">
			<c:forEach var="product" items="${mostPopular}">
				<div class="col-xs-4">
					<div class="container center">
						<div class="w3-card-4 w3-dark-grey" style="width: 30%">
							<div class="w3-container w3-center">
								<h3>${product.brand}${product.model}</h3>
								<img src="images/${product.brand}/${product.model}.jpg"
									alt="Headphone" width="250" height="250">
								<h5>Description</h5>

								<div class="w3-section">
									<form action="cart" method="post">
										<input type="hidden" name="productBrand"
											value="${product.brand}"> <input type="hidden"
											name="productModel" value="${product.model}"> <input
											type="hidden" name="productPrice" value="${product.price}">
										<input type="hidden" name="productQty" value="1"> <input
											type="hidden" name="productID" value="${product.productID}">

										<button class="w3-button w3-green" name="submit">Add
											to Cart</button>
										<button type="button" class="w3-button w3-red"
											data-toggle="modal" data-target="#${product.productID}">Extended
											View</button>
									</form>
								</div>
							</div>
						</div>
						<div id="${product.productID}" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">${product.model}</h4>
									</div>
									<div class="modal-body">
										<div class="row">
											<div class="col-xs-6">
												<img src="images/${product.brand}/${product.model}.jpg"
													alt="Headphone" width="250" height="250">
											</div>
											<div class="col-xs-6">
												<h3>Product ID: ${product.productID}</h3>
												<p>Description goes here</p>
												<p>Product price: ${product.price}</p>
												<p>Quantity</p>
												<div class="row">
													<div class="col-xs-6">
														<form action="cart" method="post">
															<!-- select qty from extended view -->
															<select class="form-control" name="productQty">
																<option value="1">1</option>
																<option value="2">2</option>
																<option value="3">3</option>
															</select>
													</div>
													<div class="col-xs-6">
														<!-- add these values to form so that you can submit to cart -->
														<input type="hidden" name="productBrand"
															value="${product.brand}"> <input type="hidden"
															name="productModel" value="${product.model}"> <input
															type="hidden" name="productPrice"
															value="${product.price}"> <input type="hidden"
															name="productID" value="${product.productID}">
														<button class="w3-button w3-green" name="submit">Add
															to Cart</button>
														</form>
														<!-- leave form end tag here! for submit button to work
																	yeah i know it looks weird with intersecting tags -->
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- wow so many divs -->
	</div>

</body>
</html>