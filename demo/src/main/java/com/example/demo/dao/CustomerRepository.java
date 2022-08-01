package com.example.demo.dao;

import com.example.demo.model.Customer;

public interface CustomerRepository {
	
	int save(Customer customer);
	
	Customer findById(int id);

}
