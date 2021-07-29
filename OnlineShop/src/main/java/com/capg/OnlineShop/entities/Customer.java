package com.capg.OnlineShop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CustID")
	private int customerId;
	@Column(name="FirstName")
	private String firstName;
	@Column(name="LastName")
	private String lastName;
	@Column(name="MobileNo")
	private String mobileNumber;
	@Column(name="Status")
	private String status; // active or deactivated
//	@OneToMany(targetEntity=Address.class,cascade= CascadeType.ALL)
//	@JoinColumn(name="Cp_fk", referencedColumnName="CustID")
//	private List<Address> address;
//	
	
	
	

}
