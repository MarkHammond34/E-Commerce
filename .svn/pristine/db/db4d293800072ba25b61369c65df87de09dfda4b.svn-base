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
<title>Register</title>
</head>
<body>

	<div class="well container">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#home" data-toggle="tab">Register</a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane active in" id="home">
				<!-- Start Form -->
				<br>
				
				<div id="message" align="center">${errorMes}</div>
				
				<div>
					<form name="RegistrationForm" id="contactform" method="post"
						action="RegistrationServlet">
						<div class="row">
							<div class="col-xs-4 form-group">
								<label for="firstname">First Name:</label> <input
									name="firstname"
									<%if (request.getParameter("firstname") != null) {%>
									value="<%=request.getParameter("firstname")%>" <%}%>
									type="text" class="form-control" id="firstname"
									placeholder="Enter first name" required>
							</div>

							<div class="col-xs-4 form-group">
								<label for="lastname">Last Name:</label> <input name="lastname"
									<%if (request.getParameter("lastname") != null) {%>
									value="<%=request.getParameter("lastname")%>" <%}%> type="text"
									class="form-control" id="lastname"
									placeholder="Enter last name" required>
							</div>
							<div class="col-xs-4 form-group">
								<label for="email">Email:</label> <input name="email"
									<%if (request.getParameter("email") != null) {%>
									value="<%=request.getParameter("email")%>" <%}%> type="email"
									class="form-control" id="email" placeholder="Enter email"
									required>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-4 form-group">
								<label for="password">Password:</label> <input name="password"
									<%if (request.getParameter("password") != null) {%>
									value="<%=request.getParameter("password")%>" <%}%>
									type="password" class="form-control" id="password"
									placeholder="Enter password" required>
							</div>
							<div class="col-xs-4 form-group">
								<label for="pwd-confirm">Confirm Password:</label> <input
									name="pass-confirm" value="" type="password"
									class="form-control" id="pwd-confirm"
									placeholder="Confirm password" required>
							</div>
							<div class="col-xs-4"></div>
						</div>

						<!-- Address  -->
						<div class="row">

							<div class="col-xs-2 form-group">
								<label for="strAddr">Street Address: </label> <input
									name="street" type="text" class="form-control" id="street"
									placeholder="Enter Street" required>
							</div>
							<div class="col-xs-2 form-group">
								<label for="city">City: </label> <input name="city" type="text"
									class="form-control" id="city" placeholder="Enter City"
									required>
							</div>
							<div class="col-xs-2 form-group">
								<label for="state">State: </label> <input name="state"
									type="text" class="form-control" id="state"
									placeholder="Enter State" required>
							</div>
							<div class="col-xs-2 form-group">
								<label for="zip">Zip: </label> <input name="zip" type="text"
									class="form-control" id="zip" placeholder="Enter Zipcode"
									required>
							</div>
							
						</div>
						<br>

						<div class="row">
							<div class="col-xs-5"></div>
							<div class="col-xs-2">
								<button type="submit" id="submitBtn" name="submit"
									class="btn btn-default">Submit</button>
							</div>
							<div class="col-xs-5"><p>Already have an account? <a href = "login.jsp" >Login</a></p>
							</div>
						</div>

					</form>
					<!-- End Form -->
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	var password = document.getElementById("password");
	var confirm_password = document.getElementById("pwd-confirm");

	function validatePassword() {
		if (password.value != confirm_password.value) {
			confirm_password.setCustomValidity("Passwords Don't Match");
		} else {
			confirm_password.setCustomValidity('');
		}
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
</script>
</html>