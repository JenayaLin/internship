package com.example.demo.cotroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService ser;//src
	
	@RequestMapping(value="/orders/{id}", method=RequestMethod.GET)
	 public Order get(@PathVariable String id) {
			
		Order o = ser.findId(new String(id));
	   	return o;

	 }
	
	@RequestMapping(value="/orders", method=RequestMethod.POST)
	public int postOrder(@RequestBody Order postOrder) {
	    return ser.save(postOrder);
	  }
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
	public int postTransaction(@RequestBody Order newOrder ) throws IOException {
	    return ser.transaction(newOrder);
	  }

}
