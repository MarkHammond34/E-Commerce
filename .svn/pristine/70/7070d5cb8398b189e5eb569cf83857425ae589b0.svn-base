package edu.ben.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.DAO.ProductDAO;
import edu.ben.model.Product;

/**
 * Servlet implementation class BuildHeadphonesServlet
 */
@WebServlet("/BuildHeadphonesServlet")
public class BuildHeadphonesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuildHeadphonesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String brand = (String) request.getParameter("brand");
		String tech = (String) request.getParameter("tech");
		String style = (String) request.getParameter("style");

		boolean isWireless = false;

		ProductDAO productDAO = new ProductDAO();

		if (tech.equals("wireless")) {
			isWireless = true;
		}

		ArrayList<Product> productList = productDAO.findByProduct(new Product(brand, "", style, isWireless, 0, ""));

		request.setAttribute("message", "Best Headphones For You");
		request.setAttribute("productList", productList);
		getServletContext().getRequestDispatcher("/product_headphones.jsp").forward(request, response);

	}

}