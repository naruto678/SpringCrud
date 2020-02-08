package com.example.CrudDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.example.CrudDemo.dao.PersonErrorResponse;

@ControllerAdvice
public class PersonExceptionController {

	@ExceptionHandler
	public ResponseEntity<PersonErrorResponse> handleException(RuntimeException exc){
		PersonErrorResponse res=new PersonErrorResponse();
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setMessage(exc.getMessage());
		res.setTimestamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<PersonErrorResponse>(res,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<PersonErrorResponse> handleAllExceptions(Exception exception){
		PersonErrorResponse res=new PersonErrorResponse();
		res.setStatus(HttpStatus.BAD_REQUEST.value());
		res.setMessage(exception.getMessage());
		res.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<PersonErrorResponse>(res,HttpStatus.BAD_REQUEST);
	}
}
