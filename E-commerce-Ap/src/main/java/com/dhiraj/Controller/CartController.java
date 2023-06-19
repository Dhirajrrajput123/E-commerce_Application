package com.dhiraj.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.Entity.Cart;
import com.dhiraj.Exception.CartException;
import com.dhiraj.Exception.ProductException;

@RestController
public interface CartController {

    public ResponseEntity<Cart> saveCartController(Cart cart) throws CartException;
	
	public ResponseEntity<Cart> updateCartController(int pId,int cid) throws CartException ,ProductException;
	
	public ResponseEntity<Cart> deActiveCartController(int cid) throws CartException;
	
	public ResponseEntity<List<Cart>> findAllcartController() throws CartException;
	
	public ResponseEntity<Cart> findCartByUserIdController() throws CartException;
	
	public ResponseEntity<Cart> findByIdController(int cid) throws CartException;
}
