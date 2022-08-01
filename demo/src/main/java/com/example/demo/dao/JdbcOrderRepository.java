package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;

@Repository
public class JdbcOrderRepository implements OrderRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	 
	/*private Order[] orderList = new Order[0];*/
	@Override
	public int save(Order order) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "insert into orders (orderID, item, itemQuantity, itemPrice, totalPrice, customerID) values(?,?,?,?,?,?)",
                order.getOrderID(), order.getItem(),order.getItemQuantity(),order.getItemPrice(),order.getTotalPrice(),order.getCustomerID());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Order findById(String iId) {
		// TODO Auto-generated method stub
		String innerID= iId;
		 return jdbcTemplate.queryForObject(
	                "select orderID, item, itemQuantity, itemPrice, totalPrice, customerID from orders where orderID = ?",
	                new Object[]{innerID},
	                new RowMapper<Order>() {
						@Override
						public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							Order order = new Order();
							
							String orderID = rs.getString(1);
							String item = rs.getString(2);
							int itemQuantity = rs.getInt(3);
							int itemPrice = rs.getInt(4);
							int totalPrice = rs.getInt(5);
							int customerID = rs.getInt(6);
							
							order.setOrderID(orderID);
							order.setItem(item);
							order.setItemQuantity(itemQuantity);
							order.setItemPrice(itemPrice);
							order.setTotalPrice(totalPrice);
							order.setCustomerID(customerID);
							
							return order;
						}
	                	
	                }
	           
	                 
				 );
	}
	/*public Order[] getOrderList() {
		return orderList;
	}*/

}
