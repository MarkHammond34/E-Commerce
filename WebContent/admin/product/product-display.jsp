<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="edu.ben.model.User"%>
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
			<div class="col-lg-3">
				<h2 style="color: white;">Options</h2>
				<div class="well">
					<button class="btn w3-button w3-green" id="AddNewProdBtn"
						data-toggle="modal" data-target="#AddProduct">Add New
						Product</button>
					<button class="btn w3-button w3-red" id="ImportProdBtn"
						data-toggle="modal" data-target="#Import">Import From CSV
						File</button>
				</div>
			</div>

			<div class="col-lg-9">
				<h2 style="color: white;">Products</h2>
				<c:if test="${message != null}">
					<h4 style="color: white">(${message})</h4>
				</c:if>
				<table>
					<tr>
						<th>Product ID</th>
						<th>Brand</th>
						<th>Model</th>
						<th>Price</th>
						<th>Active</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach var="product" items="${productList}">
						<tr>
							<td>${product.productID}</td>
							<td>${product.brand}</td>
							<td>${product.model}</td>
							<td>${product.price}</td>
							<td>${product.active}</td>

							<c:if test="${user.admin eq 2}">
								<td><a data-toggle="modal"
									data-target="#Edit${product.productID}"
									style="cursor: pointer; text-decoration: none;">Edit</a></td>
								<td><a data-toggle="modal"
									data-target="#Delete${product.productID}"
									style="cursor: pointer; text-decoration: none;">Delete</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>

				<c:forEach var="product" items="${productList}">

					<%@ include file="edit-product-modal.jsp"%>
					<%@ include file="delete-product-modal.jsp"%>

				</c:forEach>
			</div>
		</div>
	</div>

	<jsp:include page="/admin/product/add-product-modal.jsp"></jsp:include>
	<jsp:include page="/admin/product/import-product-modal.jsp"></jsp:include>

</body>
</html>