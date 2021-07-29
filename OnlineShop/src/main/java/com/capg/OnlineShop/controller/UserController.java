package com.capg.OnlineShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.OnlineShop.Exception.AddressNotFoundException;
import com.capg.OnlineShop.Exception.CustomerNotFoundException;
import com.capg.OnlineShop.Exception.UserNotFoundException;
import com.capg.OnlineShop.entities.Address;
import com.capg.OnlineShop.entities.Customer;
import com.capg.OnlineShop.entities.User;
import com.capg.OnlineShop.service.IAddressService;
import com.capg.OnlineShop.service.ICustomerService;
import com.capg.OnlineShop.service.IUserService;
//import com.cg.onlineshopping.entities.Customer;
@RestController
//@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private IUserService uss;
	@Autowired
	private ICustomerService Cust;
	@Autowired
	private IAddressService adds;
	
	@PostMapping("/add/user")
	public ResponseEntity<User> createUser( @RequestBody User user)
	{
		User savedUser=uss.addUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
//		URI loc= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getUsername()).toUri();
//		return ResponseEntity.created(loc).build();
//	}
//	@PostMapping("/adduser")
//	public User createUser(@RequestBody User user)
//	{
//		return uss.addUser(user);
//	}
	
	@GetMapping("/allusers")
	public List<User> RetrieveAllUsers()
	{
		return uss.ViewAllUsers();
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
	
//	@GetMapping("/customer/{status}")
//	public List<Customer> RetrieveDeactivatedCust(@PathVariable("status") String status)
//	{
//			return (Cust.deActivateCustomer(status));
//		
//	}
	
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
	
//	@PostMapping("/add/customer")
//	public ResponseEntity<Object> createCustomer( @RequestBody Customer csr)
//	{
//		Customer savedCsr=Cust.addCustomer(csr);
//		URI loc= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCsr.getCustomerId()).toUri();
//		return ResponseEntity.created(loc).build();
//	}
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> createCustomer (@RequestBody Customer csr)
	{
		Customer savedCsr = Cust.addCustomer(csr);
		return new ResponseEntity<>(savedCsr,HttpStatus.CREATED);
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
	
//	@PostMapping("/add/address")
//	public ResponseEntity<Object> createAddress( @RequestBody Address addr)
//	{
//		Address savedAddr=adds.AddAddress(addr);
//		URI loc= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAddr.getAddressId()).toUri();
//		return ResponseEntity.created(loc).build();
//	}
	
	@PostMapping("/addaddress")
	public ResponseEntity<Address> createAddress(@RequestBody Address addr)
	{
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
