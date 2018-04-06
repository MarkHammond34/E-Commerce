package edu.ben.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.DAO.ProductDAO;
import edu.ben.model.Product;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> allProducts = productDAO.findMostRecent();
		ArrayList<Product> mostRecent = new ArrayList<Product>();
		ArrayList<Product> mostPopular = new ArrayList<Product>();

		for (int i = 0; i < 3; i++) {
			mostRecent.add(allProducts.get(i));
		}
		mostPopular.add(allProducts.get(3));
		mostPopular.add(allProducts.get(5));
		mostPopular.add(allProducts.get(4));

		request.setAttribute("mostRecent", mostRecent);
		request.setAttribute("mostPopular", mostPopular);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
