package com.ProductsDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ProductsModal.ProductListModal;

class Connect {

	public Connection connection() {

		Connection con = null;
		try {
			// Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connect the database to the driver
			String url = "jdbc:mysql://localhost:3306/products";
			String userName = "root";
			String password = "root";
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}

public class ProductsListDAO {

	Connect c = new Connect();

	public boolean insertItem(ProductListModal plm) {

		Connection con = c.connection();

		try {
			// Creating a statement for executing the query
			String stmt = "insert into product_items(productID, productName, productType) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(stmt);
			ps.setString(1, plm.getProductID());
			ps.setString(2, plm.getProductName());
			ps.setString(3, plm.getProductType());
			int x = ps.executeUpdate();
			if (x > 0) {
				System.out.println("Successfully inserted to the table");
				System.out.println(x + "row(s) inserted");
				return true;
			} else {
				System.out.println("Not inserted successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public List<ProductListModal> retriveProducts() {
		List<ProductListModal> pm = new ArrayList<>();

		Connection con = c.connection();

		try {
			String stmt = "select * from product_items";
			PreparedStatement ps = con.prepareStatement(stmt);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductListModal plm = new ProductListModal();
				plm.setProductID(rs.getString("productID"));
				plm.setProductName(rs.getString("productName"));
				plm.setProductType(rs.getString("productType"));
				pm.add(plm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pm;
	}

	public ProductListModal getById(String productID) {
		ProductListModal plm = null;
		Connection con = c.connection();
		try {

			String stmt = "select * from product_items where productID=?";
			PreparedStatement ps = con.prepareStatement(stmt);
			ps.setString(1, productID);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (productID == null) {
					System.out.println("No product with this ID");
				}
				System.out.println("Product is there and it get updated");
				plm = new ProductListModal();
				plm.setProductID(rs.getString("productID"));
				plm.setProductName(rs.getString("productName"));
				plm.setProductType(rs.getString("productType"));
			}

		} catch (Exception e) {

		}
		return plm;

	}

	public boolean updateProduct(ProductListModal plm) {

		Connection con = c.connection();

		try {
			String stmt = "UPDATE product_items SET productID=?, productName=?, productType=? where productID=?";
			PreparedStatement ps = con.prepareStatement(stmt);
			ps.setString(1, plm.getProductID());
			ps.setString(2, plm.getProductName());
			ps.setString(3, plm.getProductType());
			ps.setString(4, plm.getProductID());
			int x = ps.executeUpdate();
			if (x > 0) {
				System.out.println("successfully updated");
				System.out.println(x + "row(s) updated");
				return true;
			}
		} catch (Exception e) {

		}

		return false;
	}

	public boolean deleteProduct(String productID) {

		Connection con = c.connection();
		String stmt = "Delete from product_items where productID = ?";
		try {
			PreparedStatement ps = con.prepareStatement(stmt);
			ps.setString(1, productID);
			int x = ps.executeUpdate();
			if (x > 0) {
				System.out.println("Successfully deleted");
				System.out.println(x + "row(s) deleted");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}
