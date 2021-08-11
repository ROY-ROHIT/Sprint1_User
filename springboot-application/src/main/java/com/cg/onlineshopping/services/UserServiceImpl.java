package com.cg.onlineshopping.services;


import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.exceptions.FieldValueMismatchException;
import com.cg.onlineshopping.exceptions.UserNotFoundException;
import com.cg.onlineshopping.repositories.IUserRepository;



@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository repo;

	
	public List<User> ViewAllUsers()
	{
		return repo.findAll();
	}

	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

	@Override
	public User updateUserProfile(int id,User bean) throws UserNotFoundException {
		
		User user=repo.findById(id).get();
		if(user==null)
		{
			throw new UserNotFoundException("User Not Present");
		}
		else {
			user.setUserPassword(bean.getUserPassword());
			user.setRole(bean.getRole());	
		}
		return null;
	}
	
	@Override
	public User ViewUser(int userId) throws UserNotFoundException{
		User user = repo.findById(userId).orElse(null);
		if (Objects.isNull(user))
			throw new UserNotFoundException("No user present with user Id" + userId);
		return user;
	}
	
	@Override
	public boolean loginDetails(int userID, String userPassword) {
		User user = repo.findByUserIDAndUserPassword(userID, userPassword);
		if (Objects.nonNull(user))
			return true;
		else
			return false;
	}


	@Override
	public void validateUser(User user) throws Exception{

		String email = user.getEmail();
		String pass=user.getUserPassword();
		String role= user.getRole();
		Pattern p=Pattern.compile("^[0-9]*$");
		Matcher m1=p.matcher(role);
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9+]+@[a-zA-Z0-9.-]+$");
		Matcher m = pattern.matcher(email);
		if (!m.matches()) {
			throw new UserNotFoundException("The Email Address is invalid.");
		}
		else if(pass.length()<2 || pass.length()>6)
		{
			throw new FieldValueMismatchException("Password length is too short or too long");
		}
		else if (role.isEmpty() || m1.matches())
		{
			throw new FieldValueMismatchException("Role cannot have any number or cannot be empty");
		}
		
	}

}