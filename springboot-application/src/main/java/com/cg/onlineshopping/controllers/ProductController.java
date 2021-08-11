package com.cg.onlineshopping.controllers;


import java.util.List;
//import java.util.Optional;

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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.services.IProductService;



@RestController

public class ProductController {
	

	
	@Autowired(required=true)
	private IProductService iproductService;
	

	 
	@PostMapping("/product")
	  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	    return iproductService.addProduct(product);
	  }

	 @GetMapping("/product")
	  public ResponseEntity<List<Product>> viewProducts() {
	    return iproductService.viewAllProducts();
	  }


	 @GetMapping("/product/{id}")
	  public ResponseEntity<Product> viewProductById(@PathVariable("id")int id) {
	    return iproductService.viewProductById(id);
	  }
	  

	 @GetMapping("/product/category/{cat}")
	  public ResponseEntity<List<Product>> viewProductsByCategory(@PathVariable("cat")String cat) {
	    return iproductService.viewProductsByCategory(cat);
	  }



	 @PutMapping("/product/{id}")
	  public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
	    return iproductService.updateProduct(id, product);
	  }


	 @DeleteMapping("/product/{id}")
	  public ResponseEntity<HttpStatus> removeProduct(@PathVariable("id") int id) {
	    return iproductService.removeProduct(id);
	  }


}