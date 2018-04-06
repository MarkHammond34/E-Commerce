<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang=en>
<head>
<style>
.nav-tabs>li {
	float: none;
	display: inline-block;
	zoom: 1;
}

.nav-tabs {
	text-align: center;
}

#message {
	color: red;
}
</style>
<jsp:include page="/header.jsp"></jsp:include>
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login</title>
</head>
<body>
	<div class="well container">

		<jsp:include page="/admin/message-box.jsp"></jsp:include>

		<div class="row">
			<!-- Start Form -->
			<br>
			<div id="message" align="center">${message}</div>
			<div>
				<form name="loginForm" id="contactform" method="post"
					action="ResetPasswordServlet">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<div class="form-group">
								<label>Enter Your Email</label> <br> <input name="email"
									type="text"> <input type="hidden" name="action"
									value="reset">
								<button type="submit">Next</button>
							</div>
						</div>
					</div>
				</form>
				<!-- End Form -->
			</div>
		</div>
	</div>
</body>
</html>