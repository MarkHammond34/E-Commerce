package edu.ben.model;

public class Product {

	private int productID;
	private String brand;
	private String model;
	private String style;
	private boolean wireless;
	private double price;
	private String description;
	private int active;
	private int quantity;

	public Product(int productID, String brand, String model, String style, boolean wireless, double price, String desc,
			int active) {

		this.productID = productID;
		this.brand = brand;
		this.model = model;
		this.style = style;
		this.wireless = wireless;
		this.price = price;
		this.description = desc;
		this.active = active;

	}

	public Product(String brand, String model, String style, boolean wireless, double price, String desc) {

		this.productID = -1;
		this.brand = brand;
		this.model = model;
		this.style = style;
		this.wireless = wireless;
		this.price = price;
		this.description = desc;
		this.active = 1;

	}

	public void setQuantity(int q) {
		this.quantity = q;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}

	public void setProductID(int i) {
		productID = i;
	}

	public int getProductID() {
		return productID;
	}

	public void setBrand(String s) {
		brand = s;
	}

	public String getBrand() {
		return brand;
	}

	public void setModel(String m) {
		model = m;
	}

	public String getModel() {
		return model;
	}

	public void setStyle(String s) {
		style = s;
	}

	public String getStyle() {
		return style;
	}

	public void setPrice(double d) {
		price = d;
	}

	public double getPrice() {
		return price;
	}

	public boolean isWireless() {
		return wireless;
	}

	public void setDescription(String ss) {
		description = ss;
	}

	public String getDescription() {
		return description;
	}

	public String toString() {
		return style + " " + model + " " + brand;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Product) {
			Product other = (Product) obj;

			if (style.equals(other.getStyle()) && model.equals(other.getModel()) && brand.equals(other.getBrand())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		char[] arr = toString().toCharArray();
		int sum = 0;
		for (int letter : arr) {
			sum += letter;
		}
		return sum;

	}

}
