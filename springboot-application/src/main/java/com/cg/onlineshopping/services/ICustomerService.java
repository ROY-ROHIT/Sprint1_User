package com.cg.onlineshopping.services;

import java.util.List;

import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.exceptions.CustomerNotFoundException;



public interface ICustomerService {
	
	public Customer addCustomer(Customer cust);  // call by User
	public Customer updateCustomerProfile(int id,Customer bean) throws CustomerNotFoundException; // call by User and Admin
	public Customer removeCustomer(int customerId) throws CustomerNotFoundException; // call by user and admin
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
	public List<Customer> ViewAllCustomers();
	public boolean validateCust(Customer cust) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public List<Customer> deActivateCustomer(String status);
	
	
//	public Cart addProductToCart(Cart cart, Product p,int quantity);
//	public Cart removeProductFromCart(Cart cart,Product p);
//	public Cart updateProductQuantity(Cart cart, Product p,int quantity);
//	public Cart removeAllProducts(Cart cart);
//	public List<Product> viewAllProducts(Cart cart);
//
//	
//	public List<Review> getAllReviewsByUsername(String username);

}


