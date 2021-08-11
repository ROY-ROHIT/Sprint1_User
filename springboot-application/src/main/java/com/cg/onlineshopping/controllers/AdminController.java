//package com.cg.onlineshopping.controllers;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cg.onlineshopping.entities.Admin;
//import com.cg.onlineshopping.entities.Customer;
//import com.cg.onlineshopping.entities.Order;
//import com.cg.onlineshopping.entities.Product;
//import com.cg.onlineshopping.exceptions.customer.CustomerNotFoundException;
//import com.cg.onlineshopping.exceptions.order.OrderNotFoundException;
//import com.cg.onlineshopping.services.AdminService;
//import com.cg.onlineshopping.services.ICustomerService;
//import com.cg.onlineshopping.services.IOrderService;
//import com.cg.onlineshopping.services.IProductService;
//
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//	
//	private int validAdmin = 0;
//	@Autowired
//	private ICustomerService customerservice;
//	
//	@Autowired
//	private IOrderService orderService;
//
//	@Autowired
//	private IProductService iproductService;
//	
//	@Autowired
//	private AdminService adminservice;
//	
//	/*..........................For Admin..................................*/
//	
//	@GetMapping("/login/{username}/{password}")
//	public ResponseEntity<?> loginAdmin(@PathVariable("username") String username, @PathVariable("password") String password) {
//		boolean adminvalidity = adminservice.validateAdmin(username, password);
//		if(adminvalidity == true) {
//			validAdmin = 1;
//			Admin admin = adminservice.viewByAdminUserName(username, password).get();
//			String welcome = "Welcome \n........................\n";
//			return ResponseEntity.ok(welcome + "Id : " + admin.getAdminId() + "\nUsername : " + admin.getAdminUsername());
//		} else
//			return ResponseEntity.ok("Invalid Credentials");				
//	}
//	
//	@PostMapping("/admin")
//	public Admin addAdmin(@Validated @RequestBody Admin admin) {
//		return adminservice.addAdmin(admin);
//	}
//	
//	@GetMapping("/logout")
//	public ResponseEntity<?> logout(){
//		if(validAdmin == 1) {
//			validAdmin = 0;
//			return ResponseEntity.ok("Logged out...");		
//		}else
//			return ResponseEntity.ok("Not Logged In");
//	}
//	
//	/*..........................For Customer.............................*/
//	
//	@GetMapping("/customers")
//	public ResponseEntity<?> viewAllCustomers(){
//		if(validAdmin == 1) {
//			return ResponseEntity.ok(customerservice.ViewAllCustomers());
//		}else
//		return ResponseEntity.ok("Not Logged In");
//	}
//	@PostMapping("/customers")
//	public ResponseEntity<?> addCustomer(@Validated @RequestBody Customer customer) {
//		if(validAdmin == 1) {
//			return ResponseEntity.ok(customerservice.addCustomer(customer));
//		}else
//		return ResponseEntity.ok("Not Logged In");
//	}
//	
//	@PutMapping("/customers/{id}")
//	public ResponseEntity<?> updateCustomer(@PathVariable("id") int id, @RequestBody Customer csr) throws CustomerNotFoundException {
//		if(validAdmin == 1) {
//			return ResponseEntity.ok(customerservice.updateCustomerProfile(id,csr));
//		}else
//		return ResponseEntity.ok("Not Logged In");
//	}
//	
//
//	
//	@DeleteMapping("/customers/{id}")
//	public ResponseEntity<?> deleteCustomer(@PathVariable("id") int customerId) throws CustomerNotFoundException {
//		if(validAdmin == 1) {
//			return ResponseEntity.ok(customerservice.removeCustomer(customerId));
//		}else
//		return ResponseEntity.ok("Not Logged In");
//	}
//	
//	/*..........................For Product................................*/
//	
//	@PostMapping("/products")
//	public ResponseEntity<?> addProduct(@RequestBody Product product) {
//		if(validAdmin == 1) {
//			return ResponseEntity.ok(iproductService.addProduct(product));
//		}else
//		return ResponseEntity.ok("Not Logged In");
//	}
//	
//	@PutMapping("/products/{id}")
//	public ResponseEntity<?> updateProduct(@PathVariable("id") String id, @RequestBody Product p) {
//		if(validAdmin == 1) {
//			return ResponseEntity.ok(iproductService.updateProduct(id,p));
//		}else
//		return ResponseEntity.ok("Not Logged In");
//	}
//	
//	
//
//
//	@DeleteMapping("/products/{id}")
//	public ResponseEntity<?> removeProduct(@PathVariable("id") String id) {
//		if(validAdmin == 1) {
//			return ResponseEntity.ok(iproductService.removeProduct(id));
//		}else
//		return ResponseEntity.ok("Not Logged In");
//	}
//
//	@GetMapping("/products")
//	public ResponseEntity<?> viewAllProducts() {
//		if(validAdmin == 1) {
//			return ResponseEntity.ok(iproductService.viewAllProducts());
//		}else
//		return ResponseEntity.ok("Not Logged In");
//	}
//	
////	/*..........................For Order................................*/
////	
////	@PostMapping("/orders")
////	public ResponseEntity<?> addOrder(@RequestBody Order order) {
////		if(validAdmin == 1) {
////			return ResponseEntity.ok(orderService.addOrder(order));
////		}else
////		return ResponseEntity.ok("Not Logged In");
////	}
////	
////	@PutMapping("/orders/{id}")
////	public ResponseEntity<?> updateProduct(@PathVariable("id") Long id,@RequestBody Order order) {
////		if(validAdmin == 1) {
////			return ResponseEntity.ok(orderService.updateOrder(id,order));
////		}else
////		return ResponseEntity.ok("Not Logged In");
////	}
////	
////	
////	@DeleteMapping("/order/{id}")
////	public ResponseEntity<?> removeOrder(@PathVariable("id") Long id) throws OrderNotFoundException {
////		if(validAdmin == 1) {
////			return ResponseEntity.ok(orderService.removeOrder(id));
////		}else
////		return ResponseEntity.ok("Not Logged In");
////	}
////	
////	@GetMapping("/order")
////	public ResponseEntity<?> viewAllOrders() {
////		if(validAdmin == 1) {
////			return ResponseEntity.ok(orderService.viewAllOrders());
////		}else
////		return ResponseEntity.ok("Not Logged In");
////	}
////
////	
//
//
//}