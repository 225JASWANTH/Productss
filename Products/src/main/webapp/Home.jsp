<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.ProductsModal.ProductListModal, com.ProductsDAO.ProductsListDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap Icons -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">

<style>
body {
	background: #f4f8fb;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	padding: 30px;
}

.card {
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
}

h2 {
	color: #007bff;
}

.btn-add {
	float: right;
}
</style>
</head>
<body>

	<div class="container">
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h2>
				<i class="bi bi-box-seam me-2"></i>Welcome to Products Page
			</h2>
			<a href="index.jsp" class="btn btn-success btn-add"> <i
				class="bi bi-plus-circle me-1"></i> Add Product
			</a>
		</div>

		<div class="card p-3">
			<table class="table table-striped table-hover">
				<thead class="table-dark">
					<tr>
						<th><i class="bi bi-upc-scan me-1"></i> Product ID</th>
						<th><i class="bi bi-tag-fill me-1"></i> Product Name</th>
						<th><i class="bi bi-box-fill me-1"></i> Product Type</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					ProductsListDAO pld = new ProductsListDAO();
					List<ProductListModal> li = pld.retriveProducts();
					for (ProductListModal lli : li) {
					%>
					<tr>
						<td><%=lli.getProductID()%></td>
						<td><%=lli.getProductName()%></td>
						<td><%=lli.getProductType()%></td>
						<td class="action-icons"><a
							href="update.jsp?productID=<%= lli.getProductID()%>" class="btn btn-success">
								<i class="bi bi-pencil-fill"></i> Update
						</a> <a href="ProductsDeleteController?productID=<%= lli.getProductID()%>"
							onclick="return confirm('Are you sure you want to delete <%= lli.getProductID()%> item');"
							class="btn btn-danger"> <i class="bi bi-trash-fill"></i>
								Delete
						</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Bootstrap JS Bundle (for interactive components if needed) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
