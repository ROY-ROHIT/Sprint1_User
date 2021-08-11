package com.cg.onlineshopping.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;

@Builder
@Entity
@Table(name="ProductList")
public class ProductList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="List_Id")
	private long listId;
	@Column(name="ProductName")
	private String productName;
	@Column(name="Quantity")
	private int quantity;
	
	
	@ManyToOne(targetEntity=Cart.class, cascade=CascadeType.ALL)
	@JoinColumn(name="fk_Id")

	private Cart cart;

public ProductList(long listId, String productName, int quantity, com.cg.onlineshopping.entities.Cart cart) {
	super();
	this.listId = listId;
	this.productName = productName;
	this.quantity = quantity;
	this.cart = cart;
}

public long getListId() {
	return listId;
}

public void setListId(long listId) {
	this.listId = listId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Cart getCart() {
	return cart;
}

public void setCart(Cart cart) {
	this.cart = cart;
}


public ProductList()
{
	
}
	
	
	


}