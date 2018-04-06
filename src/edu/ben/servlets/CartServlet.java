package edu.ben.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.DAO.ProductDAO;
import edu.ben.model.Cart;
import edu.ben.model.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// create cart if you dont have one
		if (request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}

		System.out.println("product brand, model, price");
		System.out.println(request.getParameter("productBrand"));
		System.out.println(request.getParameter("productModel"));
		System.out.println(request.getParameter("productPrice"));
		System.out.println(request.getParameter("productID"));

		String productID = request.getParameter("productID");
		System.out.println("productQty = " + request.getParameter("productQty"));

		int qty = Integer.parseInt(request.getParameter("productQty"));

		ProductDAO dao = new ProductDAO();
		Product p = dao.findByID(Integer.parseInt(productID));
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.addToCart(p, qty);

		request.getSession().setAttribute("cart", cart);

		getServletContext().getRequestDispatcher("/mycart.jsp").forward(request, response);

		// redirect to the cart page/

	}

}
