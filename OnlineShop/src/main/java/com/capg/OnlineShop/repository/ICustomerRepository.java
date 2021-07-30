package com.capg.OnlineShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.OnlineShop.entities.Customer;
//import com.capg.onlineShop.dto.CustomerRequestDTO;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{
	
//	public List<Customer> FindByStatus(String status);

//	public CustomerRequestDTO save(CustomerRequestDTO cust);
//	public Customer FindByFirstName(String fname);

}

