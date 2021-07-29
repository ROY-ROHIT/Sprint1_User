package com.capg.OnlineShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.OnlineShop.Exception.CustomerNotFoundException;
import com.capg.OnlineShop.entities.Customer;
import com.capg.OnlineShop.repository.ICustomerRepository;
//import com.cg.onlineshopping.Exception.CustomerNotFoundException;

@Service
public class CustServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository repo;

	@Override
	public Customer addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return repo.save(cust);
	}
	
//	@Override
//	public CustomerRequestDTO addCustomer(CustomerRequestDTO cust) {
//		// TODO Auto-generated method stub
//		return repo.save(cust);
//	}

	@Override
	public Customer updateCustomerProfile(int id,Customer bean) throws CustomerNotFoundException {
		
//		Customer cust=repo.findById(bean.getCustomerId()).get();
		Customer cust=repo.findById(id).get();
		if(cust == null)
		{
			throw new CustomerNotFoundException("Customer Not Present");
		}
		else {
//		cust.setCustomerId(bean.getCustomerId());
		cust.setFirstName(bean.getFirstName());
		cust.setLastName(bean.getLastName());
//		cust.setAddress(bean.getAddress());
		cust.setMobileNumber(bean.getMobileNumber());
		
		repo.save(cust);
		}
		// TODO Auto-generated method stub
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
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {
		
		Customer cust=repo.findById(customerId).get();
		if (cust==null)
		{
			throw new CustomerNotFoundException("Customer Not Present");
		}
		
		// TODO Auto-generated method stub
		return repo.findById(customerId).get();
	}

	@Override
	public List<Customer> ViewAllCustomers() {
		// TODO Auto-generated method stub
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

}