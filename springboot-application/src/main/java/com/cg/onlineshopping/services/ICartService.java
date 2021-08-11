package com.cg.onlineshopping.services;


import java.util.List;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.ProductList;



public interface ICartService {
	
	public Cart addProductToCart(Cart cart,int prodId,int quantity);
	public Cart removeProductFromCart(Cart cart,int prodId);
	public ProductList updateProductQuantity(int id, String name,int quantity);
	public Cart removeAllProducts(int id);
	public List<ProductList> viewAllProducts(int id);

}
