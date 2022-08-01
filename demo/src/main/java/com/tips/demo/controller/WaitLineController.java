package com.tips.demo.controller;

//import java.security.SecureRandom;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tips.demo.model.WaitingNum;

@RestController
public class WaitLineController extends Object{

	
	@RequestMapping(value="/waitline", method=RequestMethod.GET)
	 public Object getResponseNum() {
		WaitingNum waitingNum = new WaitingNum();
		return waitingNum;
	}

}
