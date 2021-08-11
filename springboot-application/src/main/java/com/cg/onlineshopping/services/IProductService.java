package com.cg.onlineshopping.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.onlineshopping.entities.Product;



public interface IProductService {

	
	public ResponseEntity<Product> addProduct(Product product);
	
	public ResponseEntity<List<Product>> viewAllProducts();
	public ResponseEntity<Product> viewProductById(int id);
	public ResponseEntity<List<Product>> viewProductsByCategory(String cat); 
	public ResponseEntity<Product> updateProduct(int productId,Product product);
	public ResponseEntity<HttpStatus> removeProduct(int prodid);
}