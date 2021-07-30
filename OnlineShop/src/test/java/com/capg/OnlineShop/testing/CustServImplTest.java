package com.capg.OnlineShop.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.OnlineShop.Exception.AddressNotFoundException;
import com.capg.OnlineShop.Exception.CustomerNotFoundException;
import com.capg.OnlineShop.entities.Address;
import com.capg.OnlineShop.entities.Customer;
import com.capg.OnlineShop.entities.User;
import com.capg.OnlineShop.repository.IAddressRepository;
import com.capg.OnlineShop.repository.ICustomerRepository;
import com.capg.OnlineShop.repository.IUserRepository;
import com.capg.OnlineShop.service.IAddressService;
import com.capg.OnlineShop.service.ICustomerService;
import com.capg.OnlineShop.service.IUserService;



@SpringBootTest
public class CustServImplTest {
	
	@MockBean
	private ICustomerRepository CustRepo;
	@Autowired
	private ICustomerService service;
	
	@MockBean
	private IUserRepository UserRepo;
	@Autowired
	private IUserService serv;
	
	@MockBean
	private IAddressRepository AddRepo;
	@Autowired
	private IAddressService addServ;
	
	@BeforeEach
	void setup () throws Exception
	{
		Customer cust1=Customer.builder().customerId(1).firstName("Rohit").lastName("Roy").mobileNumber("1234567890").status("Active").build();
		Optional<Customer> opt= Optional.of(cust1);
		Mockito.when(CustRepo.findById(1)).thenReturn(opt);
		
		Address add1=Address.builder().addressId(1).streetNo("22/A").buildingName("Mohan").city("Kol").state("WB").country("India").pincode("700105").build();
		Optional<Address> opt1= Optional.of(add1);
		Mockito.when(AddRepo.findById(1)).thenReturn(opt1);
		
//		Customer cust2=Customer.builder().customerId(1).firstName("Rohit").lastName("Roy").mobileNumber("1234567890").status("Active").build();
//		Optional<Customer> opt1= Optional.of(cust2);
//		Mockito.when(CustRepo.findById(1)).thenReturn(opt1);
		
//		Customer cust1=Customer.builder().customerId(1).firstName("Rohit").lastName("Roy").mobileNumber("1234567890").status("Active").build();
//		Mockito.when(CustRepo.FindByFirstName("Rohit")).thenReturn(cust1);
	}
	
	@Test
	void GetCustByIdTest() throws CustomerNotFoundException
	{
		int id=1;
		Customer cs=service.viewCustomer(id);
		assertEquals(id, cs.getCustomerId());
	}
	
//	@Test
//	void SaveCustomerTest()
//	{
//		Customer cust = new Customer(1,"Rohit","Roy","1234567890","Active");
//		.setName(“Test Name”);
//		when(CustRepo.save(ArgumentMatchers.any(Customer.class))).thenReturn(cust);
//		Customer created = service.addCustomer(cust);
//		when(created.getFirstName()).thenReturn(cust.getFirstName());
//		verify(CustRepo).save(cust);
//	}
	
	@Test
	void GetAllCustTest()
	{
	
		List<Customer> cust = new ArrayList();
		List <Address> al=new ArrayList<Address>();
		al.add(new Address(100,"22/A","Mohan","Kol","WB","India","700105"));
		cust.add(new Customer(1,"Rohit","Roy","1234567890","Active",al));

		when(CustRepo.findAll()).thenReturn(cust);
		List<Customer> expected = service.ViewAllCustomers();
		assertEquals(expected, cust);
		verify(CustRepo).findAll();
		}
	
	@Test
	void RemoveByIdTest() throws CustomerNotFoundException
	{
		List <Address> al=new ArrayList<Address>();
		al.add(new Address(100,"22/A","Mohan","Kol","WB","India","700105"));
    Customer cust1 = new Customer(1,"Rohit","Roy","1234567890","Active",al);
    when(CustRepo.findById(cust1.getCustomerId())).thenReturn(Optional.of(cust1));
    service.removeCustomer(cust1.getCustomerId());
    verify(CustRepo).deleteById(cust1.getCustomerId());
	}
	
	@Test
	void UpdateCustomerTest() throws CustomerNotFoundException
	{
		List <Address> al=new ArrayList<Address>();
		al.add(new Address(100,"22/A","Mohan","Kol","WB","India","700105"));
		Customer cust = new Customer(1,"Rohit","Roy","1234567890","Active",al);
		Customer newcust = new Customer(1,"Utkarsh","Parashar","1234567890","Active",al);
		when(CustRepo.findById(cust.getCustomerId())).thenReturn(Optional.of(cust));
		service.updateCustomerProfile(cust.getCustomerId(), newcust);
		verify(CustRepo).save(newcust);
		verify(CustRepo).findById(cust.getCustomerId());
	}
	
	@Test
	void GetAllUserTest() 
	{
	
		List<User> user = new ArrayList();
		List <Address> al=new ArrayList<Address>();
		al.add(new Address(100,"22/A","Mohan","Kol","WB","India","700105"));
		Customer cust= new Customer(1,"Rohit","Roy","1234567890","Active",al);
		user.add(new User(1,"roy@123","rohit678","Admin","roy@abc.com", cust));

		when(UserRepo.findAll()).thenReturn(user);
		List<User> expected = serv.ViewAllUsers();
		assertEquals(expected, user);
		verify(UserRepo).findAll();
	}
	
	@Test
	void GetAddByIdTest() throws AddressNotFoundException
	{
		int id=1;
		Address ad=addServ.viewAddress(id);
		assertEquals(id,ad.getAddressId());
	}
	
	@Test
	void GetAllAddTest()
	{
	
		List<Address> ad = new ArrayList();
		ad.add(new Address(1,"22/A","Mohan","Kol","WB","India","700105"));

		when(AddRepo.findAll()).thenReturn(ad);
		List<Address> expected = addServ.viewAllAddress();
		assertEquals(expected, ad);
		verify(AddRepo).findAll();
	}
	
	
	@Test
	void RemoveAddByIdTest() throws AddressNotFoundException
	{
    Address ad = new Address(1,"22/A","Mohan","Kol","WB","India","700105");
    when(AddRepo.findById(ad.getAddressId())).thenReturn(Optional.of(ad));
    addServ.removeAddress(ad.getAddressId());
    verify(AddRepo).deleteById(ad.getAddressId());
	}
	
	
	@Test
	void UpdateAddressTest() throws AddressNotFoundException
	{
		Address ad = new Address(1,"22/A","Mohan","Kol","WB","India","700105");
		Address newad = new Address(1,"22/A","Sarojini","Mumbai","Maharashtra","India","123987");
		when(AddRepo.findById(ad.getAddressId())).thenReturn(Optional.of(ad));
		addServ.updateAddress(ad.getAddressId(), newad);
		verify(AddRepo).save(newad);
		verify(AddRepo).findById(ad.getAddressId());
	}
	
	
	@Test
	void contextLoads() {
	}

}

