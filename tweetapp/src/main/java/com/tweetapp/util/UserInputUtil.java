package com.tweetapp.util;

import org.springframework.stereotype.Component;

@Component
public class UserInputUtil {

	public void inValid() {
		System.out.println("Enter the option  ");
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("3.Forgot Password");
		System.out.println("4.Exit");
	}

	public void valid() {

		System.out.println("Enter the option");
		System.out.println("1.Post a Tweet");
		System.out.println("2.View My tweets");
		System.out.println("3.View all tweets");
		System.out.println("4.View all Users");
		System.out.println("5.Reset Password");
		System.out.println("6.Logout");
		System.out.println("7.Exit");
	}

}
