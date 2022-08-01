package com.example.demo.service;

import java.io.IOException;
import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.OrderRepository;
import com.example.demo.dao.StockRepository;
import com.example.demo.model.Order;
import com.example.demo.model.Stock;


@Service
public class OrderService {
	
	Order order = new Order();
	
	@Autowired
	OrderRepository repo;
	
	@Autowired
	@Qualifier("JdbcStock") //幫你要autowired的地方命名
	StockRepository stockRepo;
	
	public Order findId(String id) {
		Order order = repo.findById(id);
		return order;
	}
	
	
	public int save(Order order) { 
		int c2 = repo.save(order);
		return c2;
	}
	
	
	@Transactional
	public int transaction(Order order) throws IOException{
		//a new order is coming
		
		//1. compareQuantity
		Stock stock = stockRepo.findById(order.getItem());
		
		if (order.getItemQuantity()<=stock.getStockQuantity()) {
			//2. update stock
			//int newQ =  stock.getStockQuantity()-order.getItemQuantity();
			//query = "UPDATE stock SET stockQuantity = ? ";
			/*jdbcTemplate.update(
	                "UPDATE stock SET stockQuantity = ? where item = ?", 
	                stock.getStockQuantity()-order.getItemQuantity(), order.getItem());
	                */
			stockRepo.updateStockQuantityByItemId(stock.getStockQuantity()-order.getItemQuantity(),order.getItem());
		
			//int ii = 1/0;
 			//3. save order
			save(order);
			return 1;
	    }
			
		else {
			throw new IOException();
//			return 0;
		}
	}
	
	public int save(Stock stock) { 
		int c2 = stockRepo.save(stock);
		return c2;
	}
}


