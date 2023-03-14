package com.tweetapp.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.dao.TweetDao;
import com.tweetapp.dao.UserDao;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.User;

@Service
public class TweetService {

	@Autowired
	TweetDao tweetDao;

	@Autowired
	UserDao userDao;

	@Autowired
	SessionDetails sessionDetails;

	@Autowired
	Scanner scanner;

	public void getAllTweets() {
		List<Tweet> allTweets = tweetDao.getAllTweets();

		for (Tweet tweet : allTweets) {

			StringBuffer sb = new StringBuffer();
			sb.append(tweet.getUser_id());
			sb.append(" ");
			sb.append(tweet.getTweet());
			sb.append(" ");
			sb.append(tweet.getTimestamp());

			System.out.println(sb.toString());

		}
	}

	public void userLogout() {
		sessionDetails.setLogged(false);
		System.out.println("Logged Out Successfully");

	}

	public void getAllUsers() {

		List<User> allUsers = userDao.getAllUsers();

		System.out.println("Users: ");

		for (User user : allUsers) {
			System.out.println(user.getFirstName());
		}

	}

	public void getMyTweets(User processLoggedUser) {
		List<Tweet> myTweets = tweetDao.getMyTweets(processLoggedUser.getMailId());

		for (Tweet tweet : myTweets) {
			System.out.println(tweet.getTweet());
		}

	}

	public void postTweet(User processLoggedUser) {
		System.out.println("Enter your Tweet");
		String tweet = scanner.nextLine();
		String email = processLoggedUser.getMailId();

		tweetDao.insertTweet(tweet, email);

		System.out.println("Tweet Posted Successfully");
	}

	public void resetPassword(User processLoggedUser) {
		String oldPassword = null;
		boolean oldPasswordValidation = false;

		System.out.println("Enter your mail id");
		String email = scanner.nextLine();

		if (email.equalsIgnoreCase(processLoggedUser.getMailId())) {
			System.out.println("Enter your current password");
			oldPassword = scanner.nextLine();
			oldPasswordValidation = userDao.oldPasswordValidation(oldPassword, email);
		} else {
			System.out.println("Invalid User");
		}

		if (oldPasswordValidation) {
			System.out.println("Enter the New Password");
			String newPassword = scanner.nextLine();

			userDao.resetPassword(email, newPassword);
			
			System.out.println("Password Reset successfully");
		}

	}

}
