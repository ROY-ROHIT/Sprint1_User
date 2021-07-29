package com.capg.OnlineShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.OnlineShop.Exception.AddressNotFoundException;
import com.capg.OnlineShop.entities.Address;
import com.capg.OnlineShop.repository.IAddressRepository;

@Service
public class AddServiceImpl implements IAddressService {
	
	@Autowired
	private IAddressRepository repo;
	
	@Override
	public Address AddAddress(Address add)
	{
		return repo.save(add);
	}
	
	
	public Address updateAddress(int id,Address bean) throws AddressNotFoundException {
		
//		Address add=repo.findById(bean.getAddressId()).get();
		Address add=repo.findById(id).get();
		if(add==null)
		{
			throw new AddressNotFoundException("Address Not Present");	
		}
		else {
//		add.setAddressId(bean.getAddressId());
		add.setBuildingName(bean.getBuildingName());
		add.setCity(bean.getCity());
		add.setCountry(bean.getCountry());
		add.setPincode(bean.getPincode());
		add.setState(bean.getState());
		add.setStreetNo(bean.getStreetNo());
		// TODO Auto-generated method stub
		return repo.save(add);
		}
	}
	
	
	public Address removeAddress(Integer addressId) throws AddressNotFoundException {
		
		Address add=repo.findById(addressId).get();
		if(add==null)
		{
			throw new AddressNotFoundException("Address Not Present");
		}
		else {
		repo.deleteById(addressId);
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<Address> viewAllAddress() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	public Address viewAddress(Integer addressId) throws AddressNotFoundException {
		
		Address add=repo.findById(addressId).get();
		if(add==null)
		{
			throw new AddressNotFoundException("Address Not Present");
		}
		else {
		// TODO Auto-generated method stub
			return repo.findById(addressId).get();
		}
	}
}
