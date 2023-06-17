package com.dhiraj.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.Entity.Usersd;

@Repository
public interface UserDao  extends JpaRepository<Usersd, Integer>{
	
	public Optional<Usersd> findByUsername(String username);

}
