package com.tips.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tips.demo.model.Topic;
import com.tips.demo.model.RsData;
import com.tips.demo.service.TopicService;

@RestController
public class TopicController{
	
	@Autowired
	TopicService src;
	
	@RequestMapping(value="/topics", method=RequestMethod.GET)
	public RsData getResult(){
		
		RsData rsdata= new RsData(); 
		ArrayList<Topic> rsArray= new ArrayList<Topic>();
		rsArray = src.selectTopic();
		rsdata.setReponseArrayList(rsArray);
		return rsdata;
	}
	
	@RequestMapping(value="/topicsAdding", method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse resp, HttpSession session,HttpHeaderSecurityFilter a ) throws Exception{

		String key =  request.getHeader("sessionId");
		System.out.print(key);
		if( key.equals("token-success")) {
			
			src.add(topic);
		}
		else {
			
			resp.setStatus(401);
		}
		
	}
	
	
	/*
	@RequestMapping(value="/topics", method=RequestMethod.GET)
	 public ArrayList<Topic> get() throws IOException{
		ArrayList<Topic> selectedTopic = new ArrayList<Topic>();
		selectedTopic = src.selectTopic();
		if(true) {
			throw new IOException();
		}
		
		return selectedTopic;
	}
	*/


}
