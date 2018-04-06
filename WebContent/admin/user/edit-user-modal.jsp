<div id="Edit${tempUser.userID}" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h2>Edit</h2>
			</div>

			<form action="AdminUserServlet" method="post">
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-2"></div>
						<div class="col-lg-8">
							<label>First Name</label><input type="text" name="firstName"
								value="${tempUser.firstName}" required> <br> <label>Last
								Name</label><input type="text" name="lastName"
								value="${tempUser.lastName}" required> <br> <label>Email</label><input
								type="text" name="email" value="${tempUser.email}" required>
							<br> <label>Security Level</label> <select name="admin"
								required>
								<option value="0">User</option>
								<option value="1">Admin</option>
								<option value="2">Developer</option>
							</select> <br> <label>Actice</label> <select name="active" required>
								<option value="0">Deactive</option>
								<option value="1">Active</option>
							</select> <input type="hidden" name="action" value="edit"> <input
								type="hidden" name="userID" value="${tempUser.userID}">
							<input type="hidden" name="password" value="${tempUser.password}">
							<input type="hidden" name="failedAttempts"
								value="${tempUser.failedAttempts}"> <input type="hidden"
								name="lastLogin" value="${tempUser.lastLogin}">
						</div>
						<div class="col-lg-2"></div>
					</div>
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