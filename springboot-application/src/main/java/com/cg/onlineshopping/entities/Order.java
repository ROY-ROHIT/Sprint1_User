package com.cg.onlineshopping.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="ORDERS")
public class Order {
 
	@Id
    @Column(name="ORDER_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long orderId;
    @Column(name="ORDER_STATUS")
    private String orderStatus; // registered , dispatched , delievered
    @Column(name="ORDER_DATE")
    private LocalDate orderDate;
    @Column(name="TOTAL_AMOUNT")
    @NotEmpty(message="Amount cannot be empty")
    private int totalAmount;
    
    @ManyToOne(cascade=CascadeType.MERGE) //(targetEntity=Customer.class,cascade=CascadeType.ALL)
    @JoinColumn(name="CUST_ID")
    private Customer customer;
    
    
    @OneToMany(targetEntity=ProductList.class,cascade=CascadeType.ALL)
    @JoinColumn(name="Fk_ORDER_ID")
    private List<ProductList> productList;//(product name and product quantity
   
    @ManyToOne(cascade=CascadeType.MERGE) //(targetEntity=Customer.class,cascade=CascadeType.ALL)
    @JoinColumn(name="Add_ID")
     private Address address;
   
    
    
    
    
    public Long getOrderId() {
 		return orderId;
 	}
 	public void setOrderId(Long orderId) {
 		this.orderId = orderId;
 	}

 	public String getOrderStatus() {
 		return orderStatus;
 	}
 	public void setOrderStatus(String orderStatus) {
 		this.orderStatus = orderStatus;
 	}
 	public LocalDate getOrderDate() {
 		return orderDate;
 	}
 	public void setOrderDate(LocalDate orderDate) {
 		this.orderDate = orderDate;
 	}

 	public int getTotalAmount() {
 		return totalAmount;
 	}
 	public void setTotalAmount(int totalAmount) {
 		this.totalAmount = totalAmount;
 	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Order() {
		
	}
	public List<ProductList> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductList> productList) {
		this.productList = productList;
	}
	public Order(Long orderId, String orderStatus, LocalDate orderDate, int totalAmount,
			Customer customer, List<ProductList> productList, Address address) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.customer = customer;
		this.productList = productList;
		this.address = address;
	}
	





}