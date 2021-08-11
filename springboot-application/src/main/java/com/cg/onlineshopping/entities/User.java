package com.cg.onlineshopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity

@Table(name="USERS")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UserId")
	private int userID;
	@Column(name="Password")
	@Size(min=2,max=6)
	private String userPassword;
	@Column(name="Role")
	@NotEmpty(message="Role cannot be empty or null")
	private String role;
	@Column(name="Email")
	@Email(message="Must enter a valid email")
	@NotEmpty(message="Email cannot be empty")
	private String email;

	public User() {
		
	}

	public User(int userID, String userPassword, String role, String email, Customer cust) {
		super();
		this.userID = userID;

		this.userPassword = userPassword;
		this.role = role;
		this.email = email;

	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}



	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}	