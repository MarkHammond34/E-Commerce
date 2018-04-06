package edu.ben.servlets.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.DAO.LineItemDAO;
import edu.ben.DAO.OrderDAO;
import edu.ben.model.LineItem;
import edu.ben.model.Order;
import edu.ben.model.User;

/**
 * Servlet implementation class AdminOrderServlet
 */
@WebServlet("/AdminOrderServlet")
public class AdminOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminOrderServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");

		OrderDAO orderDAO = new OrderDAO();

		String url = "";
		String message = "";

		if (user == null) {

			url = "/LoginServlet";
			message = "Login";

		} else if (user.getAdmin() == 0) {

			url = "/HomeServlet";
			message = "Access denied";

		} else {

			ArrayList<Order> orders = orderDAO.findAllOrders();

			if (orders != null) {
				message = orders.size() + " Order(s) Found";
			} else {
				message = "No Orders Found";
			}

			request.setAttribute("orderList", orders);
			url = "/admin/order/order-display.jsp";
		}

		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");

		OrderDAO orderDAO = new OrderDAO();
		LineItemDAO lineItemDAO = new LineItemDAO();

		String url = "";
		String message = "";
		String errorMessage = "";
		String successMessage = "";

		String action = (String) request.getParameter("action");

		if (user == null) {

			url = "/LoginServlet";
			message = "Login";

		} else if (user.getAdmin() == 0) {

			url = "/HomeServlet";
			message = "Access denied";

		} else if (user.getAdmin() == 1) {

			doGet(request, response);

		} else if (user.getAdmin() == 2) {

			if (action.equals("delete")) {

				int orderID = Integer.parseInt((String) request.getParameter("orderID"));

				if (orderID > 0) {

					int results = orderDAO.deactivate(orderID);

					if (results == 1) {
						successMessage = "Order " + orderID + " Deactivated";
					} else {
						errorMessage = "Deactivated Unsuccessful";
					}

				}

			} else if (action.equals("edit")) {

				int orderID = Integer.parseInt((String) request.getParameter("orderID"));
				int userID = Integer.parseInt((String) request.getParameter("userID"));
				String orderDate = (String) request.getParameter("orderDate");
				String shipDate = (String) request.getParameter("shipDate");
				int active = Integer.parseInt((String) request.getParameter("active"));
				boolean shipped = Boolean.parseBoolean((String) request.getParameter("shipped"));

				if (!shipped) {
					if (validInput(orderID, userID, orderDate, shipDate, active).equals("")) {

						int updateResults = orderDAO
								.update(new Order(orderID, userID, orderDate, shipDate, active, shipped));

						if (updateResults == 1) {
							successMessage = "Order " + orderID + " Updated";
						} else if (updateResults == 0) {
							errorMessage = "Update Unsuccessful";
						} else {
							errorMessage = "Update Error";
						}

					} else {
						errorMessage = validInput(orderID, userID, orderDate, shipDate, active);
					}

				} else {
					errorMessage = "Cannot Edit Shipped Orders";
				}

			} else if (action.equals("edit-order-product")) {

				int orderID = Integer.parseInt((String) request.getParameter("orderID"));
				int productID = Integer.parseInt((String) request.getParameter("productID"));
				int quantity = Integer.parseInt((String) request.getParameter("quantity"));

				Order order = orderDAO.findByOrderID(orderID);

				if (!order.isShipped()) {

					if (quantity > 10 || quantity < 0) {
						errorMessage = "Can't order more than 10 of one product";
					} else {

						int updateResults = lineItemDAO.update(new LineItem(orderID, productID, quantity));

						if (updateResults == 1) {
							successMessage = "Order " + orderID + " Updated";
						} else {
							errorMessage = "Update Unsuccessful";
						}
					}

				} else {
					errorMessage = "Cannot Edit Shipped Orders";
				}
			}
		}

		ArrayList<Order> orders = orderDAO.findAllOrders();

		if (orders != null) {
			message = orders.size() + " Order(s) Found";
		} else {
			message = "No Orders Found";
		}

		request.setAttribute("orderList", orders);
		url = "/admin/order/order-display.jsp";

		request.setAttribute("message", message);
		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("successMessage", successMessage);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	public String validInput(int orderID, int userID, String orderDate, String shipDate, int active) {

		String errors = "";

		if (orderID < 0) {
			errors += "Invalid Order ID\n";
		}

		if (userID < 0) {
			errors += "Invalid User ID\n";
		}

		if (orderDate.length() != 10) {
			errors += "Invalid Order Date\n";
		}

		if (shipDate.length() != 21) {
			errors += "Invalid Ship Date\n";
		}

		if (active > 1 || active < 0) {
			errors += "Invalid Active Status\n";
		}

		return errors;
	}
}
