package com.mytech.tkpost.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import com.mytech.tkpost.dao.UserRepository;
import com.mytech.tkpost.entities.User;

public class UserServerImplimentationTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImplimentation userSerice;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void checkUser() {
		
		List<User> users = new ArrayList<User>();
		User userOne = new User("farouk", "med ma", "farouk@med.com", "simo");
		users.add(userOne);
		
		when(userRepository.FindUserByEmail(userOne.getEmail())).thenReturn(userOne);
		
		//when(userOne.getPassword()).thenReturn("simo");
		
		List<String>  cred = new ArrayList<String>();
		cred.add("farouk@med.com");
		cred.add("simo");
		assertTrue(userSerice.checkUser(cred));
		
	
	}
	@Test
	public void register() {
		
		List<User> users = new ArrayList<User>();
		User userOne = new User("farouk", "med ma", "farouk@med.com", "simo");
		User userTwo = new User("farouk", "med ma", "farouk@med.com", "simo");

		users.add(userOne);
		when(userRepository.save(userOne)).thenReturn(userOne);
		
		assertEquals(userSerice.register(userOne), userOne);
		
		
	}

}
