package edu.ben.servlets.admin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ben.DAO.UserDAO;
import edu.ben.model.User;
import edu.ben.utilities.ImportFile;

/**
 * Servlet implementation class AdminProductServlet
 */
@WebServlet("/AdminUserServlet")
@MultipartConfig
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");

		UserDAO userDAO = new UserDAO();

		String url = "";
		String message = "";

		if (user == null) {

			url = "/LoginServlet";
			message = "Login";

		} else if (user.getAdmin() == 0) {

			url = "/HomeServlet";
			message = "Access denied";

		} else {

			ArrayList<User> users = userDAO.findAllUsers();

			if (users != null) {
				message = users.size() + " Users Found";
			} else {
				message = "No Products Found";
			}

			request.setAttribute("userList", users);
			url = "/admin/user/user-display.jsp";
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

		UserDAO userDAO = new UserDAO();

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

		} else if (user.getAdmin() == 2) {

			if (action.equals("delete")) {

				int userID = Integer.parseInt((String) request.getParameter("userID"));

				// VALIDATION NEEDED
				if (userID != 0) {

					int results = userDAO.deactiveate(userID);

					if (results == 1) {
						successMessage = "Account Deactivated";
					} else if (results == 0) {
						errorMessage = "Deactivation Unsuccessful";
					} else {
						errorMessage = "Deactivation Error";
					}

				}

			} else if (action.equals("create")) {

				String firstName = (String) request.getParameter("firstName");
				String lastName = (String) request.getParameter("lastName");
				String email = (String) request.getParameter("email");
				String password = (String) request.getParameter("password");
				int admin = Integer.parseInt((String) request.getParameter("admin"));

				if (validUserInput(firstName, lastName, email, password, admin)) {
					if (userDAO.insertUser(new User(firstName, lastName, email, password, admin, 1)) == 1) {
						successMessage = firstName + " " + lastName + " Created";
					} else {
						errorMessage = "Creation Error";
					}

				} else {
					errorMessage = "Invalid Input";
				}

			} else if (action.equals("edit")) {

				int userID = Integer.parseInt((String) request.getParameter("userID"));
				String firstName = (String) request.getParameter("firstName");
				String lastName = (String) request.getParameter("lastName");
				String email = (String) request.getParameter("email");
				String password = (String) request.getParameter("password");
				int admin = Integer.parseInt((String) request.getParameter("admin"));
				int active = Integer.parseInt((String) request.getParameter("active"));

				if (validUserInput(firstName, lastName, email, password, admin)) {
					if (userDAO
							.update(new User(userID, firstName, lastName, email, password, admin, 0, 0, active)) == 1) {
						successMessage = firstName + " " + lastName + " Updated";
					} else {
						errorMessage = "Update Error";
					}

				} else {
					errorMessage = "Invalid Input";
				}

			} else if (action.equals("import")) {

				Part file = request.getPart("file");
				InputStream fileStream = file.getInputStream();

				int importResults = ImportFile.importUsers(fileStream);

				if (importResults == ImportFile.ALL_RECORDS_ADDED) {
					successMessage = "All Records Added";
				} else if (importResults == ImportFile.SOME_RECORDS_ADDED) {
					successMessage = "Some Records Added";
				} else if (importResults == ImportFile.NO_RECORDS_ADDED) {
					errorMessage = "No Records Added";
				} else if (importResults == ImportFile.INVALID_FILE) {
					errorMessage = "Invalid File";
				} else if (importResults == ImportFile.INVALID_FILE_FORMAT) {
					errorMessage = "Invalid File Format";
				}

			}
		}

		// Get the updated list of users
		ArrayList<User> users = userDAO.findAllUsers();

		if (users != null) {
			message = users.size() + " Users Found";
		} else {
			message = "No Products Found";
		}

		request.setAttribute("userList", users);
		url = "/admin/user/user-display.jsp";

		request.setAttribute("message", message);
		request.setAttribute("successMessage", successMessage);
		request.setAttribute("errorMessage", errorMessage);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	public boolean validUserInput(String firstName, String lastName, String email, String password, int admin) {
		return true;
	}
}
