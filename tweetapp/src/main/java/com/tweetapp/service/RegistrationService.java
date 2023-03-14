package com.tweetapp.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.dao.UserDao;

@Service
public class RegistrationService {

	@Autowired
	Scanner scanner;

	@Autowired
	UserDao userDao;

	public void registerUser() {

		String firstName;
		String lastName;
		String gender;
		String dob;
		String email;
		String password;
		boolean uniqueEmail;

		do {
			System.out.println("Enter FirstName");
			firstName = scanner.nextLine();
		} while (firstName.isEmpty());

		System.out.println("Enter Last name");
		lastName = scanner.nextLine();

		do {
			System.out.println("Gender");
			gender = scanner.nextLine();
		} while (gender.isEmpty());

		System.out.println("Date of Birth");
		dob = scanner.nextLine();

		do {
			System.out.println("Enter e-mail");
			email = scanner.nextLine();
			uniqueEmail = userDao.UniqueEmail(email);

		} while (email.isEmpty() && uniqueEmail);

		do {
			System.out.println("Enter password");
			password = scanner.nextLine();
		} while (password.isEmpty());

		int insertUser = userDao.insertUser(firstName, lastName, gender, dob, email, password);

		if (insertUser == 1)
			System.out.println("User registered successfully...");

	}

}
