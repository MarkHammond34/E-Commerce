package edu.ben.utilities;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

import edu.ben.DAO.ProductDAO;
import edu.ben.DAO.UserDAO;
import edu.ben.model.Product;
import edu.ben.model.User;

public class ImportFile {

	public final static int ALL_RECORDS_ADDED = 100;
	public final static int SOME_RECORDS_ADDED = 101;
	public final static int NO_RECORDS_ADDED = 102;
	public final static int INVALID_FILE = 200;
	public final static int INVALID_FILE_FORMAT = 201;

	public static int importProducts(InputStream fileStream) {

		ProductDAO dao = new ProductDAO();
		Scanner input = null;

		try {
			input = new Scanner(fileStream);
		} catch (Exception e) {
			return INVALID_FILE;
		}

		String[] temp;
		int inserted = 0;
		int errors = 0;

		String brand = "";
		String model = "";
		String style = "";
		String tech = "";
		String description = "";
		double price = -1;
		boolean wireless = false;

		while (input.hasNext()) {

			String line = input.nextLine();
			temp = line.split(",");

			brand = temp[0];
			model = temp[1];
			style = temp[2];
			tech = temp[3];

			try {
				price = Double.parseDouble(temp[4]);
			} catch (Exception e) {
				return INVALID_FILE_FORMAT;
			}

			description = temp[5];

			if (tech.toLowerCase().equals("wireless")) {
				wireless = true;
			}

			if (validProductInput(brand, model, style, price, description)) {
				if (dao.insert(new Product(brand, model, style, wireless, price, description)) == 1) {
					inserted++;
				} else {
					errors++;
				}
			} else {
				errors++;
			}
		}

		input.close();

		if (inserted > 0 && errors == 0) {
			return ALL_RECORDS_ADDED;
		} else if (inserted > 0 && errors > 0) {
			return SOME_RECORDS_ADDED;
		} else {
			return NO_RECORDS_ADDED;
		}

	}

	public static int importUsers(InputStream fileStream) {

		UserDAO dao = new UserDAO();
		Scanner input = null;

		try {
			input = new Scanner(fileStream);
		} catch (Exception e) {
			return INVALID_FILE;
		}

		String[] temp;
		int inserted = 0;
		int errors = 0;

		String firstName = "";
		String lastName = "";
		String password = "";
		String email = "";
		int admin = -1;
		int active = -1;

		while (input.hasNext()) {

			String line = input.nextLine();
			temp = line.split(",");

			firstName = temp[0];
			lastName = temp[1];
			password = temp[2];
			email = temp[3];

			try {
				admin = Integer.parseInt(temp[4]);
				active = Integer.parseInt(temp[5]);
			} catch (Exception e) {
				return INVALID_FILE_FORMAT;
			}

			if (validUserInput(firstName, lastName, password, email, admin, active)) {
				if (dao.insertUser(new User(firstName, lastName, email, password, admin, active)) == 1) {
					inserted++;
				} else {
					errors++;
				}
			} else {
				errors++;
			}

		}

		input.close();

		if (inserted > 0 && errors == 0) {
			return ALL_RECORDS_ADDED;
		} else if (inserted > 0 && errors > 0) {
			return SOME_RECORDS_ADDED;
		} else {
			return NO_RECORDS_ADDED;
		}

	}

	private static boolean validProductInput(String brand, String model, String style, double price, String desc) {

		if (brand.length() >= 30 || brand.length() < 1) {
			return false;
		} else if (model.length() >= 30 || model.length() < 1) {
			return false;
		} else if (price >= 1000 || price <= 0) {
			return false;
		} else if (desc.length() >= 200 || desc.length() < 1) {
			return false;
		}

		return true;
	}

	private static boolean validUserInput(String firstName, String lastName, String password, String email, int admin,
			int active) {

		if (firstName.length() < 0 || firstName.length() > 45) {
			return false;
		} else if (lastName.length() < 0 || lastName.length() > 45) {
			return false;
		} else if (password.length() < 0 || password.length() > 20) {
			return false;
		} else if (email.length() < 5 || !email.contains("@") || !email.contains(".")) {
			return false;
		} else if (admin < 0 || admin > 2) {
			return false;
		} else if (active < 0 || active > 1) {
			return false;
		}

		return true;
	}

}
