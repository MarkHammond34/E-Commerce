<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
body {
	background: white !important;
}
</style>

<script>
	function goBack() {
		window.history.back()
	}
</script>

<jsp:include page="/header.jsp"></jsp:include>
<title>Cart</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-10 col-md-offset-1">
				<table class="table table-hover">
					<c:if test="${cart == null || cart.size == 0}">
						<h1>Your Cart is empty.</h1>
					</c:if>

					<c:if test="${cart.size > 0}">
						<thead>
							<tr>
								<th>Product</th>
								<th>Quantity</th>
								<th class="text-center">Price</th>
								<th class="text-center">Total</th>
								<th> </th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${cart.cart}">
								<tr>
									<td class="col-sm-8 col-md-6">
										<div class="media">
											<a class="thumbnail pull-left" href="#"> <img
												class="media-object"
												src="images/${product.brand}/${product.model}.jpg"
												style="width: 72px; height: 72px;"></a>
											<div class="media-body">
												<h4 class="media-heading">
													<a href="#">${product.model}</a>
												</h4>
												<h5 class="media-heading">
													by <a href="#">${product.brand}</a>
												</h5>
												<span>Status: </span><span class="text-success"><strong>In
														Stock</strong></span>
											</div>
										</div>
									</td>
									<td class="col-sm-1 col-md-1 text-center"><strong>${cart.cartQty.get(product)}</strong></td>
									<td class="col-sm-1 col-md-1 text-center"><strong>$${product.price}</strong></td>
									<td class="col-sm-1 col-md-1 text-center"><strong>$14.61</strong></td>
									<td class="col-sm-1 col-md-1">
										<!-- remove item from cart -->
										<form action="delete" method="post">
											<input type="hidden" name="prodID"
												value="${product.productID}">
											<button type="submit" class="btn btn-danger" name="prodID">
												<span class="glyphicon glyphicon-remove"></span> Remove
											</button>
										</form>

									</td>
								</tr>
							</c:forEach>
							<tr>
								<td> </td>
								<td> </td>
								<td> </td>
								<td><h5>Subtotal</h5></td>
								<td class="text-right"><h5>
										<strong>$24.59</strong>
									</h5></td>
							</tr>
							<tr>
								<td> </td>
								<td> </td>
								<td> </td>
								<td><h5>Estimated shipping</h5></td>
								<td class="text-right"><h5>
										<strong>$6.94</strong>
									</h5></td>
							</tr>
							<tr>
								<td> </td>
								<td> </td>
								<td> </td>
								<td><h3>Total</h3></td>
								<td class="text-right"><h> <strong>$31.53</strong>
									</h3></td>
							</tr>
							<tr>
								<td> </td>
								<td> </td>
								<td> </td>
								<td>
									<button type="button" class="btn btn-default"
										onclick="goBack()">
										<span class="glyphicon glyphicon-shopping-cart"></span>
										Continue Shopping
									</button>
								</td>
								<td><c:if test="${userSession != null}">
										<!-- let the user checkout -->
										<form action="CheckoutServlet" method="get">
											<input type="hidden" name="action" value="start-checkout">
											<button type="submit" class="btn btn-success">
												Checkout <span class="glyphicon glyphicon-play"></span>
											</button>
										</form>
										<!-- paypal btn also goes here -->
										<c:set var="count" value="1" scope="page" />
										<form target="paypal"
											action="https://www.sandbox.paypal.com/cgi-bin/webscr"
											method="post">
											<input type="hidden" name="cmd" value="_cart"><input
												type="hidden" name="upload" value="1"><input
												type="hidden" name="return"
												value="http://localhost:8080/HeadphonesWebsite/order-confirmation.jsp"><input
												type="hidden" name="business"
												value="saaniyaattar-facilitator@gmail.com">
											<c:forEach var="product" items="${cart.cart}">

												<!-- add to paypal hidden form as well -->
												<input type="hidden" name="item_name_${count}"
													value="${product.model}">
												<input type="hidden" name="amount_${count}" value="11">
												<input type="hidden" name="quantity_${count}"
													value="${cart.cartQty.get(product)}"> <!-- increment count var -->
												<c:set var="count" value="${count+1}" scope="page" />
											</c:forEach>

											<!--  align this button to the right somehow -->
											<input type="image"
												src="https://www.sandbox.paypal.com/en_US/i/btn/btn_buynow_LG.gif"
												border="0" name="submit"
												alt="PayPal - The safer, easier way to pay online!"><img
												alt="" border="0"
												src="https://www.sandbox.paypal.com/en_US/i/scr/pixel.gif"
												width="1" height="1">
										</form>
									</c:if></td>
							</tr>
						</tbody>
					</c:if>
				</table>

				<!-- put this all the way to the right -->
				<c:if test="${cart.size > 0 && userSession == null}">
					<div class="text-right">
						<br> <!-- awkwawrd alignment??-->
						<a href="/HeadphonesWebsite/login.jsp">Login to complete your
							checkout</a>
					</div>
				</c:if>
			</div>
		</div>
	</div>

</body>
</html>