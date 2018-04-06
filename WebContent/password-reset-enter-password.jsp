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
		<ul class="nav nav-tabs">
			<li class="active"><a href="#home" data-toggle="tab">Login</a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane active in" id="home">
				<!-- Start Form -->
				<br>
				<div id="message" align="center">${message}</div>
				<div id="message" align="center">${errorMessage}</div>
				<div>
					<form name="loginForm" id="contactform" method="post"
						action="ResetPasswordServlet">
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4">
								<div class="form-group">
									<label>Enter Your New Password</label> <br> <input
										name="newPassword" type="text"> <br> <label>Reenter
										Your New Password</label> <br> <input name="newPasswordConfirm"
										type="text"><input type="hidden" name="action"
										value="check-password"> <input type="hidden"
										name="userEmail" value="${userEmail}">
								</div>
								<div class="form-group">
									<button type="submit">Next</button>
								</div>
							</div>
						</div>
					</form>
					<!-- End Form -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>