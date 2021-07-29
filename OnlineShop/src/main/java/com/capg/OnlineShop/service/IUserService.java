package com.capg.OnlineShop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capg.OnlineShop.Exception.UserNotFoundException;
import com.capg.OnlineShop.entities.User;

public interface IUserService {
	
//public boolean validateUser(String username,String password);
	
	public User addUser(User user);
	public List<User> ViewAllUsers();
	public User updateUserProfile(int id,User bean) throws UserNotFoundException;
//	public boolean signIn();
//	public boolean signOut();
//	
	
	// all CURD Operations on User

}