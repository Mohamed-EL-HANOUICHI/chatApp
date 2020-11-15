package com.mytech.tkpost.services;

import com.mytech.tkpost.entities.UserRole;

public class UserFilter {
	
	String firstName;
	String secondeName;
	String email;
	String password;
	
	
	public UserFilter(String firstName, String secondeName, String email, String password) {
		super();
		this.firstName = firstName;
		this.secondeName = secondeName;
		this.email = email;
		this.password = password;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondeName() {
		return secondeName;
	}

	public void setSecondeName(String secondeName) {
		this.secondeName = secondeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
