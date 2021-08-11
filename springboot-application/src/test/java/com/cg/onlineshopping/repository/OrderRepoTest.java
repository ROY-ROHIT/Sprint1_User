//package com.cg.onlineshopping.repository;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import com.cg.onlineshopping.entities.Order;
//import com.cg.onlineshopping.repositories.IOrderRepository;
//
//
//@DataJpaTest
//public class OrderRepoTest {
//	@Autowired
//	private IOrderRepository repo;
//	@Autowired
//	private TestEntityManager ent;
//	
//	@BeforeEach
//	void setup() throws Exception
//	{
////		Department dept=Department.builder().departmentCode("ECE-12").departmentName("Electronics").build();
////		ent.persist(dept);
//	}
//	
//	@Test
//	void findByIdTest ()
//	{
//		
//		String name="sam123";
//		Order o=repo.findById(1L).get();
//		assertEquals(o.getUserName(), name);
//	}
//	
//	@Test
//	void RemoveOrderTest ()
//	{
//		
//		String name="sam123";
//		Order o=repo.findById(1L).get();
//		assertEquals(o.getUserName(),name);
//	}
//	
//	
//}
//	