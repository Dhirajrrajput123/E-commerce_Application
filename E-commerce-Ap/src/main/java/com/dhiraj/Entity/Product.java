package com.dhiraj.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String name;
	private int price;
	private int quantity;
	private Boolean present;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Cart> carts;
	
	
	
	public Product(String name, int price, int quantity) {
		super();
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.carts=new ArrayList<>();
		if(quantity>0) {
			this.present=true;			
		}
		else {
			this.present=false;
		}
		System.out.println("hello i am dhiraj");
	}
	public Product() {
		super();
		System.out.println("hello i am not dhiraj");
	}
	
	
	
	public Boolean getPresent() {
		return present;
	}
	public void setPresent(Boolean present) {
		this.present = present;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	
	
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
}
