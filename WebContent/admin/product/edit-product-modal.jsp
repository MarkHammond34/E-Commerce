<div id="Edit${product.productID}" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h2>Edit</h2>
				<h4>Product: ${product.brand}</h4>
				<h4>Brand: ${product.model}</h4>
				<h5>Product ID: ${product.productID}</h5>
			</div>

			<form action="AdminProductServlet" method="post">
				<div class="row">
					<div class="col-lg-1"></div>
					<div class="col-lg-10">
						<div class="modal-body">
							<div class="form-group">
								<label>Brand</label><input type="text" name="brand"
									value="${product.brand}" required>
							</div>
							<div class="form-group">
								<label>Model</label><input type="text" name="model"
									value="${product.model}" required>
							</div>
							<div class="form-group">
								<label>Style</label> <select name="style" required>
									<option value="over-ear">Over Ear</option>
									<option value="on-ear">On Ear</option>
									<option value="in-ear">In Ear</option>
								</select>
							</div>
							<div class="form-group">
								<label>Technology</label><select name="tech" required>
									<option value="wireless">Wireless</option>
									<option value="wired">Wired</option>
								</select>
							</div>
							<div class="form-group">
								<label>Price</label><input type="text" name="price"
									value="${product.price}" required>
							</div>
							<div class="form-group">
								<label>Active</label> <select name="active" required>
									<option value="0">Inactive</option>
									<option value="1">Active</option>
								</select>
							</div>
							<div class="form-group">
								<label>Description</label>
								<textarea class="form-control" name="desc" required>${product.description}</textarea>
							</div>

							<input type="hidden" name="action" value="edit"> <input
								type="hidden" name="productID" value="${product.productID}">
						</div>
					</div>
					<div class="col-lg-1"></div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="w3-button w3-red btn">Submit
						Changes</button>

					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>
