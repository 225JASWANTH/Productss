<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #74ebd5, #ACB6E5);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Segoe UI', sans-serif;
        }
        .card {
            width: 100%;
            max-width: 500px;
            border: none;
            border-radius: 15px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.2);
        }
        .form-control:focus {
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, .25);
        }
    </style>
</head>
<body>
    <div class="card p-4">
        <h3 class="text-center mb-4 text-primary">Add a New Product</h3>
        <form action="ProductItems" method="post">
            <div class="mb-3 input-group">
                <span class="input-group-text"><i class="bi bi-upc-scan"></i></span>
                <input type="text" class="form-control" name="productID" id="productId" placeholder="Enter the Product ID" required>
            </div>
            <div class="mb-3 input-group">
                <span class="input-group-text"><i class="bi bi-tag-fill"></i></span>
                <input type="text" class="form-control" name="productName" id="productName" placeholder="Enter the Product Name" required>
            </div>
            <div class="mb-4 input-group">
                <span class="input-group-text"><i class="bi bi-box-seam"></i></span>
                <input type="text" class="form-control" name="productType" id="productType" placeholder="Enter the Product Type" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">
                    <i class="bi bi-check2-circle me-2"></i>Submit Product
                </button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS (optional, for components like modals) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
