package com.dhiraj.Services;

import org.springframework.stereotype.Service;

import com.dhiraj.Entity.Usersd;
import com.dhiraj.Exception.UserException;

@Service
public interface UserServices {

	public Usersd saveUser(Usersd user) throws UserException;
	
}
