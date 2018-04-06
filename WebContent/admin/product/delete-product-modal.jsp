<div id="Delete${product.productID}" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h2>Delete</h2>
			</div>
			<div class="modal-body">
				<h4>Product: ${product.brand}</h4>
				<h4>Brand: ${product.model}</h4>
				<h5>Product ID: ${product.productID}</h5>
			</div>
			<form action="AdminProductServlet" method="post">
				<div class="modal-footer">
					<input type="hidden" name="action" value="delete"> <input
						type="hidden" name="productID" value="${product.productID}">

					<button type="submit" class="w3-button w3-red btn">Delete</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>