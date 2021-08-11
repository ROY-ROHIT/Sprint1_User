package com.cg.onlineshopping.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.exceptions.CustomerNotFoundException;
import com.cg.onlineshopping.exceptions.FieldValueMismatchException;
import com.cg.onlineshopping.repositories.ICustomerRepository;


//import com.cg.onlineshopping.Exception.CustomerNotFoundException;

@Service
public class CustServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository repo;
	
	@Autowired
	private AddServiceImpl addserv;

	@Override
	public Customer addCustomer(Customer cust) {
		return repo.save(cust);
	}
	

	@Override
	public Customer updateCustomerProfile(int id,Customer bean) throws CustomerNotFoundException {
		
		Customer cust=repo.findById(id).get();
		if(cust == null)
		{
			throw new CustomerNotFoundException("Customer Not Present");
		}
		else {
		cust.setFirstName(bean.getFirstName());
		cust.setLastName(bean.getLastName());
		cust.setMobileNumber(bean.getMobileNumber());	
		repo.save(cust);
		}
		return null;
	}

	@Override
	public Customer removeCustomer(int customerId) throws CustomerNotFoundException {
		
		Customer cust=repo.findById(customerId).get();
		
		if (cust==null)
		{
			throw new CustomerNotFoundException("Customer Not Present");
		}
		 repo.deleteById(customerId);
		
		return null;
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {
		
		Customer cust=repo.findById(customerId).get();
		if (cust==null)
		{
			throw new CustomerNotFoundException("Customer Not Present");
		}
		
		return repo.findById(customerId).get();
	}

	@Override
	public List<Customer> ViewAllCustomers() {
		return repo.findAll();
	}

//	@Override
//	public List<Customer> deActivateCustomer(String status) {
//		
//		if(status == "NotActive")
//		{
//			return repo.FindByStatus(status);
//		}
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public boolean validateCust(Customer cust) throws Exception
	{
		String fname=cust.getFirstName();
		String num=cust.getMobileNumber();
		List<Address>al=cust.getAddress();
		for(Address ad:al)
		{
			addserv.validateAddress(ad);
		}
		Pattern p=Pattern.compile("^[0-9]*$");
		Matcher m1=p.matcher(num);
		if(fname.isEmpty())
		{
			throw new FieldValueMismatchException("First Name cannot be Empty");
		}
		else if(num.length()!=10 || !m1.matches())
		{
			throw new FieldValueMismatchException("Number cannot be less than or greater than 10 digits or cannot have Alphabets");
		}
		else 
			return true;
	}

}