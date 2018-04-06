<title>Order Confirmation</title>
<jsp:include page="/header.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="edu.ben.model.Cart"%>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-xs-offset-3 col-xs-5 form-group">

				<c:if test="${transaction != null }">
					<div class="panel panel-default">
						<div class="panel-heading text-center">
							<h4>Review Order</h4>
						</div>
						<div class="panel-body">
							<div class="col-md-12">
								<strong>Name</strong>
								<div class="pull-right">
									<span>${transaction.nameOnCreditCard}</span>
								</div>
							</div>

							<div class="col-md-12">
								<strong>Order Total</strong>
								<div class="pull-right">
									<span>$</span><span>${transaction.total}</span>
								</div>
							</div>
						</div>
					</div>
				</c:if>

				<c:if test="${transaction == null }">
					<h5>
						Congratulations, your payment has been processed with Paypal! <br>
						Check your email for tracking numbers and payment receipt. <br>
						You will receive an email when your order has shipped.
					</h5>
				</c:if>

				<%
					request.getSession().setAttribute("transaction", null);
				%>

			</div>
		</div>
	</div>


</body>
</html>