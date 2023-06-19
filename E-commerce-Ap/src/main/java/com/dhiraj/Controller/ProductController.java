package com.dhiraj.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.Entity.Product;
import com.dhiraj.Exception.ProductException;
import com.dhiraj.Model.ProductModel;

@RestController
public interface ProductController {

    public ResponseEntity<Product> SaveProduct(Product product)  throws ProductException ;
	
	public ResponseEntity<String> deleteProduct(int id) throws ProductException;
	
	public ResponseEntity<Product> updateProduct(ProductModel productModel, int id ) throws ProductException;
	
	public ResponseEntity<Product> readProduct(int id) throws ProductException;
	
	public  ResponseEntity<List<Product>> findAllProductcont() throws ProductException;
}
