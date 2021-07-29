package com.capg.OnlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.OnlineShop.entities.User;
@Repository
public interface IUserRepository extends JpaRepository<User,Integer>{
	
	

}
