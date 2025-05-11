<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ProductsModal.ProductListModal, com.ProductsDAO.ProductsListDAO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Items</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            background: #f4f8fb;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            padding: 40px 0;
        }
        .container {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #007bff;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-custom {
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="container">
    <h2><i class="bi bi-pencil-square"></i> Update Product</h2>
    <form action="ProductsUpdateController" method="post">
        <%
        ProductsListDAO pld = new ProductsListDAO();
        String productID = request.getParameter("productID");
        ProductListModal plm = pld.getById(productID);
        %>

        <!-- Product ID -->
        <div class="form-group">
            <label for="productID"><i class="bi bi-barcode"></i> Product ID</label>
            <input type="text" name="productID" id="productID" class="form-control" placeholder="Enter product ID" value="<%=plm.getProductID()%>" readonly>
        </div>

        <!-- Product Name -->
        <div class="form-group">
            <label for="productName"><i class="bi bi-box"></i> Product Name</label>
            <input type="text" name="productName" id="productName" class="form-control" placeholder="Enter Product Name" value="<%=plm.getProductName()%>">
        </div>

        <!-- Product Type -->
        <div class="form-group">
            <label for="productType"><i class="bi bi-tag"></i> Product Type</label>
            <input type="text" name="productType" id="productType" class="form-control" placeholder="Enter Product Type" value="<%=plm.getProductType()%>">
        </div>

        <!-- Action Buttons -->
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success btn-custom">
                <i class="bi bi-check-circle-fill"></i> Update
            </button>
            <a href="./Home.jsp" class="btn btn-secondary btn-custom">
                <i class="bi bi-arrow-left-circle"></i> Cancel
            </a>
        </div>
    </form>
</div>

<!-- Bootstrap JS Bundle (for interactive components like modals, etc.) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
