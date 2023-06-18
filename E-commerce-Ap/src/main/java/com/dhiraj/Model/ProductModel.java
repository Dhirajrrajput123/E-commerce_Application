package com.dhiraj.Model;

public class ProductModel {
	
	private String name;
	private int price;
	private int quantity;
	private Boolean present;
	
	
	public ProductModel(String name, int price, int quantity, Boolean present) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.present = present;
	}
	public ProductModel() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Boolean getPresent() {
		return present;
	}
	public void setPresent(Boolean present) {
		this.present = present;
	}
	@Override
	public String toString() {
		return "ProductModel [name=" + name + ", price=" + price + ", quantity=" + quantity + ", present=" + present
				+ "]";
	}
	
	
}
