package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public class JdbcCustomerRepository implements CustomerRepository{

	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	 
	@Override
	public int save(Customer customer) { //why int -> return the num of row affected
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "insert into customer (customerID, name, age) values(?,?,?)",
                customer.getCustomerID(), customer.getName(),customer.getAge());
	}

	@SuppressWarnings("deprecation") //不要顯示黃色那個警告
	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		int innerID=id;
		 return jdbcTemplate.queryForObject(
	                "select customerID, name, age, password from customer where customerID = ?",
	                new Object[]{innerID},
	                new RowMapper<Customer>() {
						@Override
						public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							Customer customer = new Customer();
							
							int customerID = rs.getInt(1);
							String name = rs.getString(2);
							int age = rs.getInt(3);
							String password = rs.getString(4);
							
							customer.setCustomerID(customerID);
							customer.setName(name);
							customer.setAge(age);
							customer.setPassword(password);
							
							return customer;
						}
	                	
	                }
				 );
	}
	
}
