package com.dhiraj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.Entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
