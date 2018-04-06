<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="edu.ben.model.User"
	import="edu.ben.model.Product"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/admin/admin-header.jsp"></jsp:include>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.message-box {
	border-radius: 10px;
}
</style>
<body>

	<%
		User user = (User) request.getSession().getAttribute("user");
	%>

	<div class="container">

		<jsp:include page="/admin/message-box.jsp"></jsp:include>

		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
				<h2 style="color: white;">Orders</h2>
				<c:if test="${message != null}">
					<h4 style="color: white">${message}</h4>
				</c:if>
				<table>
					<tr>
						<th>Order ID</th>
						<th>Order Date</th>
						<th>Shipped</th>
						<th>Ship Date</th>
						<th>Active</th>
						<th>Products</th>
						<th></th>
						<th></th>
					</tr>

					<c:forEach var="order" items="${orderList}">
						<tr>
							<td>${order.orderID}</td>
							<td>${order.orderDate}</td>
							<td>${order.shipped}</td>
							<td>${order.shipDate}</td>
							<td>${order.active}</td>

							<td><a data-toggle="modal"
								data-target="#ViewProducts${order.orderID}"
								style="cursor: pointer; text-decoration: none;">View
									Products</a></td>

							<c:if test="${user.admin eq 2 && order.shipped eq false}">
								<td><a class="" name="edit-btn" data-toggle="modal"
									data-target="#Edit${order.orderID}"
									style="cursor: pointer; text-decoration: none;">Edit</a></td>
								<td><a class="" name="delete-btn" data-toggle="modal"
									data-target="#Delete${order.orderID}"
									style="cursor: pointer; text-decoration: none;">Delete</a></td>
							</c:if>
							
							<c:if test="${order.shipped eq true}">
								<td></td>
								<td></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>

				<c:forEach var="order" items="${orderList}">

					<%@ include file="edit-order-modal.jsp"%>
					<%@ include file="delete-order-modal.jsp"%>
					<%@ include file="view-order-products-modal.jsp"%>

				</c:forEach>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>
</body>
</html>