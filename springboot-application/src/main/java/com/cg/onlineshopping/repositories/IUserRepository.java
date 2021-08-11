package com.cg.onlineshopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.User;


@Repository
public interface IUserRepository extends JpaRepository<User,Integer>{
	
	public User findByUserIDAndUserPassword(int userID, String userPassword);

}
