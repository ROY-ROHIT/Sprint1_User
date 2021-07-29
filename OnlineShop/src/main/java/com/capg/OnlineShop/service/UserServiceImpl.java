package com.capg.OnlineShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.OnlineShop.Exception.UserNotFoundException;
import com.capg.OnlineShop.entities.User;
import com.capg.OnlineShop.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository repo;

//	@Override
//	public boolean validateUser(String username, String password) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	public List<User> ViewAllUsers()
	{
		return repo.findAll();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public User updateUserProfile(int id,User bean) throws UserNotFoundException {
		
//		User user = repo.findById(bean.getUserID()).get();
		User user=repo.findById(id).get();
		if(user==null)
		{
			throw new UserNotFoundException("User Not Present");
		}
		else {
//			user.setUserID(bean.getUserID());
			user.setUsername(bean.getUsername());
			user.setEmail(bean.getEmail());
			user.setPassword(bean.getPassword());
			user.setRole(bean.getRole());	
		}
		
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public boolean signIn() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean signOut() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}