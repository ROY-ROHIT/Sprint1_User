package com.cg.onlineshopping.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	//overriding method of ResponseEntityExceptionHandler class
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req)
	{
		//creating exception response structure
		ExceptionResponse exRes = new ExceptionResponse(new Date(), ex.getMessage(),req.getDescription(false));
		//returning exception structure and specific status 
		return new ResponseEntity<> (exRes,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<Object> handleCustomerNotFoundException(Exception ex, WebRequest req)
	{
		
		ExceptionResponse exRes=new ExceptionResponse(new Date(),ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(exRes,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public final ResponseEntity<Object> handleAddressNotFoundException (Exception ex, WebRequest req)
	{
		ExceptionResponse exRes=new ExceptionResponse(new Date(),ex.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(exRes,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest req)
	{
		ExceptionResponse exRes=new ExceptionResponse (new Date(),ex.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(exRes,HttpStatus.NOT_FOUND);
	}
	
	public final ResponseEntity<?> handleFieldValueMismatchException(Exception ex, WebRequest req)
	{
		ExceptionResponse exRes=new ExceptionResponse(new Date(),ex.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(exRes,HttpStatus.BAD_REQUEST);
	}
	
	
	

}