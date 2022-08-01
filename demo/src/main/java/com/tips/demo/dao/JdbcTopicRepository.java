package com.tips.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tips.demo.model.Topic;

@Repository
public class JdbcTopicRepository implements TopicRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@SuppressWarnings("deprecation")
	@Override
	public int countTopics() {
		// TODO Auto-generated method stub
		//"SELECT COUNT(topicID) FROM topics"
		return jdbcTemplate.queryForObject("SELECT COUNT(topicID) FROM topics", new Topic[] {}, Integer.class );
		//氣鼠我搞不定
	}
	
	@Override
	public int add(Topic topic) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "insert into topics (topicID, title, subTitle, content1, content2) values(?,?,?,?,?)",
                topic.getTopicID(), topic.getTitle(), topic.getSubTitle(), topic.getContent1(), topic.getContent2());
	}


	
	@SuppressWarnings("deprecation")
	@Override
	public Topic findByTopicID(int topicID) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
                "SELECT topicID, title, subTitle, content1, content2 FROM topics WHERE topicID = ?",
                new Object[]{topicID},
                new RowMapper<Topic>() {
					@Override
					public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Topic topic = new Topic();
						
						int topicID = rs.getInt(1);
						String title = rs.getString(2);
						String subTitle = rs.getString(3);
						String content1 = rs.getString(4);
						String content2 = rs.getString(5);
						
						topic.setTopicID(topicID);
						topic.setTitle(title);
						topic.setSubTitle(subTitle);
						topic.setContent1(content1);
						topic.setContent2(content2);
						
						return topic;
					}
                }
                 
			 );
	}
}
