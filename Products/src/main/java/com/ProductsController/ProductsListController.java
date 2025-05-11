package com.ProductsController;

import java.io.IOException;

import com.ProductsDAO.ProductsListDAO;
import com.ProductsModal.ProductListModal;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductsListController
 */
@WebServlet("/ProductItems")
public class ProductsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productID = request.getParameter("productID");
		String productName = request.getParameter("productName");
		String productType = request.getParameter("productType");
		ProductListModal plm = new ProductListModal();

		System.out.println("***********************");
		plm.setProductID(productID);
		plm.setProductName(productName);
		plm.setProductType(productType);
		System.out.println(plm);
		System.out.println("**********************");

		ProductsListDAO pld = new ProductsListDAO();
		boolean status = pld.insertItem(plm);

		if (status) {
			System.out.println("Successfully inserted into table");
			HttpSession session = request.getSession();
			session.setAttribute("productID", productID);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("Something went wrong in inserting of data");
			response.getWriter().write("Something went wrong in inserting of data");
		}

	}

}
