package edu.ben.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.DAO.UserDAO;
import edu.ben.model.User;
import edu.ben.utilities.ResetPassword;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");

		UserDAO userDAO = new UserDAO();

		String action = (String) request.getParameter("action");

		String url = "";
		String message = "";
		String errorMessage = "";
		String successMessage = "";

		if (user != null) {

			message = "Already Logged In";
			url = "/HomeServlet";

		} else {

			if (action.equals("reset")) {

				String email = (String) request.getParameter("email");

				if (userDAO.findUserByEmail(email) == null) {

					errorMessage = "No user under " + email + " found!";
					url = "/password-reset.jsp";

				} else {

					String resetCode = ResetPassword.reset(email);

					request.setAttribute("userEmail", email);
					request.setAttribute("resetCode", resetCode);

					url = "/password-reset-enter-code.jsp";

				}

			} else if (action.equals("check-code")) {

				String resetCode = (String) request.getParameter("resetCode");
				String userEmail = (String) request.getParameter("userEmail");
				String codeEntered = (String) request.getParameter("codeEntered");

				if (resetCode.equals(codeEntered)) {

					request.setAttribute("userEmail", userEmail);
					url = "/password-reset-enter-password.jsp";

				} else {

					request.setAttribute("userEmail", userEmail);
					request.setAttribute("resetCode", resetCode);
					errorMessage = "Code Incorrect";
					url = "/password-reset-enter-code.jsp";

				}

			} else if (action.equals("check-password")) {

				String userEmail = (String) request.getParameter("userEmail");
				String newPassword = (String) request.getParameter("newPassword");
				String newPasswordConfirm = (String) request.getParameter("newPasswordConfirm");

				System.out.println(userEmail);

				if (newPassword.equals(newPasswordConfirm)) {

					User u = userDAO.findUserByEmail(userEmail);

					u.setPassword(newPassword);
					userDAO.update(u);

					message = "Password Reset";
					url = "/login.jsp";

				} else {

					request.setAttribute("userEmail", userEmail);
					errorMessage = "Passwords Do Not Match";

					url = "/password-reset-enter-password.jsp";

				}

			}

		}

		request.setAttribute("message", message);
		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("successMessage", successMessage);
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

}
