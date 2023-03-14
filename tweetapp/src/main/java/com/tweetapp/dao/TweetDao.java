package com.tweetapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.tweetapp.mapper.TweetRowMapper;
import com.tweetapp.model.Tweet;

@Component
public class TweetDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Tweet> getAllTweets() {
		String sql = "SELECT USER_ID, TWEET, INSERT_DTS FROM TWEETS";
		List<Tweet> tweets = (List) jdbcTemplate.query(sql, new TweetRowMapper());
		return tweets;
	}

	public List<Tweet> getMyTweets(String email) {
		String sql = "SELECT USER_ID, TWEET, INSERT_DTS FROM TWEETS where user_id = (SELECT ID FROM USER WHERE EMAIL = ?)";

		Object[] values = new Object[] { email };

		List<Tweet> tweets = (List) jdbcTemplate.query(sql, values, new TweetRowMapper());
		return tweets;
	}

	public void insertTweet(String tweet, String email) {

		String sql = "INSERT INTO TWEETS (USER_ID, TWEET, INSERT_DTS ) VALUES ((SELECT ID FROM USER WHERE EMAIL =?),?,CURRENT_TIMESTAMP)";
		Object[] values = new Object[] { email, tweet };
		jdbcTemplate.update(sql, values);

	}

}
