package com.cg.onlineshopping.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.exceptions.AddressNotFoundException;
import com.cg.onlineshopping.exceptions.FieldValueMismatchException;
import com.cg.onlineshopping.repositories.IAddressRepository;



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
		

		Address add=repo.findById(id).get();
		if(add==null)
		{
			throw new AddressNotFoundException("Address Not Present");	
		}
		else {

		add.setBuildingName(bean.getBuildingName());
		add.setCity(bean.getCity());
		add.setCountry(bean.getCountry());
		add.setPincode(bean.getPincode());
		add.setState(bean.getState());
		add.setStreetNo(bean.getStreetNo());
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
		return null;
	}
	
	
	@Override
	public List<Address> viewAllAddress() {
		return repo.findAll();
	}
	
	
	public Address viewAddress(Integer addressId) throws AddressNotFoundException {
		
		Address add=repo.findById(addressId).get();
		if(add==null)
		{
			throw new AddressNotFoundException("Address Not Present");
		}
		else {

			return repo.findById(addressId).get();
		}
	}
	
	@Override
	public void validateAddress(Address add) throws FieldValueMismatchException
	{
		String st=add.getStreetNo();
		String bd=add.getBuildingName();
		String city=add.getCity();
		String state=add.getState();
		String country=add.getCountry();
		String pin=add.getPincode();
		Pattern p= Pattern.compile("^[0-9]*$");
		Matcher m1=p.matcher(city);
		Matcher m2=p.matcher(state);
		Matcher m3=p.matcher(country);
		Matcher m4=p.matcher(pin);
		if(st=="")
		{
			throw new FieldValueMismatchException("Street number cannot be null");
		}
		
		else if(bd=="")
		{
			throw new FieldValueMismatchException("Building name cannot be null");
		}
		else if(city=="" || m1.matches())
		{
			throw new FieldValueMismatchException("City cannot be null or cannot contain numbers");
		}
		else if(state=="" || m2.matches())
		{
			throw new FieldValueMismatchException("State cannot be null or cannot contain numbers");
		}
		else if(country=="" || m3.matches())
		{
			throw new FieldValueMismatchException("Country cannot be null or cannot contain numbers");
		}
		else if (pin.length()!=6 || !m4.matches())
		{
			throw new FieldValueMismatchException("Pincode should be less than 6 digits and cannot contain Alphabets");
		}
	}
}
