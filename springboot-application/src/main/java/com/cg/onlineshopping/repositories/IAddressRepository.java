package com.cg.onlineshopping.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Address;



@Repository
public interface IAddressRepository extends JpaRepository<Address,Integer> {
	
	
}
