<title>Checkout - Enter Credit Card</title>
<jsp:include page="/header.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="/purchase-summary.jsp"></jsp:include>

	<div class="well container">
	<div id="message" align="center">${errorMes}</div>
		<!-- form for credit card info -->
		<form name="Credit Card Info" id="credit-card-info" method="post"
			action="CheckoutServlet">
			<div class="row">
				<div class="col-xs-offset-3 col-xs-5 form-group">
					<label for="name">Name on Card: </label> <input name="name"
						type="text" class="form-control" id="name"
						placeholder="Enter name on card">

				</div>
			</div>

			<div class="row">
				<div class="col-xs-offset-3 col-xs-5 form-group">

					<label for="card">Card number: </label> <input name="card number"
						type="text" class="form-control" id="card number"
						placeholder="Enter Card Number">
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