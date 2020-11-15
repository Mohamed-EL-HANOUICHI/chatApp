package com.mytech.tkpost.controllers;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.mytech.tkpost.entities.User;
import com.mytech.tkpost.services.UserServiceImplimentation;

import javassist.expr.NewArray;

public class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserServiceImplimentation userService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void loginTest() throws Exception {
		
		String url = "/api/login";
		int status;
		User user = new User("", "", "", "");
		List<String> cred = new ArrayList<String>();
		cred.add("");
		cred.add("");
		
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(url))
				              .andReturn();
		status = mvcResult.getResponse().getStatus();
		
		
		
		assertEquals(201,status);
		
		assertEquals(201,status);

		
		
		
	}

}
