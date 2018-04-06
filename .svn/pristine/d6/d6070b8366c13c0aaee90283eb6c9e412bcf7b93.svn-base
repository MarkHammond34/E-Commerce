package edu.ben.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.DAO.ProductDAO;
import edu.ben.model.Product;

/**
 * Servlet implementation class SearchBarServlet
 */
@WebServlet("/SearchBarServlet")
public class SearchBarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchBarServlet() {
		super();
	}

	/**
	 * @author Mark Hammond
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = "";
		String search = (String) request.getParameter("search").trim();

		ArrayList<Product> productList = getSearchResults(search);

		if (productList.size() > 0) {
			message = "Results Found For: '" + search + "'";
		} else {
			message = "No Results Found For: '" + search + "'";
		}

		request.setAttribute("message", message);
		request.setAttribute("productList", productList);
		getServletContext().getRequestDispatcher("/product_headphones.jsp").forward(request, response);

	}

	/**
	 * @author Mark Hammond
	 * 
	 *         Method takes in the search string (ex. "sony wireless over ear") and
	 *         returns an array list of products that are yielded from the search.
	 * 
	 * @param search
	 *            string of the users search
	 * @return productList array list of products returned by the search
	 */
	public ArrayList<Product> getSearchResults(String search) {

		ProductDAO productDAO = new ProductDAO();

		/** Extract words from search string */
		ArrayList<String> searchWords = new ArrayList<String>();
		String currentWord = "";

		for (int i = 0; i < search.length(); i++) {

			if (search.substring(i, i + 1).equals(" ")) {
				searchWords.add(currentWord);
				currentWord = "";

			} else if (i == search.length() - 1) {
				currentWord += search.substring(i, i + 1);
				searchWords.add(currentWord);

			} else {
				currentWord += search.substring(i, i + 1);
			}

		}

		ArrayList<Product> productList = new ArrayList<Product>();

		// Checks if user searched for wireless
		boolean searchedForWireless = false;

		if (searchWords.contains("wireless")) {
			searchWords.remove("wireless");
			searchedForWireless = true;
		}

		// Checks if user searched for a style
		String style = "";

		if (searchWords.contains("over") && searchWords.contains("ear")) {
			searchWords.remove("over");
			searchWords.remove("ear");
			style = "over-ear";
		} else if (searchWords.contains("on") && searchWords.contains("ear")) {
			searchWords.remove("on");
			searchWords.remove("ear");
			style = "on-ear";
		} else if (searchWords.contains("in") && searchWords.contains("ear")) {
			searchWords.remove("in");
			searchWords.remove("ear");
			style = "in-ear";
		}

		// If only one word was searched
		if (searchWords.size() == 0) {

			// If user searched for wireless and not a style
			if (searchedForWireless && style.equals("")) {

				productList = productDAO.findAllWireless();

				// Else if user searched for a type of style, and not wireless
			} else if (!style.equals("") && !searchedForWireless) {

				productList = productDAO.findByStyle(style);

				// Else, user searched for wireless and style
			} else {

				productDAO.findByProduct(new Product("", "", style, searchedForWireless, -1, ""));

			}

			// Check if user is searching for wireless, not a style, and a brand
		} else if (searchWords.size() == 1 && searchedForWireless && style.equals("")) {

			productList = productDAO.findByProduct(new Product(searchWords.get(0), "", "", true, -1, ""));

			// Check if user is searching for wireless, not a style, and a model
			if (productList == null) {

				productList = productDAO.findByProduct(new Product("", searchWords.get(0), "", true, -1, ""));

			}

			// Check if user is searching for a style, not wireless, and a brand
		} else if (searchWords.size() == 1 && !style.equals("") && !searchedForWireless) {

			productList = productDAO.findByProduct(new Product(searchWords.get(0), "", style, false, -1, ""));

			// Check if user is searching for a style and a model
			if (productList == null) {

				productList = productDAO.findByProduct(new Product("", searchWords.get(0), style, false, -1, ""));

			}

			// Check if user is searching for a brand, not a style, and not wireless
		} else if (searchWords.size() == 1 && style.equals("") && !searchedForWireless) {

			productList = productDAO.findByBrand(searchWords.get(0));

			// Check if user is searching for a model, not a style, and not wireless
			if (productList == null) {

				productList = productDAO.findByModel(searchWords.get(0));

			}

			// Check if user is searching for wireless, and first word is a brand and the
			// second is a model
		} else if (searchWords.size() == 2 && searchedForWireless && style.equals("")) {

			productList = productDAO
					.findByProduct(new Product(searchWords.get(0), searchWords.get(1), "", true, -1, ""));

			// Check is user is searching for wireless, and first word is a model and the
			// second is a brand
			if (productList == null) {

				productList = productDAO
						.findByProduct(new Product(searchWords.get(1), searchWords.get(0), "", true, -1, ""));

			}

			// Check if user is searching for a style, and first word is a brand and the
			// second is a model
		} else if (searchWords.size() == 2 && !style.equals("") && !searchedForWireless) {

			productList = productDAO
					.findByProduct(new Product(searchWords.get(0), searchWords.get(1), style, false, -1, ""));

			// Check if user is searching for a style, and first word is a model and the
			// second is a brand
			if (productList == null) {

				productList = productDAO
						.findByProduct(new Product(searchWords.get(1), searchWords.get(0), style, false, -1, ""));

			}

			// Check if user is searching for wireless, a style, and the first word is a
			// brand and the second is a model
		} else if (searchWords.size() == 2 && searchedForWireless && !style.equals("")) {

			productList = productDAO
					.findByProduct(new Product(searchWords.get(0), searchWords.get(1), style, true, -1, ""));

			// Check if user is searching for wireless, a style, and the first word is a
			// model and the second is a brand
			if (productList == null) {

				productList = productDAO
						.findByProduct(new Product(searchWords.get(1), searchWords.get(0), style, true, -1, ""));

			}
			// Check if user is searching for a brand, and a model with the first word as a
			// brand and the second as a model
		} else if (searchWords.size() == 2 && !searchedForWireless && style.equals("")) {

			productList = productDAO
					.findByProduct(new Product(searchWords.get(0), searchWords.get(1), "", false, -1, ""));

			// Check if user is searching for a brand, and a model with the first word as a
			// model and the second as a brand
			if (productList == null) {

				productList = productDAO
						.findByProduct(new Product(searchWords.get(1), searchWords.get(0), "", false, -1, ""));

			}

		}

		return productList;
	}
}