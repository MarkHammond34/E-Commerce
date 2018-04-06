package edu.ben.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ben.model.Product;

public class ProductDAO {

	private DBConnect con;

	public ProductDAO() {

		con = new DBConnect();

	}

	public ProductDAO(String dbName) {

		con = new DBConnect(dbName);
	}

	/**
	 * Inserts post object into the comment table
	 * 
	 * @author Mark Hammond
	 * @param post
	 *            post object being inserted
	 * @return results integer that represents the results of the insert. If insert
	 *         was made correctly results should be 1.
	 */
	public int insert(Product product) {

		String brand = product.getBrand();
		String model = product.getModel();
		String style = product.getStyle();
		boolean wireless = product.isWireless();
		double price = product.getPrice();
		String desc = product.getDescription();

		int results = -1;

		try {

			String insert = "INSERT INTO " + con.getDBName()
					+ ".product (brand, model, style, wireless, price, description)" + "VALUES ('" + brand + "', '"
					+ model + "', '" + style + "', " + wireless + ", '" + price + "', '" + desc + "')"
					+ " ON DUPLICATE KEY UPDATE productID = -1;";

			PreparedStatement ps = con.getConnection().prepareStatement(insert);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	/**
	 * @author Mark Hammond
	 * @param brand
	 * @return
	 */
	public ArrayList<Product> findByBrand(String brand) {

		ArrayList<Product> productList = null;

		try {

			String select = "SELECT * FROM " + con.getDBName() + ".product WHERE brand='" + brand + "';";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			productList = new ArrayList<Product>();

			int productID = -1;
			brand = "";
			String model = "";
			String style = "";
			boolean wireless = false;
			double price = -1;
			int active = -1;
			String description = "";

			while (rs.next()) {

				productID = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				active = rs.getInt("active");
				description = rs.getString("description");

				productList.add(new Product(productID, brand, model, style, wireless, price, description, active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	/**
	 * @author Mark Hammond
	 * @param model
	 * @return
	 */
	public ArrayList<Product> findByModel(String model) {

		ArrayList<Product> productList = null;

		try {

			String select = "SELECT * FROM " + con.getDBName() + ".product WHERE model='" + model + "';";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			productList = new ArrayList<Product>();

			int productID = -1;
			String brand = "";
			model = "";
			String style = "";
			boolean wireless = false;
			double price = -1;
			int active = -1;
			String description = "";

			while (rs.next()) {

				productID = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				active = rs.getInt("active");
				description = rs.getString("description");
				;

				productList.add(new Product(productID, brand, model, style, wireless, price, description, active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	/**
	 * @author Mark Hammond
	 * @param style
	 * @return
	 */
	public ArrayList<Product> findByStyle(String style) {

		ArrayList<Product> productList = null;

		try {

			String select = "SELECT * FROM " + con.getDBName() + ".product WHERE style='" + style + "';";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			productList = new ArrayList<Product>();

			int productID = -1;
			String brand = "";
			String model = "";
			style = "";
			boolean wireless = false;
			double price = -1;
			int active = -1;
			String description = "";

			while (rs.next()) {

				productID = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				active = rs.getInt("active");
				description = rs.getString("description");

				productList.add(new Product(productID, brand, model, style, wireless, price, description, active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	/**
	 * @author Mark Hammond
	 * @param id
	 * @return
	 */
	public Product findByID(int id) {

		Product product = null;

		try {

			String select = "SELECT * FROM " + con.getDBName() + ".product WHERE productID=" + id + ";";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			id = -1;
			String brand = "";
			String model = "";
			String style = "";
			boolean wireless = false;
			double price = -1;
			int active = -1;
			String description = "";

			while (rs.next()) {

				id = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				active = rs.getInt("active");
				description = rs.getString("description");

				return new Product(id, brand, model, style, wireless, price, description, active);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	/**
	 * @author Mark Hammond
	 * @param min
	 * @param max
	 * @return
	 */
	public ArrayList<Product> findByPrice(double min, double max) {

		ArrayList<Product> productList = null;

		try {

			String select = "SELECT * FROM " + con.getDBName() + ".product WHERE price >=" + min + "AND price <=" + max
					+ ";";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			productList = new ArrayList<Product>();

			int productID = -1;
			String brand = "";
			String model = "";
			String style = "";
			boolean wireless = false;
			double price = -1;
			int active = -1;
			String description = "";

			while (rs.next()) {

				productID = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				active = rs.getInt("active");
				description = rs.getString("description");

				productList.add(new Product(productID, brand, model, style, wireless, price, description, active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;

	}

	/**
	 * @author Mark Hammond
	 * @param prod
	 * @return
	 */
	public ArrayList<Product> findByProduct(Product prod) {

		ArrayList<Product> productList = null;

		String select = "";

		String prodBrand = prod.getBrand();
		String prodModel = prod.getModel();
		String prodStyle = prod.getStyle();
		boolean prodWireless = prod.isWireless();

		// Next series of if statements check what type of products are being requested

		// Wireless and no style
		if (prodWireless && prodStyle.equals("")) {

			// Brand and no model
			if (!prodBrand.equals("") && prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE brand='" + prodBrand + "' AND wireless="
						+ prodWireless + ";";

				// Model and no brand
			} else if (prodBrand.equals("") && !prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE model='" + prodModel + "' AND wireless="
						+ prodWireless + ";";

				// No model and no brand
			} else if (prodBrand.equals("") && prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE wireless=" + prodWireless + ";";

				// Brand and model
			} else if (!prodBrand.equals("") && !prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE brand='" + prodBrand + "' AND wireless="
						+ prodWireless + " AND model='" + prodModel + "';";

			}

			// Style and no wireless
		} else if (!prodStyle.equals("") && !prodWireless) {

			// Brand and no model
			if (!prodBrand.equals("") && prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE brand='" + prodBrand + "' AND style='"
						+ prodStyle + "';";

				// Model and no brand
			} else if (prodBrand.equals("") && !prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE model='" + prodModel + "' AND style='"
						+ prodStyle + "';";

				// No model and no brand
			} else if (prodBrand.equals("") && prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE style='" + prodStyle + "';";

				// Brand and model
			} else if (!prodBrand.equals("") && !prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE brand='" + prodBrand + "' AND style='"
						+ prodStyle + "' AND model='" + prodModel + "';";

			}

			// Wireless and style
		} else if (prodWireless && !prodStyle.equals("")) {

			// Brand and no model
			if (!prodBrand.equals("") && prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE brand='" + prodBrand + "' AND wireless="
						+ prodWireless + " AND style='" + prodStyle + "';";

				// Model and no brand
			} else if (prodBrand.equals("") && !prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE model='" + prodModel + "' AND wireless="
						+ prodWireless + " AND style='" + prodStyle + "';";

				// No model and no brand
			} else if (prodBrand.equals("") && prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE style='" + prodStyle + "' AND wireless="
						+ prodWireless + ";";

				// Brand and model
			} else if (!prodBrand.equals("") && !prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE brand='" + prodBrand + "' AND wireless="
						+ prodWireless + " AND style='" + prodStyle + "' AND model='" + prodModel + "';";

			}

			// No wireless and no style
		} else if (!prodWireless && prodStyle.equals("")) {

			// Brand and no model
			if (!prodBrand.equals("") && prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE brand='" + prodBrand + "';";

				// Model and no brand
			} else if (prodBrand.equals("") && !prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE model='" + prodModel + "';";

				// Brand and model
			} else if (!prodBrand.equals("") && !prodModel.equals("")) {

				select = "SELECT * FROM " + con.getDBName() + ".product WHERE brand='" + prodBrand + "' AND model='"
						+ prodModel + "';";

			}

		}

		try {

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			productList = new ArrayList<Product>();

			int productID = -1;
			String brand = "";
			String model = "";
			String style = "";
			boolean wireless = false;
			double price = -1;
			int active = -1;
			String description = "";

			while (rs.next()) {

				productID = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				active = rs.getInt("active");
				description = rs.getString("description");

				productList.add(new Product(productID, brand, model, style, wireless, price, description, active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;

	}

	public ArrayList<Product> findAllWireless() {

		ArrayList<Product> productList = null;

		try {

			String select = "SELECT * FROM " + con.getDBName() + ".product WHERE wireless=" + true + ";";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			productList = new ArrayList<Product>();

			int productID = -1;
			String brand = "";
			String model = "";
			String style = "";
			boolean wireless = false;
			double price = -1;
			int active = -1;
			String description = "";

			while (rs.next()) {

				productID = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				active = rs.getInt("active");
				description = rs.getString("description");

				productList.add(new Product(productID, brand, model, style, wireless, price, description, active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	public ArrayList<Product> findAllWired() {

		ArrayList<Product> productList = null;

		try {

			String select = "SELECT * FROM " + con.getDBName() + ".product WHERE wireless=" + false + ";";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			productList = new ArrayList<Product>();
			int productID = -1;
			String brand = "";
			String model = "";
			String style = "";
			boolean wireless = false;
			double price = -1;
			int active = -1;
			String description = "";

			while (rs.next()) {

				productID = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				active = rs.getInt("active");
				description = rs.getString("description");

				productList.add(new Product(productID, brand, model, style, wireless, price, description, active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;

	}

	public ArrayList<Product> findAllProducts() {

		ArrayList<Product> productList = null;

		try {

			String select = "SELECT * FROM " + con.getDBName() + ".product;";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			productList = new ArrayList<Product>();

			int productID = -1;
			String brand = "";
			String model = "";
			String style = "";
			boolean wireless = false;
			double price = -1;
			int active = -1;
			String description = "";

			while (rs.next()) {

				productID = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				active = rs.getInt("active");
				description = rs.getString("description");

				productList.add(new Product(productID, brand, model, style, wireless, price, description, active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	public ArrayList<Product> findMostRecent() {

		ArrayList<Product> productList = null;

		try {

			String select = "SELECT * FROM headphonesdb.product ORDER BY productID DESC;";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			productList = new ArrayList<Product>();

			int productID = -1;
			String brand = "";
			String model = "";
			String style = "";
			boolean wireless = false;
			double price = -1;
			int active = -1;
			String description = "";

			while (rs.next()) {

				productID = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				active = rs.getInt("active");
				description = rs.getString("description");

				productList.add(new Product(productID, brand, model, style, wireless, price, description, active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	public int delete(Product prod) {

		int results = -1;

		try {

			String delete = "DELETE FROM " + con.getDBName() + ".product WHERE productID=" + prod.getProductID() + ";";

			PreparedStatement ps = con.getConnection().prepareStatement(delete);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	public int update(Product prod) {

		int productID = prod.getProductID();
		String brand = prod.getBrand();
		String model = prod.getModel();
		String style = prod.getStyle();
		boolean wireless = prod.isWireless();
		double price = prod.getPrice();
		String desc = prod.getDescription();
		int active = prod.getActive();

		int results = -1;

		try {

			String update = "UPDATE headphonesdb.product SET brand='" + brand + "', model='" + model + "', style='"
					+ style + "', wireless=" + wireless + ", price=" + price + ", active=" + active + ", description='"
					+ desc + "' WHERE productID=" + productID + ";";

			PreparedStatement ps = con.getConnection().prepareStatement(update);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;

	}

	public ArrayList<Product> findMostRecent(int max) {

		ArrayList<Product> productList = null;

		try {

			String select = "SELECT * FROM headphonesdb.product ORDER BY productID DESC;";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			productList = new ArrayList<Product>();

			int productID = -1;
			String brand = "";
			String model = "";
			String style = "";
			boolean wireless = false;
			double price = -1;
			String description = "";
			int active = -1;

			int count = 0;

			while (rs.next() && count <= max) {

				productID = rs.getInt("productID");
				brand = rs.getString("brand");
				model = rs.getString("model");
				style = rs.getString("style");
				wireless = rs.getBoolean("wireless");
				price = rs.getDouble("price");
				description = rs.getString("description");
				active = rs.getInt("active");

				productList.add(new Product(productID, brand, model, style, wireless, price, description, active));

				count++;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	public boolean exists(Product prod) {

		String brand = prod.getBrand();
		String model = prod.getModel();
		boolean wireless = prod.isWireless();
		String style = prod.getStyle();

		try {

			String select = "SELECT * FROM " + con.getDBName() + ".product WHERE brand='" + brand + "' AND model='"
					+ model + "' AND wireless='" + wireless + "' AND style='" + style + "';";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public int deactivate(int productID) {

		int results = -1;

		try {

			String update = "UPDATE headphonesdb.product set active=0 where productID=" + productID + ";";

			PreparedStatement ps = con.getConnection().prepareStatement(update);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;

	}

	public DBConnect getDBConnect() {
		return con;
	}
}
