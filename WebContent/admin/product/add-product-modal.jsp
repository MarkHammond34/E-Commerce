<div id="AddProduct" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h2>Add New Product</h2>
			</div>
			<form action="AdminProductServlet" method="post">
				<div class="row">
					<div class="col-lg-1"></div>
					<div class="col-lg-10">
						<div class="modal-body">
							<div class="form-group">
								<label>Brand</label><input type="text" name="brand" required>
							</div>
							<div class="form-group">
								<label>Model</label><input type="text" name="model" required>
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
								<label>Price ($0 - $1000)</label><input type="text" name="price"
									min="0" max="1000" required>
							</div>
							<div class="form-group">
								<label>Description</label>
								<textarea class="form-control" name="desc" max="200" required>Less Than 200 Characters</textarea>
							</div>
							<input type="hidden" name="action" value="create">
						</div>
					</div>
					<div class="col-lg-1"></div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="w3-button w3-green btn">Submit</button>

					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>