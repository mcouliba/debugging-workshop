package com.redhat.cloudnative.model;

public class Product implements java.io.Serializable {
    static final long serialVersionUID = 1L;

   private String itemId;
	private String name;
	private String description;
	private double price;
	
	public Product() {
		
	}
	
	public Product(String itemId, String name, String description, double price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [itemId=" + itemId + ", name=" + name + ", desc="
				+ description + ", price=" + price + "]";
	}
}
