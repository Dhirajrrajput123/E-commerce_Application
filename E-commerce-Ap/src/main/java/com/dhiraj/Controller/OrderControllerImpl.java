package com.dhiraj.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.Entity.Orders;
import com.dhiraj.Exception.CartException;
import com.dhiraj.Exception.OrderException;
import com.dhiraj.Services.OrderServices;

@RestController
@RequestMapping("/order")
public class OrderControllerImpl implements OrderController{

	@Autowired
	private OrderServices orderServices;
	
	@Override
	@PostMapping("/save")
	public ResponseEntity<Orders> makeOrderController() throws OrderException, CartException {
		
		Orders order=orderServices.makeOrder();
		
		return new ResponseEntity<Orders>(order, HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<Orders> placedOrdersController(@PathVariable("id") int oId) throws OrderException {
		
		Orders order=orderServices.placedOrders(oId);
		
		return new ResponseEntity<Orders>(order, HttpStatus.ACCEPTED);
	}

	@Override
	@GetMapping("/Orders")
	public ResponseEntity<List<Orders>> totalOrdersByUserController() throws OrderException {
		
		List<Orders> orders=orderServices.totalOrdersByUser();
		
		return new ResponseEntity<List<Orders>>(orders, HttpStatus.ACCEPTED);
	}

	@Override
	@GetMapping("/allOrders")
	public ResponseEntity<List<Orders>> totalOrdersController() throws OrderException {
		
		List<Orders> orders=orderServices.totalOrders();
		
		return new ResponseEntity<List<Orders>>(orders, HttpStatus.ACCEPTED);
		
	}

	@Override
	@GetMapping("/pendingOrders")
	public ResponseEntity<List<Orders>> totalOrderPandingToPlacedController() throws OrderException {
		
		List<Orders> orders=orderServices.totalOrderPandingToPlaced();
		
		return new ResponseEntity<List<Orders>>(orders, HttpStatus.ACCEPTED);
	}

	@Override
	@GetMapping("/order/{id}")
	public ResponseEntity<Orders> getOrderByIdController(@PathVariable("id") int oId) throws OrderException {
		
		Orders order=orderServices.getOrderById(oId);
		return new ResponseEntity<Orders>(order, HttpStatus.ACCEPTED);
	}

}
