package edu.ben.DAO.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.ben.DAO.OrderDAO;
import edu.ben.model.Order;

public class OrderDAOTest {

	public OrderDAO dao = new OrderDAO();

	@Test
	public void test() {
		ArrayList<Order> orders = dao.findByUserID(1);
		System.out.println(orders.get(0).getProducts().get(1).getBrand());
	}

}
