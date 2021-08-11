package com.cg.onlineshopping.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{
	

}
