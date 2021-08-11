package com.cg.onlineshopping.services;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Order;
import com.cg.onlineshopping.exceptions.DateNotFoundException;
import com.cg.onlineshopping.exceptions.LocationNotFoundException;
import com.cg.onlineshopping.exceptions.OrderNotFoundException;
import com.cg.onlineshopping.exceptions.UserIdNotFoundException;
import com.cg.onlineshopping.repositories.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderRepository repo;

    //Done
    @Override
    public Order addOrder(Order order){
        return repo.save(order);
    }

public Order updateOrder(Long id,Order order){
    	
    	Order o = repo.findById(id).get();

    	if (Objects.nonNull(order.getOrderStatus()) && !"".equalsIgnoreCase(order.getOrderStatus())) {
			o.setOrderStatus(order.getOrderStatus());
		}
    	
    	if (Objects.nonNull(order.getOrderDate())) {
			o.setOrderDate(order.getOrderDate());
		}
    	
    	if (Objects.nonNull(order.getTotalAmount())) {
			o.setTotalAmount(order.getTotalAmount());
		}
	
	
		
    	return repo.save(o);
    	
    }
    
    @Override
    public Order removeOrder(Long id) throws OrderNotFoundException{
    	
    	
    	Optional<Order> order = repo.findById(id);
    	 if(!order.isPresent())
 		{
    		 throw new OrderNotFoundException("Order is not available");
 		}
    	 else
    	 {
    		 repo.deleteById(id);
    	 }
    	 return null;
     
    	
    }

    @Override
    public Order viewOrder(Long id) throws OrderNotFoundException {
    	Optional<Order> order = repo.findById(id);
   	 if(!order.isPresent())
		{
   		 throw new OrderNotFoundException("Order is not available");
		}
   	 
   	 
   		 return order.get();
   	 
    	
    }
    
    //Done
    @Override
    public List<Order> viewAllOrders(){
    	return repo.findAll();
    }
    
    @Override
    public List<Order> viewAllOrdersByDate(LocalDate date) throws DateNotFoundException{
    	
    	List<Order> order= repo.findAllByOrderDate(date);
	    if(order.isEmpty())
	    {
	    	throw new DateNotFoundException(" There is no order made in this date");
	    }
	    else
	    {
	    	return repo.findAllByOrderDate(date);
	    }
    	
    	
    }
    
    
    @Override
    public List<Order> viewAllOrdersByLocation(String city) throws LocationNotFoundException{
    	
    	List<Order> order= repo.findAllByAddress_City(city);
	    if(order.isEmpty())
	    {
	    	throw new LocationNotFoundException(" There is no order in this location");
	    }
	    else
	    {
	    	return order;
	    }
    	
    	
    }
 
    
    
    @Override
    public List<Order> viewAllOrderByUserId(String userId) throws UserIdNotFoundException{
    	List<Order> order= repo.getOrderByUserId(userId);
	    if(order.isEmpty())
	    {
	    	throw new UserIdNotFoundException(" There is no order made by this userId");
	    }
	    else
	    {
	    	return order;
	    }
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    
////    public List<Order> viewAllOrderByProductCategoryAndBrand(String productName,String brandName){
////    	
////    }
//    
//    @Override
//    public List<Order> viewAllOrderByBrandName(String brandName){
//    	List<Order>  li=repo.findByBrand(brandName);
//    	return li;
//    	
//    }
//    
//    @Override
//    public List<Order> viewAllOrderByStatus(String status){
//    	List<Order>  li=repo.findByStatus(status);
//    	return li;
//    }
//    
//    @Override
//    public List<Order> viewAllOrderByProductCategory(String category){
//	  List<Order>  li=repo.findByCategory(category);
//  		return li;
//  }
//



}
