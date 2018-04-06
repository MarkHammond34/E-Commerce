package edu.ben.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.ben.DAO.UserDAO;
import edu.ben.model.Cart;
import edu.ben.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("pass-confirm");

		UserDAO userDAO = new UserDAO();
		User user = new User(firstName, lastName, email, password, 0, 0);

		String message = "";

		if (validRegistration(userDAO, user.getEmail())) {

			if (firstName.length() == 0 || lastName.length() == 0 || email.length() == 0 || password.length() == 0
					|| passwordConfirm.length() == 0) {

				request.setAttribute(firstName, "firstname");
				request.setAttribute(lastName, "lastname");
				request.setAttribute(email, "email");
				request.setAttribute(password, "password");
				message += "please fill out all info correctly<br>";

				request.getRequestDispatcher("/registration.jsp").forward(request, response);

			} else if (!password.equals(passwordConfirm)) {

				request.setAttribute(firstName, "firstname");
				request.setAttribute(lastName, "lastname");
				request.setAttribute(email, "email");
				request.setAttribute(password, "password");
				message += "please fill out all info correctly<br>";

				request.getRequestDispatcher("/registration.jsp").forward(request, response);

			} else {

				request.setAttribute(firstName, "firstname");
				request.setAttribute(lastName, "lastname");
				request.setAttribute(email, "email");
				request.setAttribute(password, "password");

				// check address!
				String street = request.getParameter("street");
				String city = request.getParameter("city");
				String state = request.getParameter("state"); // 2 letter code, not whole word!
				String zip = request.getParameter("zip");

				if (AddressValidator.validAddress(street, city, state, zip)) {

					// allow the login to proceed
					request.setAttribute("user", user);

					// Create a session for the user
					HttpSession session = request.getSession();
					session.setAttribute("userSession", user.getFirstName());
					session.setAttribute("user", user);

					/** Add new user to the database */
					// Add in an error check for adding a user. Reject if it doesn't work
					userDAO.insertUser(user);

					// request.getRequestDispatcher("/index.jsp").forward(request, response);
					Cart cart = (Cart) session.getAttribute("cart");
					if (cart != null && cart.getSize() == 0) {

						response.sendRedirect("/HeadphonesWebsite");

					} else {

						request.getRequestDispatcher("mycart.jsp").forward(request, response);

					}

					request.setAttribute("message", message);

				} else {

					// let the user know that the address is invalid
					request.setAttribute(firstName, "firstname");
					request.setAttribute(lastName, "lastname");
					request.setAttribute(email, "email");
					request.setAttribute(password, "password");
					// check address!
					street = request.getParameter("street");
					city = request.getParameter("city");
					state = request.getParameter("state"); // 2 letter code, not whole word!
					zip = request.getParameter("zip");

					message += "please enter a valid US address <br>";
					request.setAttribute("errorMes", message);
					request.getRequestDispatcher("/registration.jsp").forward(request, response);

				}
			}

		} else {

			request.setAttribute("errorMes", "User with email " + user.getEmail() + " already exists.");

			request.setAttribute(firstName, "firstname");
			request.setAttribute(lastName, "lastname");
			request.setAttribute(password, "password");

			request.getRequestDispatcher("/registration.jsp").forward(request, response);
		}
	}

	protected boolean validRegistration(UserDAO userDAO, String email) {

		if (userDAO.findUserByEmail(email) == null) {
			return true;
		}

		return false;

	}

}
