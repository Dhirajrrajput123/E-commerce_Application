package com.dhiraj.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhiraj.Entity.Usersd;
import com.dhiraj.Exception.UserException;
import com.dhiraj.Repository.UserDao;

@Service
public class UserServicesImple implements UserServices{
	
	@Autowired
	private UserDao uDao;

	@Override
	public Usersd saveUser(Usersd user) throws UserException {
		// TODO Auto-generated method stub
		if(user==null) throw new UserException("You can not pass the null value for save the new User");
		
		if(uDao.findById(user.getId()).isPresent()) {
			throw new UserException("User apready present so we can not Store new User with same Id");
		}
		
		return uDao.save(user);
	}

	
}
