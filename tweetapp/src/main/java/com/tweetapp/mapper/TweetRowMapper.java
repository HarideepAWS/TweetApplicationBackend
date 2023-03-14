package com.tweetapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tweetapp.model.Tweet;

public class TweetRowMapper implements RowMapper<Tweet> {

	@Override
	public Tweet mapRow(ResultSet rs, int arg1) throws SQLException {

		Tweet tweet = new Tweet();
		tweet.setUser_id(rs.getInt("USER_ID"));
		tweet.setTweet(rs.getString("TWEET"));
		tweet.setTimestamp(rs.getString("INSERT_DTS"));

		return tweet;
	}

}
