package com.cg.onlineshopping.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.exceptions.AddressNotFoundException;
import com.cg.onlineshopping.exceptions.CustomerNotFoundException;
import com.cg.onlineshopping.exceptions.FieldValueMismatchException;
import com.cg.onlineshopping.exceptions.UserNotFoundException;
import com.cg.onlineshopping.services.IAddressService;
import com.cg.onlineshopping.services.ICustomerService;
import com.cg.onlineshopping.services.IUserService;


@RestController
public class UserController {
	
	@Autowired
	private IUserService uss;
	@Autowired
	private ICustomerService Cust;
	@Autowired
	private IAddressService adds;
	
	public static int logValidator = 0;
	public static String UserType = "";
	
	@GetMapping("/allusers")
	public List<User> RetrieveAllUsers()
	{
		return uss.ViewAllUsers();
	}
	
	@GetMapping("/Login/{userId}/{userPassword}")
	public ResponseEntity<?> loggingUser(@PathVariable("userId") int userID,
			@PathVariable("userPassword") String userPassword) throws UserNotFoundException {
		boolean value = uss.loginDetails(userID, userPassword);
		if (value == true) {
			//logValidator = 1;
			String UserType = uss.ViewUser(userID).getRole();
			if(UserType=="Admin") {
				logValidator = 1;
				return ResponseEntity.ok("Logged In As "+UserType);
			}
			else {
				logValidator = 2;
				return ResponseEntity.ok("Logged In As "+UserType);
			}
			
		} else
			return ResponseEntity.ok("Invalid Credentials");
	}

	@GetMapping("/Logout")
	public ResponseEntity<?> logOutUser() {
		logValidator = 0;
		UserType = "";
		return ResponseEntity.ok("Logged Out");
	}
	
	
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody User user) throws Exception {
		uss.validateUser(user);
		
		User userdb = uss.addUser(user);
		return new ResponseEntity<>(userdb,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/viewallUsers")
	public ResponseEntity<?> viewUser() {
		if (logValidator == 1) {
			if (UserType.equalsIgnoreCase("admin")) {
				List<User> list = uss.ViewAllUsers();
				return ResponseEntity.ok(list);
			} else
				return ResponseEntity.ok("You don't have admin privileges");
		} else
			return ResponseEntity.ok("You have not logged in yet");
	}
	
	@GetMapping("/allcustomers")
	public List<Customer> RetrieveAllCustomers()
	{
		return Cust.ViewAllCustomers();
	}
	
	
	
	@GetMapping("/customer/{id}")
	public Customer RetrieveCustomer(@PathVariable("id") int id) throws CustomerNotFoundException
	{
		return Cust.viewCustomer(id);
	}
	
	
	@GetMapping("/alladdress")
	public List<Address> RetrieveAllAddress()
	{
		return adds.viewAllAddress();
	}
	
	@GetMapping("/address/{id}")
	public Address RetrieveAddress(@PathVariable("id") int id) throws AddressNotFoundException
	{
		return adds.viewAddress(id);
	}
	
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> createCustomer (@Valid @RequestBody Customer csr) throws Exception
	{
		if(Cust.validateCust(csr)== true)
		{
		Customer savedCsr = Cust.addCustomer(csr);
		return new ResponseEntity<>(savedCsr,HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void DelCustomer(@PathVariable("id") int id) throws CustomerNotFoundException
	{
		Cust.removeCustomer(id);
	}
	
	@DeleteMapping("/delete{id}")
	public void DelAddress(@PathVariable("id") int id) throws AddressNotFoundException
	{
		adds.removeAddress(id);
	}
	
	
	@PostMapping("/addaddress")
	public ResponseEntity<Address> createAddress(@Valid @RequestBody Address addr) throws FieldValueMismatchException
	{
		adds.validateAddress(addr);
		Address ad=adds.AddAddress(addr);
		return new ResponseEntity<>(ad,HttpStatus.CREATED);
	}
	
	@PutMapping("/updatecustomer/{id}")
	public Customer updateCustomer(@PathVariable("id") int id,@RequestBody Customer csr) throws CustomerNotFoundException
	{
		return Cust.updateCustomerProfile(id,csr);
	}
	
	@PutMapping("/updateaddress/{id}")
	public Address updateAddress(@PathVariable("id") int id,@RequestBody Address addr) throws AddressNotFoundException
	{
		return adds.updateAddress(id,addr);
	}
	
	@PutMapping("/updateuser/{id}")
	public User updateUser(@PathVariable("id") int id,@RequestBody User user) throws UserNotFoundException
	{
		return uss.updateUserProfile(id,user);
	}
	
	

}
