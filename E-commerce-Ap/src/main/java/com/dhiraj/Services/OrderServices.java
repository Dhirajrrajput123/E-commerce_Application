package com.dhiraj.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dhiraj.Entity.Orders;
import com.dhiraj.Exception.CartException;
import com.dhiraj.Exception.OrderException;

@Service
public interface OrderServices {

	public Orders makeOrder() throws OrderException, CartException;
	
	public Orders placedOrders(int oId) throws OrderException;
	
	public List<Orders> totalOrdersByUser() throws OrderException;
	
	public List<Orders> totalOrders() throws OrderException;
	
	public List<Orders> totalOrderPandingToPlaced() throws OrderException;
	
	public Orders getOrderById(int oId) throws OrderException;
}
