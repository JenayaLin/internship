package com.tips.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.tips.demo.dao.TopicRepository;
import com.tips.demo.model.Topic;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

@Service
public class TopicService {
	Topic topic = new Topic();
	@Autowired
	TopicRepository repo;
	
	public int add(Topic topic) { 
		int c = repo.add(topic);
		return c;
	}
	
	public ArrayList<Topic> selectTopic() {
		// TODO Auto-generated method stub

		//先挑選五個數字之後放到arraylist裡
		//1. 知道總共多少題目
		ArrayList<Integer> selectedIDList = new ArrayList<Integer>();
		int totalTopicNum = repo.countTopics();
		//2. 挑五個數字
		
		
		//方法2:while
//		int limit = 0;
		while(selectedIDList.size()<5) {
//			limit++;
			SecureRandom random = new SecureRandom();
			int selectedID = random.nextInt(totalTopicNum);
			if(selectedID == 0) selectedID = 1;
			
			if(selectedIDList.size()==0) {
				selectedIDList.add(selectedID);
			}
			
			for (int i=0; i<selectedIDList.size(); i++){
				if (selectedID == selectedIDList.get(i)) { 
					 break;
				}
				 if (i==selectedIDList.size()-1 && selectedID != selectedIDList.get(i) ) {
					 selectedIDList.add(selectedID);
				}
			}
		}
		
		//3. 再用numArray裡的數字去query出對應的Topic並放進另一個array裡
		//但其實也可以在前面直接query完就加進list裡
		ArrayList<Topic> selectedTopic = new ArrayList<Topic>();
//		System.out.println("size : " + selectedIDList.size());
//		System.out.println("size : " + limit);

		
		for(int i = 0; i<=4; i++){
			//System.out.println(selectedIDList.get(i));
			int listNum= selectedIDList.get(i);
			//System.out.println(listNum);
			Topic singleTopic = repo.findByTopicID(listNum);
			selectedTopic.add(singleTopic);
		} 
			return selectedTopic;
	}
	
	

}

