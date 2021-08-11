package com.cg.onlineshopping.repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {

	List<Order> findAllByOrderDate(LocalDate date);


	List<Order> findAllByAddress_City(String city);
	
	@Query(value="select * from orders where cust_Id=(select custid from customer,users where custId=cp_fk and user_id=:n)",nativeQuery=true)
	List<Order> getOrderByUserId(@Param("n")String userId);



	




}

