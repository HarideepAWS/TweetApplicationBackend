package com.tweetapp.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.model.User;
import com.tweetapp.util.UserInputUtil;

@Service
public class AuthenticationService {

	@Autowired
	SessionDetails sessionDetails;

	@Autowired
	User processLoggedUser ;
	
	@Autowired
	Scanner scanner;

	@Autowired
	UserInputUtil userInputUtil;

	@Autowired
	RegistrationService registrationService;

	@Autowired
	LoginService loginService;

	@Autowired
	TweetService tweetService;

	public void validateSession() {

		if (!sessionDetails.isLogged()) {
			userInputUtil.inValid();
			processLoggedUser = processNonLoggedUser();

		} else if(processLoggedUser.getMailId()!=null)
		{
			userInputUtil.valid();
			processLoggedUser(processLoggedUser);
		}

	}

	private User processNonLoggedUser() {
		String menuOpt = scanner.nextLine();
		User user = new User();
		if ("1".equals(menuOpt)) {
			registrationService.registerUser();

		} else if ("2".equals(menuOpt)) {
			user = loginService.loginDetails();

			if (user.getMailId() == null) {
				sessionDetails.setLogged(false);
				System.out.println("Invalid Details, Plese Try again");
			} else {
				sessionDetails.setLogged(true);
			}

		} else if ("3".equals(menuOpt)) {
			loginService.forgotPassword();

		} else if ("4".equals(menuOpt)) {
			System.exit(0);
		} else {
			System.out.println("Invalid Option, please try again...");
		}
		return user;

	}

	private void processLoggedUser(User processLoggedUser) {

		String menuOpt = scanner.nextLine();

		System.out.println("================================================");
		
		if ("1".equals(menuOpt)) {
			tweetService.postTweet(processLoggedUser);

		} else if ("2".equals(menuOpt)) {
					
			tweetService.getMyTweets(processLoggedUser);

		} else if ("3".equals(menuOpt)) {
			// view all tweets
			tweetService.getAllTweets();

		} else if ("4".equals(menuOpt)) {
			// view all users
			tweetService.getAllUsers();

		} else if ("5".equals(menuOpt)) {
			tweetService.resetPassword(processLoggedUser);

		} else if ("6".equals(menuOpt)) {

			tweetService.userLogout();

		} else if ("7".equals(menuOpt)) {
			System.exit(0);
		} else {
			System.out.println("Invalid Option, please try again...");
		}

		System.out.println("================================================");
	}

}
