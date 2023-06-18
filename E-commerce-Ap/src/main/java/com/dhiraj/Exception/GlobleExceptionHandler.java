package com.dhiraj.Exception;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorClass> exceptionHandler(Exception es,WebRequest req){
		
		MyErrorClass err=new MyErrorClass();
	      err.setDate(LocalDateTime.now());
	      err.setMsg(es.getMessage());
	      err.setDesc(req.getDescription(false));
	      
	      return new ResponseEntity<MyErrorClass>(err, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorClass> exceptionHandler(UserException es,WebRequest req){
		
		MyErrorClass err=new MyErrorClass();
	      err.setDate(LocalDateTime.now());
	      err.setMsg(es.getMessage());
	      err.setDesc(req.getDescription(false));
	      
	      return new ResponseEntity<MyErrorClass>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorClass> exceptionHandler(ProductException es,WebRequest req){
		
		MyErrorClass err=new MyErrorClass();
	      err.setDate(LocalDateTime.now());
	      err.setMsg(es.getMessage());
	      err.setDesc(req.getDescription(false));
	      
	      return new ResponseEntity<MyErrorClass>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorClass> exceptionHandler(OrderException es,WebRequest req){
		
		MyErrorClass err=new MyErrorClass();
	      err.setDate(LocalDateTime.now());
	      err.setMsg(es.getMessage());
	      err.setDesc(req.getDescription(false));
	      
	      return new ResponseEntity<MyErrorClass>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CardException.class)
	public ResponseEntity<MyErrorClass> exceptionHandler(CardException es,WebRequest req){
		
		MyErrorClass err=new MyErrorClass();
	      err.setDate(LocalDateTime.now());
	      err.setMsg(es.getMessage());
	      err.setDesc(req.getDescription(false));
	      
	      return new ResponseEntity<MyErrorClass>(err, HttpStatus.BAD_REQUEST);
	}
	
}
