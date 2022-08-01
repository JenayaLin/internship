package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;

@Service
public class CustomerService {
	
	Customer customer = new Customer();
	
	@Autowired
	CustomerRepository repo;
	
	public Customer findId(int id) {
		Customer customer = repo.findById(id);
		return customer;
	}
	public int save(Customer customer) { 
		int c2 = repo.save(customer);
		return c2;
	}
	public String login(int id, String password) {
		// TODO Auto-generated method stub
		Customer customer = findId(id);
		String truePassword = customer.getPassword();
		if (password.equals(truePassword)==true) {
			return "Login Success!";
		}
		else if  (password.equals(truePassword)==false){
			return "Wrong Password...";
		}
		else {
			return "Try Again";
		}
		
	}
	
}
