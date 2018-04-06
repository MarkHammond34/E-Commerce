package edu.ben.DAO.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.DAO.ProductDAO;
import edu.ben.model.Product;

public class ProductDAOTest {

	@Test
	public void test() {
		ProductDAO pdao = new ProductDAO();
		pdao.insert(new Product("Test", "Test", "over-ear", true, 200, "desc"));
	}
	
	@Test
	public void recentTest() {
		ProductDAO pdao = new ProductDAO();
		pdao.findMostRecent(10);
	}

}
