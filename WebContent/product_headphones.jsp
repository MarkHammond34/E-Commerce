<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Sony Headphones</title>
</head>

<style>
.col-xs-4 {
	margin-top: 10px;
}
</style>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container">
			<p class="headphone-header" align="left">${message}</p>
		<br>
		<div class="row">
			<c:forEach var="product" items="${productList}">
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