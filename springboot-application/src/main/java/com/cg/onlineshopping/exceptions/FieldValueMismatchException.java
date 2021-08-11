package com.cg.onlineshopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FieldValueMismatchException extends Exception {
	public FieldValueMismatchException(String str)
	{
		super(str);
	}

}
