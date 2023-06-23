package com.dhiraj.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.Entity.Orders;
import com.dhiraj.Exception.CartException;
import com.dhiraj.Exception.OrderException;

@RestController
public interface OrderController {

    public ResponseEntity<Orders> makeOrderController() throws OrderException, CartException;
	
	public ResponseEntity<Orders> placedOrdersController(int oId) throws OrderException;
	
	public ResponseEntity<List<Orders>> totalOrdersByUserController() throws OrderException;
	
	public ResponseEntity<List<Orders>> totalOrdersController() throws OrderException;
	
	public ResponseEntity<List<Orders>> totalOrderPandingToPlacedController() throws OrderException;
	
	public ResponseEntity<Orders> getOrderByIdController(int oId) throws OrderException;
}
