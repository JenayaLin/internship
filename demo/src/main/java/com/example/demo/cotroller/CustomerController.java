package com.example.demo.cotroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService ser;
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
	 public Customer get(@PathVariable int id) {
			
	   	Customer c = ser.findId(id);
	   	return c;

	 }
	
//	@PostMapping("/customer")
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	 public int postCustomer(@RequestBody Customer postCustomer) {
	    return ser.save(postCustomer);
	  }
	
	@RequestMapping(value="/customer/login", method=RequestMethod.POST)
	 public String loginCustomer(@RequestBody Customer loginInfo, HttpServletRequest request, HttpServletResponse resp) {
		String status = ser.login(loginInfo.getCustomerID(),loginInfo.getPassword());
		if(status.equals("Login Success!")) {
			
			request.getSession().setAttribute("authorization", "token-token");
			resp.setHeader("sessionId", "token-success");
		}
		
		return status;
	  }
	
	
	//@PostMapping("/customer") /?????
	//ResponseEntity<?> newCustomer(@RequestBody Customer newCustomer) {

	//  EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));

	//  return ResponseEntity //
	//      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
	//      .body(entityModel);
	//}
	
	//Json
	/*
	{  "customerID": 2,
    "name": "Henry",
    "age": 16
    }
	*/
	
	//@RequestMapping(value="/customer", method=RequestMethod.POST)
	// public Customer post(@PathVariable Customer customer) {
			//**
	//   	Customer c1 = ser.save(new Customer customer);
	//   	return c1;

	// }
	
	
	//@Autowired
	//CustomerRepository repo;
	
	
   //@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
   //public Customer get(@PathVariable int id) {
		
   //	Customer c = repo.findById(new Long(id));
   //	return c;

   // }
}
