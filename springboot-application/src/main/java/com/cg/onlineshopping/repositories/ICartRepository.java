package com.cg.onlineshopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Cart;


@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {
//	public ProductList findByName(String name);

}
