package edu.ben.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ben.model.User;

public class UserDAO {

	DBConnect con = null;
	PreparedStatement ps = null;

	public UserDAO() {

		con = new DBConnect();
	}

	public int insertUser(User user) {

		int results = -1;

		String first = user.getFirstName();
		String last = user.getLastName();
		String pass = user.getPassword();
		String email = user.getEmail();
		int admin = user.getAdmin();

		try {

			String sql = "INSERT INTO HeadphonesDB.User (firstName, lastName, password, email, admin, active) VALUES('"
					+ first + "','" + last + "','" + pass + "','" + email + "', " + admin
					+ ", 1) ON DUPLICATE KEY UPDATE userID = -1;";
			ps = con.getConnection().prepareStatement(sql);
			results = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	public User findUserByEmail(String email) {

		User user = null;

		try {

			String sql = "SELECT * FROM HeadphonesDB.User WHERE email='" + email + "';";

			ResultSet rs = con.getConnection().prepareStatement(sql).executeQuery();

			int userID = -1;
			String firstName = "";
			String lastName = "";
			String password = "";
			long lastLogin = 0;
			int failedAttempts = 0;
			int admin = -1;
			int active = -1;

			while (rs.next()) {

				userID = rs.getInt("userID");
				firstName = rs.getString("firstName");
				lastName = rs.getString("lastName");
				password = rs.getString("password");
				email = rs.getString("email");
				lastLogin = rs.getLong("last_failed_login");
				failedAttempts = rs.getInt("failed_login_attempts");
				admin = rs.getInt("admin");
				active = rs.getInt("active");

			}

			if (userID != -1) {
				user = new User(userID, firstName, lastName, email, password, admin, lastLogin, failedAttempts, active);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}

	public void setLastFailedLogin(String email, long lastLogin) {

		String sql = "UPDATE HeadphonesDB.user SET last_failed_login='" + lastLogin + "' WHERE email='" + email + "';";

		PreparedStatement statement = null;

		try {

			statement = con.getConnection().prepareStatement(sql);
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setFailedLoginAttempts(String email, int failedAttempts) {

		String sql = "UPDATE HeadphonesDB.user SET failed_login_attempts='" + failedAttempts + "' WHERE email='" + email
				+ "';";

		PreparedStatement statement = null;

		try {

			statement = con.getConnection().prepareStatement(sql);
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<User> findMostRecent(int max) {

		ArrayList<User> users = null;

		try {

			String sql = "SELECT * FROM HeadphonesDB.User WHERE active=1;";

			ResultSet rs = con.getConnection().prepareStatement(sql).executeQuery();

			int userID = -1;
			String firstName = "";
			String lastName = "";
			String password = "";
			long lastLogin = 0;
			int failedAttempts = 0;
			int admin = -1;
			int active = -1;
			String email = "";

			users = new ArrayList<User>();

			int count = 0;

			while (rs.next() && count <= max) {

				userID = rs.getInt("userID");
				firstName = rs.getString("firstName");
				lastName = rs.getString("lastName");
				password = rs.getString("password");
				email = rs.getString("email");
				lastLogin = rs.getLong("last_failed_login");
				failedAttempts = rs.getInt("failed_login_attempts");
				admin = rs.getInt("admin");
				active = rs.getInt("active");

				count++;

				users.add(new User(userID, firstName, lastName, password, email, admin, lastLogin, failedAttempts,
						active));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return users;

	}

	public ArrayList<User> findAllUsers() {

		ArrayList<User> users = null;

		try {

			String sql = "SELECT * FROM HeadphonesDB.User;";

			ResultSet rs = con.getConnection().prepareStatement(sql).executeQuery();

			int userID = -1;
			String firstName = "";
			String lastName = "";
			String password = "";
			long lastLogin = 0;
			int failedAttempts = 0;
			int admin = -1;
			int active = -1;
			String email = "";

			users = new ArrayList<User>();

			while (rs.next()) {

				userID = rs.getInt("userID");
				firstName = rs.getString("firstName");
				lastName = rs.getString("lastName");
				password = rs.getString("password");
				email = rs.getString("email");
				lastLogin = rs.getLong("last_failed_login");
				failedAttempts = rs.getInt("failed_login_attempts");
				admin = rs.getInt("admin");
				active = rs.getInt("active");

				users.add(new User(userID, firstName, lastName, email, password, admin, lastLogin, failedAttempts,
						active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return users;

	}

	public ArrayList<User> findAllActiveUsers() {

		ArrayList<User> users = null;

		try {

			String sql = "SELECT * FROM HeadphonesDB.User WHERE active=1;";

			ResultSet rs = con.getConnection().prepareStatement(sql).executeQuery();

			int userID = -1;
			String firstName = "";
			String lastName = "";
			String password = "";
			long lastLogin = 0;
			int failedAttempts = 0;
			int admin = -1;
			int active = -1;
			String email = "";

			users = new ArrayList<User>();

			while (rs.next()) {

				userID = rs.getInt("userID");
				firstName = rs.getString("firstName");
				lastName = rs.getString("lastName");
				password = rs.getString("password");
				email = rs.getString("email");
				lastLogin = rs.getLong("last_failed_login");
				failedAttempts = rs.getInt("failed_login_attempts");
				admin = rs.getInt("admin");
				active = rs.getInt("active");

				users.add(new User(userID, firstName, lastName, email, password, admin, lastLogin, failedAttempts,
						active));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return users;

	}

	public int update(User user) {

		int userID = user.getUserID();
		String fName = user.getFirstName();
		String lName = user.getLastName();
		String email = user.getEmail();
		String password = user.getPassword();
		int admin = user.getAdmin();
		long lastLogin = user.getLastLogin();
		int failedAttempts = user.getFailedAttempts();
		int active = user.getActive();

		int results = -1;

		try {

			String update = "UPDATE headphonesdb.user SET firstName='" + fName + "', lastName='" + lName + "', email='"
					+ email + "', password='" + password + "', admin=" + admin + ", last_failed_login=" + lastLogin
					+ ", active=" + active + ", failed_login_attempts=" + failedAttempts + " WHERE userID=" + userID
					+ ";";

			PreparedStatement ps = con.getConnection().prepareStatement(update);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	public int delete(int userID) {

		int results = -1;

		try {

			String delete = "DELETE FROM headphonesdb.user WHERE userID=" + userID + ";";

			PreparedStatement ps = con.getConnection().prepareStatement(delete);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	public int deactiveate(int userID) {

		int results = -1;

		try {

			String delete = "UPDATE headphonesdb.user SET active=0 WHERE userID=" + userID + ";";

			PreparedStatement ps = con.getConnection().prepareStatement(delete);
			results = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}
}
