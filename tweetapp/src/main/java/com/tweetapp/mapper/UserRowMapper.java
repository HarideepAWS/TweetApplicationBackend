package com.tweetapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tweetapp.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {

		User user = new User();
		user.setId(rs.getInt("ID"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setMailId(rs.getString("EMAIL"));

		return user;
	}

}
