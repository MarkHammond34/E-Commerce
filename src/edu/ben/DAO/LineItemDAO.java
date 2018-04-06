package edu.ben.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.ben.model.LineItem;

public class LineItemDAO {

	private DBConnect con;

	public LineItemDAO() {
		con = new DBConnect();
	}

	public int update(LineItem item) {

		int results = -1;

		try {

			String update = "UPDATE headphonesdb.line_item SET orderID=" + item.getOrderID() + ", productID="
					+ item.getProductID() + ", quantity=" + item.getQuantity() + " WHERE orderID=" + item.getOrderID()
					+ " AND productID=" + item.getProductID() + ";";

			PreparedStatement ps = con.getConnection().prepareStatement(update);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

}
