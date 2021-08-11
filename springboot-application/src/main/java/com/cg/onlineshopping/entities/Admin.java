//package com.cg.onlineshopping.entities;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//
//public class Admin {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int adminId;
//	private String adminUsername;
//	private String adminpassword;
//	
//	public Admin() {
//		
//	}
//
//	public Admin(int adminId, String adminUsername, String adminpassword) {
//		super();
//		this.adminId = adminId;
//		this.adminUsername = adminUsername;
//		this.adminpassword = adminpassword;
//	}
//
//	public int getAdminId() {
//		return adminId;
//	}
//
//	public void setAdminId(int adminId) {
//		this.adminId = adminId;
//	}
//
//	public String getAdminUsername() {
//		return adminUsername;
//	}
//
//	public void setAdminUsername(String adminUsername) {
//		this.adminUsername = adminUsername;
//	}
//
//	public String getAdminpassword() {
//		return adminpassword;
//	}
//
//	public void setAdminpassword(String adminpassword) {
//		this.adminpassword = adminpassword;
//	}
//	
//	
//}