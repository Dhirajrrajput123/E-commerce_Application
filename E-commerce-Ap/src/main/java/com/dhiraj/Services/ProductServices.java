package com.dhiraj.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dhiraj.Entity.Product;
import com.dhiraj.Exception.ProductException;
import com.dhiraj.Model.ProductModel;

@Service
public interface ProductServices {

	public Product SaveProduct(Product product) throws ProductException;
	
	public String deleteProduct(int id) throws ProductException;
	
	public Product updateProduct(ProductModel productModel, int id ) throws ProductException;
	
	public Product readProduct(int id) throws ProductException;
	
	public List<Product> findAllProduct() throws ProductException;
}
