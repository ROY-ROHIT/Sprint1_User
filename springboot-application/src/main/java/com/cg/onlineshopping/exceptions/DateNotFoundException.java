package com.cg.onlineshopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DateNotFoundException extends Exception {
	public DateNotFoundException(String message)
	{
		super(message);
	}

}