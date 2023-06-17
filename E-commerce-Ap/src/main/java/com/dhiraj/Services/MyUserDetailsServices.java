package com.dhiraj.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dhiraj.Entity.Usersd;
import com.dhiraj.Model.MyUserDetaile;
import com.dhiraj.Repository.UserDao;

@Service
public class MyUserDetailsServices  implements UserDetailsService{

	@Autowired
	private UserDao uDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Usersd> user=uDao.findByUsername(username);
		if(user.isPresent()) {
			return new MyUserDetaile(user.get());
		}
		throw new UsernameNotFoundException("(My UserDetails Services ) User not present in this username "+username);
	}

}
