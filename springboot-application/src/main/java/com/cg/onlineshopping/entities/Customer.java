package com.cg.onlineshopping.entities;

import java.util.List;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Builder;




@Builder
@Entity
@Table(name="CUSTOMER")


public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CustID")
	private int customerId;

	@Column(name="FirstName")
//	@NotEmpty(message="First name cannot be empty or null")
	private String firstName;
	@Column(name="LastName")
	private String lastName;
	@Column(name="MobileNo")
	private String mobileNumber;
	@Column(name="Status")
	private String status; // active or deactivated
	@OneToMany(targetEntity=Address.class,cascade= CascadeType.ALL)//,fetch=FetchType.EAGER)
	@JoinColumn(name="Cp_fk")//, referencedColumnName="CustID")
	private List<Address> address;
	@OneToOne(targetEntity=User.class,cascade= CascadeType.DETACH)
	@JoinColumn(name="Cust_fk")//, referencedColumnName="UserID")
	private User user;
	
	public Customer() {
		
	}

	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String status,
			List<Address> address, User user) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.status = status;
		this.address = address;
		this.user = user;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}