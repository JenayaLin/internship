package com.tips.demo.dao;

import org.springframework.stereotype.Repository;

import com.tips.demo.model.Topic;

@Repository
public interface TopicRepository {
	
	int countTopics();
	
	int add(Topic topic);
	
	Topic findByTopicID(int topicID);

}
