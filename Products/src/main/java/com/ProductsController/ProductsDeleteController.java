package com.ProductsController;

import java.io.IOException;

import com.ProductsDAO.ProductsListDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductsDeleteController
 */
@WebServlet("/ProductsDeleteController")
public class ProductsDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductsListDAO pld = new ProductsListDAO();
		String productID = request.getParameter("productID");
		boolean status = pld.deleteProduct(productID);
		if(status) {
			System.out.println("*************************");
			System.out.println("Successfully deleted " + productID);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}else {
			System.out.println("************************");
			System.out.println("Something went wrong");
			response.getWriter().write("Something went wrong in deleting");
		}
	
	}

}
