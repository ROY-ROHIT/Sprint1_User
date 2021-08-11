package com.cg.onlineshopping.exceptions.admin;

public class AdminNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AdminNotFoundException(String message) {
		super(message);
	}

}
