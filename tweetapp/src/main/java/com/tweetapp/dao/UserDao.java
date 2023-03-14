package com.tweetapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.tweetapp.mapper.UserRowMapper;
import com.tweetapp.model.User;

@Component
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<User> getAllUsers() {
		String sql = "SELECT * FROM USER";
		List<User> users = (List) jdbcTemplate.query(sql, new UserRowMapper());
		return users;
	}

	public int insertUser(String firstName, String lastName, String gender, String dob, String email, String password) {

		String sql = "INSERT INTO USER (FIRST_NAME, LAST_NAME, GENDER, DOB, EMAIL , PASSWORD) VALUES (?,?,?,?,?,?)";
		Object[] values = new Object[] { firstName, lastName, gender, dob, email, password };

		int update = jdbcTemplate.update(sql, values);

		return update;

	}

	public boolean UniqueEmail(String email) {

		String sql = "SELECT * FROM USER WHERE EMAIL = ?";
		Object[] values = new Object[] { email };
		List<User> users = jdbcTemplate.query(sql, values, new UserRowMapper());

		if (users.isEmpty() || users.size() == 1) {
			return true;
		}

		return false;
	}

	public boolean verifyUser(String userName, String passWord) {

		String sql = "SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?";
		Object[] values = new Object[] { userName, passWord };
		List<User> users = jdbcTemplate.query(sql, values, new UserRowMapper());

		if (users.size() == 1) {
			return true;
		}

		return false;

	}

	public boolean forgotpassword(String userName, String dob) {

		String sql = "SELECT * FROM USER WHERE EMAIL = ? AND DOB = ?";
		Object[] values = new Object[] { userName, dob };
		List<User> users = jdbcTemplate.query(sql, values, new UserRowMapper());

		if (users.size() == 1) {
			return true;
		}

		return false;

	}

	public void resetPassword(String newPassword, String userName) {
		String sql = "UPDATE USER SET PASSWORD= ? WHERE  EMAIL=?";
		Object[] values = new Object[] { userName, newPassword };

		int update = jdbcTemplate.update(sql, values);

	}

	public boolean oldPasswordValidation(String oldPassword, String email) {
		String sql = "SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?";

		Object[] values = new Object[] { email ,oldPassword};

		List<User> users = jdbcTemplate.query(sql, values, new UserRowMapper());

		if (users.size() == 1) {
			return true;
		}

		return false;

	}

}
