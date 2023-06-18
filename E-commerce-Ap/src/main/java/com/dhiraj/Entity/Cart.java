package com.dhiraj.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	
	private Boolean cPresent;
	
	@ManyToMany(mappedBy = "carts",cascade = CascadeType.PERSIST)
	private List<Product> products;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private Usersd user;

	public Cart() {
		super();
		this.products=new ArrayList<>();
		this.cPresent=true;	
		
	}



	public Boolean getcPresent() {
		return cPresent;
	}



	public void setcPresent(Boolean cPresent) {
		this.cPresent = cPresent;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public List<Product> getList() {
		return products;
	}

	public void setList(List<Product> list) {
		this.products = list;
	}

	public Usersd getUser() {
		return user;
	}

	public void setUser(Usersd user) {
		this.user = user;
	}
	
	
	
}
