package edu.ben.servlets.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ben.DAO.ProductDAO;
import edu.ben.model.Product;
import edu.ben.model.User;
import edu.ben.utilities.ImportFile;

/**
 * Servlet implementation class AdminProductServlet
 */
@WebServlet("/AdminProductServlet")
@MultipartConfig
public class AdminProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminProductServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");

		ProductDAO prodDAO = new ProductDAO();

		String url = "";
		String message = "";

		if (user == null) {

			url = "/LoginServlet";
			message = "Login";

		} else if (user.getAdmin() == 0) {

			url = "/HomeServlet";
			message = "Access denied";

		} else {

			ArrayList<Product> products = prodDAO.findAllProducts();

			if (products != null) {
				message = products.size() + " Products Found";
			} else {
				message = "No Products Found";
			}

			request.setAttribute("productList", products);
			url = "/admin/product/product-display.jsp";
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

		ProductDAO prodDAO = new ProductDAO();

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

				int productID = Integer.parseInt((String) request.getParameter("productID"));

				if (productID > 0) {

					int deleteResults = prodDAO.deactivate(productID);

					if (deleteResults == 1) {
						successMessage = "Product " + productID + " Deactivated";
					} else {
						errorMessage = "Deactivation Error";
					}

				}

			} else if (action.equals("edit")) {

				int productID = Integer.parseInt((String) request.getParameter("productID"));
				String brand = (String) request.getParameter("brand");
				String model = (String) request.getParameter("model");
				String style = (String) request.getParameter("style");
				String tech = (String) request.getParameter("tech");
				double price = Double.parseDouble((String) request.getParameter("price"));
				String desc = (String) request.getParameter("desc");
				int active = Integer.parseInt((String) request.getParameter("active"));

				boolean wireless = false;
				if (tech.equals("wireless")) {
					wireless = true;
				}

				if (validInput(brand, model, style, wireless, price, desc).equals("")) {

					int updateResults = prodDAO
							.update(new Product(productID, brand, model, style, wireless, price, desc, active));

					if (updateResults == 1) {
						successMessage = brand + " " + model + " Updated";
					} else if (updateResults == 0) {
						errorMessage = "Update Unsuccessful";
					} else {
						errorMessage = "Update Error";
					}

				} else {

					errorMessage = validInput(brand, model, style, wireless, price, desc);

				}

			} else if (action.equals("create")) {

				String brand = (String) request.getParameter("brand");
				String model = (String) request.getParameter("model");
				String style = (String) request.getParameter("style");
				double price = Double.parseDouble((String) request.getParameter("price"));
				String tech = (String) request.getParameter("tech");
				String desc = (String) request.getParameter("desc");

				boolean wireless = false;
				if (tech.equals("wireless")) {
					wireless = true;
				}

				if (validInput(brand, model, style, wireless, price, desc).equals("")) {

					if (prodDAO.exists(new Product(brand, model, style, wireless, price, desc))) {
						errorMessage = "Product Exists";
					} else {

						int insertResults = prodDAO.insert(new Product(brand, model, style, wireless, price, desc));

						if (insertResults == 1) {
							successMessage = "Product Created";
						} else {
							errorMessage = "Product Not Successfully Created";
						}
					}

				} else {
					errorMessage = validInput(brand, model, style, wireless, price, desc);
				}

			} else if (action.equals("import")) {

				Part file = request.getPart("file");
				InputStream fileStream = file.getInputStream();

				File path = new File((String) request.getParameter("file"));
				BufferedImage image = null;

				try {

				} catch (Exception e) {
					image = ImageIO.read(path);

					ImageIO.write(image, "jpg", new File("C:\\out.jpg"));
				}

				System.out.println("DONE");

				/*
				 * 
				 * int importResults = ImportFile.importProducts(fileStream);
				 * 
				 * if (importResults == ImportFile.ALL_RECORDS_ADDED) { successMessage =
				 * "All Records Added"; } else if (importResults ==
				 * ImportFile.SOME_RECORDS_ADDED) { successMessage = "Some Records Added"; }
				 * else if (importResults == ImportFile.NO_RECORDS_ADDED) { errorMessage =
				 * "No Records Added"; } else if (importResults == ImportFile.INVALID_FILE) {
				 * errorMessage = "Invalid File"; } else if (importResults ==
				 * ImportFile.INVALID_FILE_FORMAT) { errorMessage = "Invalid File Format"; }
				 */
			}

		}

		ArrayList<Product> products = prodDAO.findAllProducts();

		if (products != null) {
			message = products.size() + " Products Found";
		} else {
			message = "No Products Found";
		}

		request.setAttribute("productList", products);
		url = "/admin/product/product-display.jsp";

		request.setAttribute("message", message);
		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("successMessage", successMessage);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	public String validInput(String brand, String model, String style, boolean wireless, double price, String desc) {

		String errors = "";

		if (brand.length() >= 30) {
			errors += "Invalid Brand\n";
		}

		if (model.length() >= 30) {
			errors += "Invalid Model\n";
		}

		if (price >= 1000 && price <= 0) {
			errors += "Invalid Price: Outside of Range (0-1000)\n";
		}

		if (desc.length() >= 200) {
			errors += "Invalid Description: Too Long\n";
		}

		return errors;
	}
}
