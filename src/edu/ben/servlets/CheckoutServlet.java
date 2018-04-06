package edu.ben.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.model.Cart;
import edu.ben.model.Transaction;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = (String) request.getParameter("action");

		String url = "";

		if (action.equals("start-checkout")) {
			url = "/checkout-shipping.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cart cart = (Cart) request.getSession().getAttribute("cart");

		String action = (String) request.getParameter("action");

		String url = "";

		if (action.equals("shipping")) {

			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");

			String shippingType = request.getParameter("shipping");

			request.setAttribute("street", street);
			request.setAttribute("city", city);
			request.setAttribute("state", state);
			request.setAttribute("zip", zip);

			request.setAttribute("shippingType", shippingType);

			// If valid address, add shipping cost and continue to next page
			if (AddressValidator.validAddress(street, city, state, zip)) {

				double totalBeforeShipping = cart.getTotal();

				// If shipping is standard, add $8 to cart total
				if (shippingType.equals("1")) {

					cart.setTotal(totalBeforeShipping + 8.00);

					// If shipping is expedited, add $18 to cart total
				} else if (shippingType.equals("2")) {

					cart.setTotal(totalBeforeShipping + 18.00);

				}

				url = "checkout-credit-card.jsp";

				// If invalid address, redirect to shipping page with error message
			} else {

				String errorMessage = "Please enter a valid US adderss";
				request.setAttribute("errorMes", errorMessage);

				url = "checkout-shipping.jsp";

			}

		} else if (action.equals("credit card")) {

			String name = request.getParameter("name");
			String cardNumber = request.getParameter("card number");

			if (isValidCreditCard(cardNumber)) {

				url = "/order-confirmation.jsp";

				cart.clear();
				request.getSession().setAttribute("cart", cart);
				request.setAttribute("transaction", new Transaction(cart.getTotal(), name, cardNumber));

			} else {

				request.setAttribute("errorMes", "Invalid Credit Card Number");
				url = "/checkout-credit-card.jsp";
			}

		}

		request.getRequestDispatcher(url).forward(request, response);

	}

	private boolean isValidCreditCard(String cardNumber) {

		int sum = 0;
		boolean alternate = false;

		for (int i = cardNumber.length() - 1; i >= 0; i--) {

			int n = Integer.parseInt(cardNumber.substring(i, i + 1));
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}

		return (sum % 10 == 0);

	}

}
