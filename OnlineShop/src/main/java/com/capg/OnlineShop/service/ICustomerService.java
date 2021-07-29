package com.capg.OnlineShop.service;

import java.util.List;

import com.capg.OnlineShop.Exception.CustomerNotFoundException;
import com.capg.OnlineShop.entities.Customer;
//import com.cg.onlineshopping.Exception.CustomerNotFoundException;

public interface ICustomerService {
	
	public Customer addCustomer(Customer cust);  // call by User
//	public CustomerRequestDTO addCustomer(CustomerRequestDTO cust);
	public Customer updateCustomerProfile(int id,Customer bean) throws CustomerNotFoundException; // call by User and Admin
	public Customer removeCustomer(int customerId) throws CustomerNotFoundException; // call by user and admin
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
	public List<Customer> ViewAllCustomers();
	
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

