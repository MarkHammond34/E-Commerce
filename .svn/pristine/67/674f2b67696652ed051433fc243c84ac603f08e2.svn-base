<div id="ViewProducts${order.orderID}" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h2>Products</h2>
			</div>

			<form action="AdminOrderServlet" method="post">
				<div class="row">
					<div class="col-lg-1"></div>
					<div class="col-lg-10">
						<div class="modal-body">
							<table>
								<tr>
									<th>Product ID</th>
									<th>Brand</th>
									<th>Model</th>
									<th>Price</th>
									<th>Quantity</th>
									<th></th>
								</tr>
								<c:forEach var="product" items="${order.products}">
									<tr>
										<td>${product.productID}</td>
										<td>${product.brand}</td>
										<td>${product.model}</td>
										<td>${product.price}</td>

										<c:if test="${user.admin eq 2 && order.shipped eq false}">
											<td><input type="number" max="10" min="0"
												name="quantity" value="${product.quantity}" required></td>
											<td><button type="submit">Submit</button></td>
											<input type="hidden" name="action" value="edit-order-product">
											<input type="hidden" name="orderID" value="${order.orderID}">
											<input type="hidden" name="productID"
												value="${product.productID}">
										</c:if>

										<c:if test="${user.admin eq 1 || order.shipped eq true}">
											<td>${product.quantity}</td>
											<td></td>
										</c:if>

									</tr>

								</c:forEach>
							</table>
						</div>
					</div>
					<div class="col-lg-1"></div>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>