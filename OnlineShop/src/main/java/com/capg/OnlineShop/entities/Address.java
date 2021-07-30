package com.capg.OnlineShop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="ADDRESS")
public class Address {
	@Id
	@Column(name="AddId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;
	@Column(name="StreetNo")
	private String streetNo;
	@Column(name="BuildingName")
	private String buildingName;
	@Column(name="City")
	private String city;
	@Column(name="State")
	private String state;
	@Column(name="Country")
	private String country;
	@Column(name="Pincode")
	private String pincode;
//	@ManyToOne
//	@JoinColumn(name="CustID")
//	private Customer customer;
	
	
	
	
	

}

