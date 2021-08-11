package com.cg.onlineshopping.entities;


import java.util.List;
//import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CART")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Cart_Id")
	private int cartId;
	@OneToOne(targetEntity=Customer.class,cascade=CascadeType.ALL)
	@JoinColumn(name="Cust_Id")
	private Customer customer;
//	@OneToMany(targetEntity=Product.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="PRODUCT_ID")
//	private Map<Product,Integer> product;
	@OneToMany(targetEntity=ProductList.class, cascade=CascadeType.ALL)
//	@JoinColumn(name="ListId")
	@JsonBackReference
	private List<ProductList> plist;

	
}
