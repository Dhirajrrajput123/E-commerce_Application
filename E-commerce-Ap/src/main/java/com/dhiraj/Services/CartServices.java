package com.dhiraj.Services;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhiraj.Entity.Cart;
import com.dhiraj.Exception.CartException;
import com.dhiraj.Exception.ProductException;

@Service
@Transactional
public interface CartServices {

	public Cart saveCart(Cart cart) throws CartException;
	
	public Cart updateCart(int pId,int cid) throws CartException ,ProductException;
	
	public Cart deactiveCart(int cid) throws CartException;
	
	public List<Cart> findAllcart() throws CartException;
	
	public Cart findCartByUserId() throws CartException;
	
	public Cart findById(int cid) throws CartException;
	
}
