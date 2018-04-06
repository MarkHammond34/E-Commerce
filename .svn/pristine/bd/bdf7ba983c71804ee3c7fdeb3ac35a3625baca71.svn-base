package edu.ben.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ben.model.Order;
import edu.ben.model.Product;

public class OrderDAO {

	private DBConnect con;

	public OrderDAO() {
		con = new DBConnect();
	}

	public int insert(Order order) {

		int userID = order.getUserID();
		String orderTimestamp = order.getOrderDate();
		String shipDate = order.getShipDate();

		int results = -1;

		try {

			String insert = "INSERT INTO headphonesdb.order (userID, orderDate, shipDate)" + "VALUES (" + userID + ", '"
					+ orderTimestamp + ", '" + shipDate + "')" + " ON DUPLICATE KEY UPDATE userID = -1;";

			PreparedStatement ps = con.getConnection().prepareStatement(insert);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	public int update(Order order) {

		int orderID = order.getOrderID();
		int userID = order.getUserID();
		String orderTimestamp = order.getOrderDate();
		String shipDate = order.getShipDate();
		int active = order.getActive();

		int results = -1;

		try {

			String orderUpdate = "UPDATE headphonesdb.order SET orderID=" + orderID + ", userID=" + userID
					+ ", orderDate='" + orderTimestamp + "', shipDate='" + shipDate + "', active=" + active
					+ " WHERE orderID=" + orderID + ";";

			PreparedStatement ps = con.getConnection().prepareStatement(orderUpdate);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;

	}

	public int delete(Order order) {

		int orderID = order.getOrderID();

		int results = -1;

		try {

			String delete = "DELETE FROM headphonesdb.order WHERE orderID=" + orderID + ";";

			PreparedStatement ps = con.getConnection().prepareStatement(delete);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	public ArrayList<Order> findByUserID(int userID) {

		ArrayList<Order> orders = null;

		try {

			String select = "select o.orderID, o.userID, o.orderDate, o.shipDate, o.shipped, "
					+ "o.active, p.productID, p.brand, p.model, p.style, p.wireless, p.price, "
					+ "p.description, l.quantity from headphonesdb.order as o join "
					+ "headphonesdb.line_item as l on o.orderID=l.orderID join headphonesdb.product "
					+ "as p on p.productID=l.productID where userID=" + userID + ";";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			orders = new ArrayList<Order>();

			userID = -1;
			int orderID = -1;
			String orderDate = "";
			String shipDate = "";
			int active = -1;
			boolean shipped = false;

			int productID = -1;
			int quantity = -1;

			String brand = "";
			String model = "";
			double price = -1;

			while (rs.next()) {

				orderID = rs.getInt("orderID");
				userID = rs.getInt("userID");
				orderDate = rs.getString("orderDate");
				shipDate = rs.getString("shipDate");
				active = rs.getInt("active");
				shipped = rs.getBoolean("shipped");

				productID = rs.getInt("productID");
				quantity = rs.getInt("quantity");

				brand = rs.getString("brand");
				model = rs.getString("model");
				price = rs.getDouble("price");

				Order order = new Order(orderID, userID, orderDate, shipDate, active, shipped);
				Product prod = new Product(productID, brand, model, "", false, price, "", 1);

				// Checks if order was already added because of duplication
				if (!orders.contains(order)) {

					orders.add(order);
					prod.setQuantity(quantity);
					orders.get(orders.size() - 1).addProduct(prod);

				} else {
					prod.setQuantity(quantity);
					orders.get(orders.size() - 1).addProduct(prod);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;
	}

	public Order findByOrderID(int orderID) {

		Order order = null;

		try {

			String select = "select * from headphonesdb.order where orderID=" + orderID + ";";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			int userID = -1;
			orderID = -1;
			String orderDate = "";
			String shipDate = "";
			int active = -1;
			boolean shipped = false;

			while (rs.next()) {

				orderID = rs.getInt("orderID");
				userID = rs.getInt("userID");
				orderDate = rs.getString("orderDate");
				shipDate = rs.getString("shipDate");
				active = rs.getInt("active");
				shipped = rs.getBoolean("shipped");

				order = new Order(orderID, userID, orderDate, shipDate, active, shipped);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;
	}

	public ArrayList<Order> findAllOrders() {

		ArrayList<Order> orders = null;

		try {

			String select = "select o.orderID, o.userID, o.orderDate, o.shipDate, o.shipped, o.active, p.productID, "
					+ "p.brand, p.model, p.style, p.wireless, p.price, p.description, l.quantity from headphonesdb.order "
					+ "as o join headphonesdb.line_item as l on o.orderID=l.orderID join headphonesdb.product as p on "
					+ "p.productID=l.productID;";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			orders = new ArrayList<Order>();

			int userID = -1;
			int orderID = -1;
			String orderDate = "";
			String shipDate = "";
			int active = -1;
			boolean shipped = false;

			int productID = -1;
			int quantity = -1;

			String brand = "";
			String model = "";
			double price = -1;

			while (rs.next()) {

				orderID = rs.getInt("orderID");
				userID = rs.getInt("userID");
				orderDate = rs.getString("orderDate");
				shipDate = rs.getString("shipDate");
				active = rs.getInt("active");
				shipped = rs.getBoolean("shipped");

				productID = rs.getInt("productID");
				quantity = rs.getInt("quantity");

				brand = rs.getString("brand");
				model = rs.getString("model");
				price = rs.getDouble("price");

				Order order = new Order(orderID, userID, orderDate, shipDate, active, shipped);
				Product prod = new Product(productID, brand, model, "", false, price, "", 1);

				// Checks if order was already added because of duplication
				if (!orders.contains(order)) {

					orders.add(order);
					prod.setQuantity(quantity);
					orders.get(orders.size() - 1).addProduct(prod);

				} else {
					prod.setQuantity(quantity);
					orders.get(orders.size() - 1).addProduct(prod);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;
	}

	public ArrayList<Order> findMostRecent(int max) {

		ArrayList<Order> orders = null;

		try {

			String select = "select o.orderID, o.userID, o.orderDate, o.shipDate, o.shipped, o.active, "
					+ "p.productID, p.brand, p.model, p.style, p.wireless, p.price, p.description, l.quantity"
					+ "from headphonesdb.order as o join headphonesdb.line_item as l on o.orderID=l.orderID"
					+ "join headphonesdb.product as p on p.productID=l.productID;";

			ResultSet rs = con.getConnection().prepareStatement(select).executeQuery();

			orders = new ArrayList<Order>();

			int userID = -1;
			int orderID = -1;
			String orderDate = "";
			String shipDate = "";
			int active = -1;
			boolean shipped = false;

			int productID = -1;
			int quantity = -1;

			String brand = "";
			String model = "";
			double price = -1;

			while (rs.next() && max > 0) {

				orderID = rs.getInt("orderID");
				userID = rs.getInt("userID");
				orderDate = rs.getString("orderDate");
				shipDate = rs.getString("shipDate");
				active = rs.getInt("active");
				shipped = rs.getBoolean("shipped");

				productID = rs.getInt("productID");
				quantity = rs.getInt("quantity");

				brand = rs.getString("brand");
				model = rs.getString("model");
				price = rs.getDouble("price");

				Order order = new Order(orderID, userID, orderDate, shipDate, active, shipped);
				Product prod = new Product(productID, brand, model, "", false, price, "", 1);

				// Checks if order was already added because of duplication
				if (!orders.contains(order)) {

					orders.add(order);
					prod.setQuantity(quantity);
					orders.get(orders.size() - 1).addProduct(prod);

				} else {
					prod.setQuantity(quantity);
					orders.get(orders.size() - 1).addProduct(prod);
				}

				max--;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;
	}

	public int deactivate(int orderID) {

		int results = -1;

		try {

			String update = "UPDATE headphonesdb.order SET active=0 where orderID=" + orderID + ";";

			PreparedStatement ps = con.getConnection().prepareStatement(update);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}
}
