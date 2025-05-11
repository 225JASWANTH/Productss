package com.ProductsController;

import java.io.IOException;

import com.ProductsDAO.ProductsListDAO;
import com.ProductsModal.ProductListModal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductsUpdateController
 */
@WebServlet("/ProductsUpdateController")
public class ProductsUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductsListDAO pld = new ProductsListDAO();
		String productID = request.getParameter("productID");
		ProductListModal plm  = pld.getById(productID);
		if(plm!=null) {
			System.out.println("************************");
			System.out.println("No null");
			request.setAttribute("plm", plm.getProductID() );
			request.getRequestDispatcher("Update.jsp").forward(request, response);
		}else {
			System.out.println("Something went wrong");
			response.getWriter().write("Something went wrong");
			request.getRequestDispatcher("Home.jsp");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductsListDAO pld = new ProductsListDAO();
		ProductListModal plm = new ProductListModal();
		String productID = request.getParameter("productID");
		String productName = request.getParameter("productName");
		String productType = request.getParameter("productType");
		
		plm.setProductID(productID);
		plm.setProductName(productName);
		plm.setProductType(productType);
		System.out.println("****************");
		System.out.println(plm);
		
		boolean status = pld.updateProduct(plm);
		if(status) {
			System.out.println("Succesfully updated your item");
			request.getRequestDispatcher("Home1.jsp").forward(request, response);
		}else {
			System.out.println("Not updated the item successfully");
			response.getWriter().write("Not updated the item");
		}
	
	}

}
