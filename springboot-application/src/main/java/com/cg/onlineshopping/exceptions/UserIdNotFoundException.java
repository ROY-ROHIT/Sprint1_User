package com.cg.onlineshopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserIdNotFoundException extends Exception {
	public UserIdNotFoundException(String message)
	{
		super(message);
	}

}
