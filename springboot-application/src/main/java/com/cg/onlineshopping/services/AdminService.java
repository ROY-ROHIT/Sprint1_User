//package com.cg.onlineshopping.services;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cg.onlineshopping.entities.Admin;
//import com.cg.onlineshopping.exceptions.admin.AdminFoundException;
//import com.cg.onlineshopping.exceptions.admin.AdminNotFoundException;
//import com.cg.onlineshopping.repositories.AdminRepository;
//
//
//@Service
//public class AdminService {
//	@Autowired
//	private AdminRepository adminrepo;
//	
//	public Admin addAdmin(Admin admin) {
//		Admin obj = adminrepo.findByAdminUsername(admin.getAdminUsername());
//		if(obj != null)
//			throw new AdminFoundException("Admin already created");
//		return adminrepo.save(admin);
//	}
//	
//	public boolean validateAdmin(String username, String password) {
//		Optional<Admin> admin = adminrepo.findByAdminUsernameAndAdminpassword(username, password);
//		if(admin.get() == null)
//			return false;
//		else
//			return true;
//	}
//	
//	public Optional<Admin> viewByAdminUserName(String username, String password) {
//		Optional<Admin> admin = adminrepo.findByAdminUsernameAndAdminpassword(username, password);
//		if(admin.get() == null)
//			throw new AdminNotFoundException("Admin not created");
//		return admin;		
//	}
//
//}