package com.dhiraj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.Entity.Role;
import com.dhiraj.Entity.Usersd;
import com.dhiraj.Exception.UserException;
import com.dhiraj.Services.UserServices;

@RestController
@RequestMapping("/E-App")
public class UserController {

	@Autowired
	private UserServices uservices;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/Users")
	public ResponseEntity<Usersd> saveUserController(@RequestBody Usersd user) throws UserException{
		System.out.println(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		Usersd saveuser=uservices.saveUser(user);
		
		return new ResponseEntity<Usersd>(saveuser, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/UsersRoleAdmin/{pass}")
	public ResponseEntity<Usersd> saveAdminController(@RequestBody Usersd user,@PathVariable("pass") int pass) throws UserException{
		System.out.println(user+" "+pass);
		if(pass!=12345) throw new UserException("Wrong Enter Path varable to save User role as ADMIN");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_ADMIN");
		Usersd saveuser=uservices.saveUser(user);
		
		return new ResponseEntity<Usersd>(saveuser, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/WelcomeForAll")
	public ResponseEntity<String> helloforAll(){
		return new ResponseEntity<String>("hello for All ", HttpStatus.ACCEPTED);
	}
	@GetMapping("/WelcomeForAdmin")
	public ResponseEntity<String> helloforAdmin(){
		return new ResponseEntity<String>("hello for Admin ", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/WelcomeForAdminAndUser")
	public ResponseEntity<String> helloforAdminAndUser(){
		return new ResponseEntity<String>("hello for Admin And User ", HttpStatus.ACCEPTED);
	}
	
}
