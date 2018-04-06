package edu.ben.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.DAO.UserDAO;
import edu.ben.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);

		/*
		 * 
		 * Cart cart = (Cart) session.getAttribute("cart"); if (cart.getSize() == 0) {
		 * response.sendRedirect("/HeadphonesWebsite"); } else {
		 * request.getRequestDispatcher("mycart.jsp").forward(request, response); }
		 * 
		 * } else {
		 * 
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user;

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		/**
		 * These will be used when login page is done and users are successfully able to
		 * be added to the db.
		 */
		UserDAO userDAO = new UserDAO();
		if (userDAO.findUserByEmail(email) != null) {

			user = userDAO.findUserByEmail(email);

			/**
			 * if email and password match a user in the db, log the person in and maybe add
			 * them to the session?
			 */
			if (user.getPassword().equals(password) && user.getActive() == 1) {

				String url;
				if (user.getFailedAttempts() > 0) {

					if (user.getFailedAttempts() >= 3) {

						url = validateLogin(request, response, session, user, userDAO, password);

					} else {

						url = "/HeadphonesAdmin";

					}

				} else {

					url = "/HeadphonesAdmin";

				}

				if (!url.equals("/login.jsp")) {

					session.setAttribute("userSession", user.getFirstName());
					session.setAttribute("user", user);
					userDAO.setLastFailedLogin(email, 0);
					userDAO.setFailedLoginAttempts(email, 0);

					if (user.getAdmin() > 0) {
						response.sendRedirect("/HeadphonesAdmin/AdminHomeServlet");
					} else {
						response.sendRedirect("/HeadphonesAdmin");
					}
				} else {

					userDAO.setLastFailedLogin(user.getEmail(), user.getLastLogin());
					int failedAttempts = user.getFailedAttempts();
					userDAO.setFailedLoginAttempts(email, failedAttempts++);
					request.getRequestDispatcher("login.jsp").forward(request, response);

				}

			} else {

				validateLogin(request, response, session, user, userDAO, password);

				userDAO.setLastFailedLogin(user.getEmail(), user.getLastLogin());
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

		} else {

			session.setAttribute("message", "User with email " + email + " does not exist");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	public String validateLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			User user, UserDAO userDAO, String password) {

		Date date;
		String url;

		if (user.getFailedAttempts() >= 3) {

			long lastAccessedTime = 0;
			Date date2;

			if (user.getLastLogin() == 0) {

				lastAccessedTime = session.getLastAccessedTime();
				date2 = new Date();
				date2.setTime(lastAccessedTime);
				// Set user access time
				user.setLastLogin(date2.getTime());

			}

			date = new Date();
			long currentTime = date.getTime();
			long timeDiff = currentTime - user.getLastLogin();

			// 10 minutes in milliseconds = 600000 milliseconds.
			if (timeDiff >= 600000) {

				user.setLastLogin(0);
				user.setFailedAttempts(0);

				if (user.getPassword().equals(password)) {

					session.removeAttribute("message");
					session.removeAttribute("userSession");
					session.removeAttribute("user");
					userDAO.setFailedLoginAttempts(user.getEmail(), 0);

				} else {

					int failedAttempts = user.getFailedAttempts();
					userDAO.setFailedLoginAttempts(user.getEmail(), ++failedAttempts);
					user.setFailedAttempts(failedAttempts);
					int allowLogin = 4 - user.getFailedAttempts();
					session.setAttribute("message", "loginAttempt= " + user.getFailedAttempts()
							+ ". Invalid username or password. You have " + allowLogin
							+ " attempts remaining. Please try again! <br>Not a registered cusomer? Please <a href=\"RegistrationServlet\">register</a>!");

				}

			} else {

				if (user.getPassword().equals(password)) {

					session.removeAttribute("message");
					session.removeAttribute("userSession");
					session.removeAttribute("user");
					userDAO.setFailedLoginAttempts(user.getEmail(), 0);
					url = "/HeadphonesAdmin";
					return url;

				} else {

					// Get lockout time remaining in minutes.
					int timeLeft = (int) (600000 - timeDiff) / 60000;

					// Error message
					if (timeLeft < 1) {

						session.setAttribute("message",
								"You have 4 or more failed login attempts. Please try logging in in less than 1 minute");

					} else {

						session.setAttribute("message",
								"You have 4 or more failed login attempts. Please try logging in in " + timeLeft
										+ " minutes.");

					}

				}
			}

		} else {

			int failedAttempts = user.getFailedAttempts();
			userDAO.setFailedLoginAttempts(user.getEmail(), ++failedAttempts);
			user.setFailedAttempts(failedAttempts);
			int allowLogin = 4 - user.getFailedAttempts();
			session.setAttribute("message", "loginAttempt= " + user.getFailedAttempts()
					+ ". Invalid username or password. You have " + allowLogin
					+ " attempts remaining. Please try again! <br>Not a registered cusomer? Please <a href=\"RegistrationServlet\">register</a>!");

		}

		if (user.getLastLogin() == 0) {

			url = "/HeadphonesAdmin";

		} else {

			url = "/login.jsp";

		}

		return url;
	}
}