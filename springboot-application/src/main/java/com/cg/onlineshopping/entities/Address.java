package com.cg.onlineshopping.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Builder;


@Entity

@Builder
@Table(name="ADDRESS")
public class Address {
	@Id
	@Column(name="AddId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;
	@Column(name="StreetNo")
	@NotNull
	private String streetNo;
	@Column(name="BuildingName")
	@NotEmpty(message="Building name cannot be empty")
	private String buildingName;
	@Column(name="City")
	@NotEmpty(message="City cannot be empty")
	private String city;
	@Column(name="State")
	@NotEmpty(message="State cannot be empty")
	private String state;
	@Column(name="Country")
	@NotEmpty(message="You must enter country")
	private String country;
	@Column(name="Pincode")
//	@Size(max=6)
	private String pincode;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Address() {
		
	}
	public Address(int addressId, String streetNo, String buildingName, String city, String state, String country,
			String pincode) {
		super();
		this.addressId = addressId;
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	
	
	
	
	
	

}
