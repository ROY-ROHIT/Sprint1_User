package com.cg.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.repositories.IProductRepository;



@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	IProductRepository iproductRepository;
	
	@Override
	public ResponseEntity<Product> addProduct(Product product) {
	    try {
	      Product _product = iproductRepository
	          .save(new Product(product.getProductId(),product.getProductName(),product.getBrandName(),product.getCategory(),product.getPrice(), product.getColor(),product.getSpecification(),product.getQuantity(),product.getUserRatings()));
	      return new ResponseEntity<>(_product, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@Override
	public ResponseEntity<List<Product>> viewAllProducts() {
		try {
		      List<Product> product = new ArrayList<Product>();

		      iproductRepository.findAll().forEach(product::add);
		      
		      if (product.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(product, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@Override
	public ResponseEntity<Product> viewProductById(int id) {
	    Optional<Product> productData = iproductRepository.findById(id);

	    if(productData.isPresent()) {
	      return new ResponseEntity<>(productData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@Override
	public ResponseEntity<List<Product>> viewProductsByCategory(String cat) {
	    List<Product> productData = iproductRepository.findByCategoryIgnoreCase(cat);
		  if (productData.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(productData, HttpStatus.OK);
	  }
	
	@Override
	public ResponseEntity<Product> updateProduct(int id,Product product) {
	    Optional<Product> productData = iproductRepository.findById(id);

	    if (productData.isPresent()) {
	      Product _product = productData.get();
	      
	      _product.setProductName(product.getProductName());
	      _product.setBrandName(product.getBrandName());
	      _product.setCategory(product.getCategory());
	      _product.setPrice(product.getPrice());
	      _product.setColor(product.getColor());
	      _product.setSpecification(product.getSpecification());
	      _product.setQuantity(product.getQuantity());
	      _product.setUserRatings(product.getUserRatings());
	      return new ResponseEntity<>(iproductRepository.save(_product), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@Override
	public ResponseEntity<HttpStatus> removeProduct(int id) {
	    try {
	    	iproductRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}