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
				<div>
					<form name="loginForm" id="contactform" method="post"
						action="LoginServlet">
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4 form-group">
								<label for="email">Email:</label> <input name="email"
									<%if (request.getParameter("email") != null) {%>
									value="<%=request.getParameter("email")%>" <%}%> type="email"
									class="form-control" id="email" placeholder="Enter email"
									required>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-4"></div>
							<div class=" col-xs-4 form-group">
								<label for="pwd">Password:</label> <input name="password"
									<%if (request.getParameter("user-pass") != null) {%>
									value="<%=request.getParameter("user-pass")%>" <%}%>
									type="password" class="form-control" id="pwd"
									placeholder="Enter password" required>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-2">
								<button type="submit" id="submitBtn" name="submit"
									class="btn btn-default">Submit</button>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4">
								<p>
									<br>Don't have an account? <a href="registration.jsp">Register
										now!</a>
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4">
								<a href="password-reset.jsp">Forgot Password</a>
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