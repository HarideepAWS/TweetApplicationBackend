package com.tweetapp.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.dao.UserDao;
import com.tweetapp.model.User;

@Service
public class LoginService {

	@Autowired
	Scanner scanner;

	@Autowired
	UserDao userDao;

	public User loginDetails() {

		User user = new User();
		
		System.out.println("Enter the Username");
		String userName = scanner.nextLine();
		System.out.println("Enter the Password");
		String passWord = scanner.nextLine();

		boolean isValidUser = userDao.verifyUser(userName, passWord);

		if (isValidUser) {
			user.setMailId(userName);
			return user;
		} else {
			return user;
		}

	}

	public void forgotPassword() {

		System.out.println("Enter the Username");
		String userName = scanner.nextLine();
		System.out.println("Please enter your dob");
		String dob = scanner.nextLine();

		boolean forgotpassword = userDao.forgotpassword(userName, dob);

		if (forgotpassword) {
			System.out.println("Enter the new password");
			String newPassword = scanner.nextLine();
			userDao.resetPassword(newPassword, userName);
			System.out.println("Password reset successful");
		} else {
			System.out.println("Invalid User");
		}

	}

}
