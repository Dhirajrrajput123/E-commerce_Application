package com.dhiraj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.Entity.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer>{

}
