<jsp:include page="/header.jsp"></jsp:include>
<title>Checkout - Shipping Address</title>

<body>


	<div class="well container">

		<!-- show the users cart info here
	so they know what they are buying -->
		<div class="row">
			<div class="col-xs-offset-3 col-xs-6 form-group">
				<h2>Purchase Summary:</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-offset-3 col-xs-6 form-group">
				<p>${cart.toString()}</p>
			</div>
		</div>
	</div>

	<div class="well container">

		<div class="row">
			<div class="col-xs-offset-3 col-xs-6 form-group">
				<h2>Enter Shipping Address</h2>
			</div>
			<div id="message" align="center">${errorMes}</div>
		</div>

		<form name="Enter Address" id="addressForm" method="post"
			action="CheckoutServlet">
			<div class="row">

				<div class="row">
					<div class="col-xs-offset-3 col-xs-5 form-group">
						<input type="radio" name="same-as-account" value="true">Same
						As Account Address<br>
					</div>
				</div>

				<div class="col-xs-offset-3 col-xs-6 form-group">
					<label for="street">Street Address</label> <input name="street"
						type="text" class="form-control" id="street" value="${street}"
						placeholder="Enter Street Address">
				</div>
			</div>

			<div class="row">
				<div class="col-xs-offset-3 col-xs-3 form-group">
					<label for="city">City</label> <input name="city" type="text"
						class="form-control" id="city" value="${city}"
						placeholder="Enter City">
				</div>

				<div class="col-xs-3 form-group">
					<label for="state">State</label> <input name="state" type="text"
						class="form-control" id="state" value="${state}"
						placeholder="Enter State">
				</div>

			</div>

			<div class="row">
				<div class="col-xs-offset-3 col-xs-3 form-group">
					<label for="zip">Zip</label> <input name="zip" type="text"
						class="form-control" id="zip" value="${zip}"
						placeholder="Enter ZipCode">
				</div>
			</div>

			<div class="row">
				<div class="col-xs-offset-3 col-xs-6 form-group">
					<h2>Select Shipping Type</h2>
				</div>
			</div>

			<!-- add cost of shipping to total -->
			<div class="row">
				<div class="col-xs-offset-3 col-xs-5 form-group">
					<input type="radio" name="shipping" value="0">Free Shipping
					(30+ days) <br>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-offset-3 col-xs-5 form-group">
					<input type="radio" name="shipping" value="1">Standard 1
					week shipping <br>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-offset-3 col-xs-5 form-group">
					<input type="radio" name="shipping" value="2">Expedited
					shipping <br>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-offset-3 col-xs-5 form-group">
					<input type="hidden" name="action" value="credit card">
					<button type="submit" id="submitBtn" name="submit"
						class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>