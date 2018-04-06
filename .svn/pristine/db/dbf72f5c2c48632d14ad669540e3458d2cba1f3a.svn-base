package edu.ben.model;

import java.util.ArrayList;

public class Order {

	private int orderID;
	private int userID;
	private String orderDate;
	private String shipDate;
	private ArrayList<Product> products;
	private int active;
	private boolean shipped = false;

	public Order(int userID, String orderDate, String shipDate) {

		this.userID = userID;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.products = new ArrayList<Product>();
		this.active = 1;
		this.shipped = false;

	}

	public Order(int orderID, int userID, String orderDate, String shipDate, int active, boolean shipped) {

		this.orderID = orderID;
		this.userID = userID;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.products = new ArrayList<Product>();
		this.active = active;
		this.shipped = shipped;

	}

	public double getProductCost() {

		double cost = 0;
		if (products.size() > 0) {
			for (Product p : products) {
				cost += p.getPrice();
			}
		}
		return cost;

	}

	@Override
	public boolean equals(Object o) {

		Order secondOrder = (Order) o;

		return this.orderID == secondOrder.getOrderID();
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	public void removeProduct(Product p) {
		products.remove(p);
	}

	public boolean isShipped() {
		return shipped;
	}

	public void setShipped(boolean s) {
		this.shipped = s;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public int getOrderID() {
		return orderID;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int a) {
		active = a;
	}

}
