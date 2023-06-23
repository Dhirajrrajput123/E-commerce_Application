package com.dhiraj.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhiraj.Entity.Cart;
import com.dhiraj.Entity.Orders;
import com.dhiraj.Entity.Usersd;
import com.dhiraj.Exception.CartException;
import com.dhiraj.Exception.OrderException;
import com.dhiraj.Repository.CartDao;
import com.dhiraj.Repository.OrdersDao;
import com.dhiraj.Repository.UserDao;

@Service
@Transactional
public class OrderServicesImpl implements OrderServices {

	@Autowired
	private OrdersDao orderDao;
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartServices cartServices;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Orders makeOrder() throws OrderException, CartException {
		
		Cart cart=cartServices.findCartByUserId();  //if Active cart not present than it throw an error 
		
		Usersd user=cart.getUser();
		cart.setcPresent(false);
		Orders order=new Orders();
		order.setActive(true);
		order.setCard(cart);
		order.setUser(user);
		
		Orders saveOrder=orderDao.save(order);
		
		cart.setcPresent(false);
		
		cartDao.save(cart);
		
		return saveOrder;
	}

	@Override
	public Orders placedOrders(int oId) throws OrderException {
		
		Optional<Orders> order=orderDao.findById(oId);
		
		if(order.isEmpty()) throw new OrderException("Invalid OrderId "+oId);
		
		Orders presentOrder=order.get();
		
		if(presentOrder.getActive()==false) throw new OrderException("Order already Placed Thanks...");
			
		presentOrder.setActive(false);
		
		Orders updateOrder=orderDao.save(presentOrder);
		
		return updateOrder;
	}

	@Override
	public List<Orders> totalOrders() throws OrderException {
		
		List<Orders> orders=orderDao.findAll();
		
		if(orders.isEmpty()) throw new OrderException("0 Orders Present right now ");
		
		return orders;
	}

	@Override
	public List<Orders> totalOrderPandingToPlaced() throws OrderException {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		
		String username=auth.getName();
		Usersd user=userDao.findByUsername(username).get();
		int uid=user.getId();
		
        List<Orders> orders=orderDao.findAll();
		
		if(orders.isEmpty()) throw new OrderException("0 Orders Present right now ");

		List<Orders> orderPlacedByUser=new ArrayList<>();
		
		for(Orders order: orders) {
			if(order.getUser().getId()==uid && order.getActive()) {
				orderPlacedByUser.add(order);
			}
		}
		
		if(orderPlacedByUser.isEmpty()) throw new OrderException("You are not placed any order right not Please Placed a Order...");
		
		return orderPlacedByUser;
	}

	@Override
	public Orders getOrderById(int oId) throws OrderException {
		
		Optional<Orders> order=orderDao.findById(oId);
		
		if(order.isEmpty()) throw new OrderException("Invalid Order Id "+oId);
		
		return order.get();
	}

	@Override
	public List<Orders> totalOrdersByUser() throws OrderException {
		
		
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		
		String username=auth.getName();
		Usersd user=userDao.findByUsername(username).get();
		int uid=user.getId();
		
        List<Orders> orders=orderDao.findAll();
		
		if(orders.isEmpty()) throw new OrderException("0 Orders Present right now ");

		List<Orders> orderPlacedByUser=new ArrayList<>();
		
		for(Orders order: orders) {
			if(order.getUser().getId()==uid ) {
				orderPlacedByUser.add(order);
			}
		}
		
		if(orderPlacedByUser.isEmpty()) throw new OrderException("You are not placed any order right not Please Placed a Order...");
		
		return orderPlacedByUser;
	}

}
