package com.cg.onlineshopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.ProductList;




@Repository
public interface IProductListRepository extends JpaRepository<ProductList,Integer> {
	
	public ProductList findByProductName(String name);

}

