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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	
	@ManyToMany(mappedBy = "carts",cascade = CascadeType.PERSIST)
	private List<Product> products;
	
	@OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Usersd user;

	public Cart() {
		super();
		this.products=new ArrayList<>();
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
