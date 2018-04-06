package edu.ben.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.DAO.ProductDAO;
import edu.ben.model.*;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product = request.getParameter("value");
		String message = "";
		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> productList = new ArrayList<Product>();

		if (product.equals("bose") || product.equals("beats") || product.equals("sony")) {
			productList = productDAO.findByBrand(product);
			request.setAttribute("productList", productList);
			if (product.equals("bose")) {
				message = "Bose Headphones:";
			} else if (product.equals("beats")) {
				message = "Beats Headphones:";
			} else if (product.equals("sony")) {
				message = "Sony Headphones:";
			}
			request.setAttribute("message", message);

		} else if (product.equals("in-ear") || product.equals("over-ear") || product.equals("on-ear")) {
			productList = productDAO.findByStyle(product);
			request.setAttribute("productList", productList);
			if (product.equals("in-ear")) {
				message = "In-Ear Headphones:";
			} else if (product.equals("over-ear")) {
				message = "Over-Ear Headphones:";
			} else if (product.equals("on-ear")) {
				message = "On-Ear Headphones:";
			}
			request.setAttribute("message", message);

		} else if (product.equals("wired")) {

			productList = productDAO.findAllWired();
			request.setAttribute("productList", productList);

			message = "Wired Headphones";
			request.setAttribute("message", message);

		} else if (product.equals("wireless")) {

			productList = productDAO.findAllWireless();
			request.setAttribute("productList", productList);

			message = "Wireless Headphones";
			request.setAttribute("message", message);

		}

		getServletContext().getRequestDispatcher("/product_headphones.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
