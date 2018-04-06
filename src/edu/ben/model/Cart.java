package edu.ben.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author saani
 *
 */
public class Cart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7497800319115812845L;
	
	private HashMap<Product, Integer> cartQty;
	private ArrayList<Product> cart;
	private int size;
	private double total;
	
	public Cart() {
		cart = new ArrayList<Product>();
		cartQty = new HashMap<Product, Integer>();
		size = cart.size();
		total = 0;
	}
	
	public void remove(Product p) {
		int qty = cartQty.get(p);
		
		cartQty.remove(p);
		cart.remove(p);
		size = cart.size();
		
		total -= (p.getPrice() * qty);
		
	}
	
	public void clear() {
		cart = new ArrayList<Product>();
		cartQty = new HashMap<Product, Integer>();
		size = cart.size();
		total = 0;
	}
	
	public void addToCart(Product p, Integer i) {
		if (!cart.contains(p)) {
			
			cart.add(p);
			cartQty.put(p, i);
			size = cart.size();
			total += (p.getPrice() * i);
			
			System.out.println("adding product for the first time");
		} else {
			
			Integer amt = cartQty.get(p);
			cartQty.put(p, amt+i);
			System.out.println("prod already in that cart yall");
			total += (p.getPrice() * i);
		}
		
	}
	
	public void addToCart(Product p) {
		
	
		if (!cartQty.containsKey(p)) {
			cart.add(p);
			cartQty.put(p, 1);
			size = cart.size();
			
		} else {
			Integer amt = cartQty.get(p);
			cartQty.put(p, amt++);
			size = cart.size();
		}
		
		total += p.getPrice();
		
	}
	
	public void addToCart(List<Product> list) {
		for (Product product: list) {
			if (cartQty.containsKey(product)) {
				Integer amt = cartQty.get(product);
				cartQty.put(product, amt++);
				// dont change size here
				// dont add to list of products (cart) here
			} else {
				addToCart(product);
			}
			
			total += product.getPrice();
			
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int s) {
		size = s;
	}
	
	public ArrayList<Product> getCart() {
		return cart;
	}
	
	public void setCart(ArrayList<Product> list) {
		cart = list;
	}
	
	public HashMap<Product, Integer> getCartQty() {
		return cartQty;
	}
	
	public void setCartQty(HashMap<Product, Integer> cart) {
		this.cartQty = cart;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < cart.size(); i++) {
			Product p = cart.get(i);
			int qty = cartQty.get(p);
			double subtotal = qty * p.getPrice();
			s += qty + " " + p.toString() + ": $" + subtotal + "<br>";
		}
		s += "total = $" + total + "<br>";
		return s;
	}
	
	
}
