<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="edu.ben.model.User"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/admin/admin-header.jsp"></jsp:include>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="table-style.css">
<title>Users</title>
<style>
label {
	padding: 5px;
}
</style>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>

	<%
		User currentUser = (User) request.getSession().getAttribute("user");
	%>

	<div class="container">

		<jsp:include page="/admin/message-box.jsp"></jsp:include>

		<div class="row">
			<div class="col-lg-3">
				<h2 style="color: white;">Options</h2>
				<div class="well">
					<button class="btn w3-button w3-green" id="AddNewUserBtn"
						data-toggle="modal" data-target="#AddUser">Add New User</button>
					<button class="btn w3-button w3-red" id="ImportUserBtn"
						data-toggle="modal" data-target="#Import">Import From CSV
						File</button>
				</div>
			</div>

			<div class="col-lg-9">
				<h2 style="color: white;">Users</h2>
				<c:if test="${message != null}">
					<h4 style="color: white">(${message})</h4>
				</c:if>
				<table>
					<tr>
						<th>User ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Security Level</th>
						<th>Active/Deactive</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach var="tempUser" items="${userList}">
						<tr>
							<td>${tempUser.userID}</td>
							<td>${tempUser.firstName}</td>
							<td>${tempUser.lastName}</td>
							<td>${tempUser.email}</td>
							<td>${tempUser.admin}</td>
							<td>${tempUser.active}</td>

							<c:if test="${user.admin eq 2}">
								<td><a data-toggle="modal"
									data-target="#Edit${tempUser.userID}"
									style="cursor: pointer; text-decoration: none;">Edit</a></td>
								<td><a data-toggle="modal"
									data-target="#Delete${tempUser.userID}"
									style="cursor: pointer; text-decoration: none;">Deactivate</a></td>
							</c:if>

						</tr>
					</c:forEach>
				</table>

				<c:forEach var="tempUser" items="${userList}">

					<%@ include file="edit-user-modal.jsp"%>
					<%@ include file="delete-user-modal.jsp"%>

				</c:forEach>
			</div>
		</div>
	</div>

	<jsp:include page="/admin/user/add-user-modal.jsp"></jsp:include>
	<jsp:include page="/admin/user/import-user-modal.jsp"></jsp:include>

</body>
</html>