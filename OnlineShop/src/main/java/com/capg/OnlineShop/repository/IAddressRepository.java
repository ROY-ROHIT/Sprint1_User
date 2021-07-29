package com.capg.OnlineShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.OnlineShop.entities.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address,Integer> {
	
//	public Address AddAddress(Address add);
//	public Address updateAddress(Address add,Integer addressId);
//	public Address removeAddress(Address add,Integer addressId);
//	public List<Address> viewAllAddress(String id);
//	public Address viewAddress(Address add,Integer addressId);
	
}
