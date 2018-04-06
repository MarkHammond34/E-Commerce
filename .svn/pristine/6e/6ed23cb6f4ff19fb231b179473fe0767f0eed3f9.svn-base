<div id="Delete${tempUser.userID}" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h2>Deactivate</h2>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-lg-8">
						<h4>First Name: ${tempUser.firstName}</h4>
						<h4>Last Name: ${tempUser.lastName}</h4>
						<h5>Email: ${tempUser.email}</h5>
						<h5>User ID: ${tempUser.userID}</h5>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<form action="AdminUserServlet" method="post">
					<input type="hidden" name="action" value="delete"> <input
						type="hidden" name="userID" value="${tempUser.userID}">
					<button type="submit" class="w3-button w3-red btn">Deactivate</button>

					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</form>
			</div>
		</div>
	</div>
</div>