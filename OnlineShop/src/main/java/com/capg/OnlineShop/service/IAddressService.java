package com.capg.OnlineShop.service;

import java.util.List;

import com.capg.OnlineShop.Exception.AddressNotFoundException;
import com.capg.OnlineShop.entities.Address;

public interface IAddressService {
	
	public Address AddAddress(Address add);
	public Address updateAddress(int id,Address add) throws AddressNotFoundException;
	public Address removeAddress(Integer addressId) throws AddressNotFoundException;
	public List<Address> viewAllAddress();
	public Address viewAddress(Integer addressId) throws AddressNotFoundException;
	

}
