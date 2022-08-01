package com.example.demo.model;

import org.springframework.lang.Nullable;

public class Order {
	
	private String orderID;
	private String item;
	private int privateitemQuantity;
	@Nullable
	private int itemPrice;
	private int totalPrice;
	private int customerID;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getItemQuantity() {
		return privateitemQuantity;
	}
	public void setItemQuantity(int privateitemQuantity) {
		this.privateitemQuantity = privateitemQuantity;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
}
