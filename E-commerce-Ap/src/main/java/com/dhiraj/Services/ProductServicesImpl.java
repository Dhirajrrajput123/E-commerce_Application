package com.dhiraj.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhiraj.Entity.Product;
import com.dhiraj.Exception.ProductException;
import com.dhiraj.Model.ProductModel;
import com.dhiraj.Repository.ProductDao;

@Service
public class ProductServicesImpl  implements ProductServices{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product SaveProduct(Product product) throws ProductException {
		
		if(product==null) throw new ProductException("can't save null value");
		
		if(productDao.findById(product.getPid()).isPresent()) throw new ProductException("This Product is already Present "+product.toString());
		
		Product saveProduct=productDao.save(product);
		
		return saveProduct;
	}

	@Override
	public String deleteProduct(int id) throws ProductException {
		// TODO Auto-generated method stub
		
		Optional<Product> product=productDao.findById(id);
		
		if(product.isEmpty()) throw new ProductException("Product Not Present in this product id  **"+id+"** so can not delete Product");
		
		productDao.delete(product.get());
		
		return "Product deleted Successfully. Product detail is :- "+product.get().toString();
	}

	@Override
	public Product updateProduct(ProductModel productModel, int id) throws ProductException {
		
        Optional<Product> product=productDao.findById(id);
		
		if(product.isEmpty()) throw new ProductException("Product Not Present in this product id  **"+id+"** so can not Update Product");
		 
		Product exsitingProduct=product.get();
		
		exsitingProduct.setName(productModel.getName());
		exsitingProduct.setPrice(productModel.getPrice());
		exsitingProduct.setQuantity(productModel.getQuantity());
		exsitingProduct.setPresent(productModel.getPresent());		
		
		
		return productDao.save(exsitingProduct);
	}

	@Override
	public Product readProduct(int id) throws ProductException {
		// TODO Auto-generated method stub
		
        Optional<Product> product=productDao.findById(id);
		
		if(product.isEmpty()) throw new ProductException("Product Not Present in this product id  **"+id+"** ");
		
		return product.get();
	}
	
	
	

}
