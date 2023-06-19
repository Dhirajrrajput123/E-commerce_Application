package com.dhiraj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.Entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {

	
}
