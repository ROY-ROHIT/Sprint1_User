package com.cg.onlineshopping.services;


import java.time.LocalDate;
import java.util.List;

import com.cg.onlineshopping.entities.Order;
import com.cg.onlineshopping.exceptions.DateNotFoundException;
import com.cg.onlineshopping.exceptions.LocationNotFoundException;
import com.cg.onlineshopping.exceptions.OrderNotFoundException;
import com.cg.onlineshopping.exceptions.UserIdNotFoundException;

public interface IOrderService {
    public Order addOrder(Order order);
    public Order updateOrder(Long id,Order order);
    public Order removeOrder(Long id) throws OrderNotFoundException;

    public Order viewOrder(Long id) throws OrderNotFoundException;
    public List<Order> viewAllOrders();
    public List<Order> viewAllOrdersByDate(LocalDate date) throws DateNotFoundException;
    
    
    public List<Order> viewAllOrdersByLocation(String city) throws LocationNotFoundException;
    public List<Order> viewAllOrderByUserId(String userId) throws UserIdNotFoundException;
    
    
    
    
    
    
    
    
    
    
    
    
    
    

////    public List<Order> viewAllOrderByProductCategoryAndBrand(String productName,String brandName);
//    public List<Order> viewAllOrderByBrandName(String brandName);
//    public List<Order> viewAllOrderByStatus(String status);
//    public List<Order> viewAllOrderByProductCategory(String category);


}