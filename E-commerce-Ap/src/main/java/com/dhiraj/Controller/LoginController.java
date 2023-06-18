package com.dhiraj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.Entity.Usersd;
import com.dhiraj.Repository.UserDao;

@RestController
public class LoginController {

	@Autowired
	private UserDao uDao;
	
	@GetMapping("/signIn")
	public ResponseEntity<Usersd> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		
		 Usersd user= uDao.findByUsername(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
		 //to get the token in body, pass HttpServletResponse inside this method parameter 
		// System.out.println(response.getHeaders(SecurityConstants.JWT_HEADER));
		 
		 
		 return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
		
		
	}
}
