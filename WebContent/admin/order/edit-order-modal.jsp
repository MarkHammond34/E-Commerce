<div id="Edit${order.orderID}" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h2>Edit</h2>
				<h4>${order.orderID}</h4>
			</div>

			<form action="AdminOrderServlet" method="post">
				<div class="row">
					<div class="col-lg-1"></div>
					<div class="col-lg-10">
						<div class="modal-body">
							<div class="form-group">
								<label>Order Date</label><input type="text" name="orderDate"
									value="${order.orderDate}" required>
							</div>
							<div class="form-group">
								<label>Ship Date</label><input type="text" name="shipDate"
									value="${order.shipDate}" required>
							</div>
							<div class="form-group">
								<label>Active</label> <select name="active" required>
									<option value="0">Inactive</option>
									<option value="1">Active</option>
								</select>
							</div>
							<input type="hidden" name="action" value="edit"> <input
								type="hidden" name="orderID" value="${order.orderID}"> <input
								type="hidden" name="userID" value="${order.userID}"> <input
								type="hidden" name="originalShipDate" value="${order.shipDate}">
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