//package com.cg.onlineshopping.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.cg.onlineshopping.entities.Address;
//import com.cg.onlineshopping.entities.Customer;
//import com.cg.onlineshopping.entities.Order;
//import com.cg.onlineshopping.exceptions.order.DateNotFoundException;
//import com.cg.onlineshopping.exceptions.order.LocationNotFoundException;
//import com.cg.onlineshopping.exceptions.order.OrderNotFoundException;
//import com.cg.onlineshopping.repositories.IOrderRepository;
//import com.cg.onlineshopping.services.IOrderServiceImplementation;
//
//
// @SpringBootTest
//public class OrderServiceTest {
//    
//	
//
//    @MockBean
//    IOrderRepository repo;
//    
//    @Autowired
//	IOrderServiceImplementation service;
//    
////    @InjectMocks
////    IOrderServiceImplementation service;
////     
// 
//    @BeforeEach
//	void setUp() throws Exception {
//	Address a=Address.builder().addressId(75).buildingName("Ajanta Apartment").city("Howrah").country("India").state("West Bengal").streetNo("a/b/4").pincode("711104").build();
//	Customer c=Customer.builder().customerId(0).firstName("Subhankar").lastName("Mondal").mobileNumber("98302892747784").status("Active").build();
//	Order o = Order.builder().orderId(74L).userName("subhankar@gmail.com").orderStatus("active").orderDate(LocalDate.now()).totalAmount(1000).customer(c).address(a).build();
//	Optional<Order> opt= Optional.of(o);
//	Mockito.when(repo.findById(74L)).thenReturn(opt);
//	
//	
//    }
//    
//   
//    @Test
//	void viewOrderTest() throws OrderNotFoundException
//	{
//	    Long id=74L;
//		Order o=service.viewOrder(id);
//		assertEquals(id, o.getOrderId());
//	}
//    
//    
//    @Test
//	void GetAllOrderTest()
//	{
////    	Address a=Address.builder().addressId(75).buildingName("Ajanta Apartment").city("Howrah").country("India").state("West Bengal").streetNo("a/b/4").build();
////    	Customer c=Customer.builder().customerId(0).firstName("Subhankar").lastName("Mondal").mobileNumber("98302892747784").status("Active").build();
//    	Address a=new Address(75,"a/b/4","Ajanta Apartment","Howrah","West Bengal","India","711104");
//    	Customer c=new Customer(76,"Subhankar","Mondal","","Active");
//		List<Order> orders = new ArrayList();
//		orders.add(new Order(74L,"subhankar@gmail.com","active",LocalDate.now(),1000,c,a));
//
//		when(repo.findAll()).thenReturn(orders);
//		List<Order> expected = service.viewAllOrders();
//		assertEquals(expected, orders);
//		verify(repo).findAll();
//	}
//    
//    
//	@Test
//	void RemoveOrderTest() throws OrderNotFoundException
//	{
//		Address a=new Address(75,"a/b/4","Ajanta Apartment","Howrah","West Bengal","India","711104");
//    	Customer c=new Customer(76,"Subhankar","Mondal","","Active");
//    	Order o = new Order(74L,"subhankar@gmail.com","active",LocalDate.now(),1000,c,a);
//    	when(repo.findById(o.getOrderId())).thenReturn(Optional.of(o));
//    	service.removeOrder(o.getOrderId());
//    	verify(repo).deleteById(o.getOrderId());
//	}
//	
//	
//	@Test
//	void UpdateOrderTest() 
//	{
//		Address a=new Address(75,"a/b/4","Ajanta Apartment","Howrah","West Bengal","India","711104");
//    	Customer c=new Customer(76,"Subhankar","Mondal","","Active");
//    	Order o = new Order(74L,"subhankar@gmail.com","active",LocalDate.now(),1000,c,a);
//    	
//    	
//    	Order o2 = new Order(74L,"subhankarmondal@gmail.com","active",LocalDate.now(),1000,c,a);
//		when(repo.findById(o.getOrderId())).thenReturn(Optional.of(o));
//		service.updateOrder(o.getOrderId(), o2);
//		verify(repo).save(o2);
//		verify(repo).findById(o.getOrderId());
//	}
//
//	
//	@Test
//	void viewAllOrdersByDateTest() throws DateNotFoundException{
//		Address a=new Address(75,"a/b/4","Ajanta Apartment","Howrah","West Bengal","India","711104");
//    	Customer c=new Customer(76,"Subhankar","Mondal","","Active");
//		List<Order> orders = new ArrayList();
//		orders.add(new Order(74L,"subhankar@gmail.com","active",LocalDate.now(),1000,c,a));
//
//		when(repo.findAllByOrderDate(LocalDate.now())).thenReturn(orders);
//		
//		List<Order> expected = service.viewAllOrdersByDate(LocalDate.now());
//		assertEquals(expected, orders);
//		verify(repo).findAllByOrderDate(LocalDate.now());
//		
//	}
//	
//	@Test
//	void viewAllOrdersByLocationTest() throws LocationNotFoundException{
//		Address a=new Address(75,"a/b/4","Ajanta Apartment","Howrah","West Bengal","India","711104");
//    	Customer c=new Customer(76,"Subhankar","Mondal","","Active");
//		List<Order> orders = new ArrayList();
//		orders.add(new Order(74L,"subhankar@gmail.com","active",LocalDate.now(),1000,c,a));
//		String loc ="Howrah";
//		when(repo.findAllByAddress_City(loc)).thenReturn(orders);
//		
//		List<Order> expected = service.viewAllOrdersByLocation(loc);
//		assertEquals(expected, orders);
//		verify(repo).findAllByAddress_City(loc);
//		
//	}
//	
////	@Test
////	void viewAllOrdersByUserIdTest() throws UserIdNotFoundException{
////		Address a=new Address(75,"a/b/4","Ajanta Apartment","Howrah","West Bengal","India","711104");
////    	Customer c=new Customer(76,"Subhankar","Mondal","","Active");
////		List<Order> orders = new ArrayList();
////		orders.add(new Order(74L,"subhankar@gmail.com","active",LocalDate.now(),1000,c,a));
////
////		when(repo.findAll()).thenReturn(orders);
////		
////		String id ="5";
////		List<Order> expected = service.viewAllOrderByUserId(id);
////		assertEquals(expected, orders);
////		verify(repo).getOrderByUserId(id);
////		
////	}
////    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
////    @Test
////    void viewAllOrdersTest()
////    {
////    	List<Order> o1= new ArrayList<Order>();
////    	List<Order> orderList = mock(o1.class);
////		//Mockito.when(CustRepo.findAll()).thenReturn(customerList);
////		List<Order> outputOrderList = service.viewAllOrders();
////		verify(CustRepo).findAll();
////		assertEquals(orderList, outputOrderList);
////    }
//    
////    @Test
////    public void test_viewAllOrders(){
////        List<Order> orders=new ArrayList<Order>();
////        orders.add(new orders(42,"subhankar@gmail.com","active","2021-07-21",1000,new ));
////    }
//    
////	@Test
////	@DisplayName("testing the department by name")
////	void fetchOrderByDateTest() {
////		
////		LocalDate date=LocalDate.now();
////		
////		ListOrder found =service.viewAllOrdersByDate(date);
////		
////		assertEquals(deptname, found.getDepartmentName());
////		
////		
////	}
//    
//    
////	@Test
////	@DisplayName("testing the department by Id")
////	void fetchOrderByDateTest() {
////		
////		Long id=2L;
////		
////		Order found =service.viewOrder(id);
////		
////		assertEquals(id, found.getOrderId());
////		
////		
////	}
////    
//	
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//     
////    @Test
////    public void getAllEmployeesTest()
////    {
////        List<EmployeeVO> list = new ArrayList<EmployeeVO>();
////        EmployeeVO empOne = new EmployeeVO(1, "John", "John", "howtodoinjava@gmail.com");
////        EmployeeVO empTwo = new EmployeeVO(2, "Alex", "kolenchiski", "alexk@yahoo.com");
////        EmployeeVO empThree = new EmployeeVO(3, "Steve", "Waugh", "swaugh@gmail.com");
////         
////        list.add(empOne);
////        list.add(empTwo);
////        list.add(empThree);
////         
////        when(dao.getEmployeeList()).thenReturn(list);
////         
////        //test
////        List<EmployeeVO> empList = manager.getEmployeeList();
////         
////        assertEquals(3, empList.size());
////        verify(dao, times(1)).getEmployeeList();
////    }
//     
////    @Test
////    public void getEmployeeByIdTest()
////    {
////        when(dao.getEmployeeById(1)).thenReturn(new EmployeeVO(1,"Lokesh","Gupta","user@email.com"));
////         
////        EmployeeVO emp = manager.getEmployeeById(1);
////         
////        assertEquals("Lokesh", emp.getFirstName());
////        assertEquals("Gupta", emp.getLastName());
////        assertEquals("user@email.com", emp.getEmail());
////    }
////     
////    @Test
////    public void createEmployeeTest()
////    {
////        EmployeeVO emp = new EmployeeVO(1,"Lokesh","Gupta","user@email.com");
////         
////        manager.addEmployee(emp);
////         
////        verify(dao, times(1)).addEmployee(emp);
////    }
//    
//    @Test
//	void contextLoads() {
//	}
//
//}