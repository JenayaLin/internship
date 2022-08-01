package com.example.demo.dao;

import com.example.demo.model.Order;

public interface OrderRepository {
	
	int save(Order order);
	
	Order findById(String iId);

}
