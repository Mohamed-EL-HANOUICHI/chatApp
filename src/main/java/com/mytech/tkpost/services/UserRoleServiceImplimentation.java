package com.mytech.tkpost.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.tkpost.dao.UserRoleRepository;
import com.mytech.tkpost.entities.UserRole;

@Service
public class UserRoleServiceImplimentation{

	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	
	
	public UserRole getRole(long id) {
		  
		return userRoleRepository.FindRoleById(id);
		
	}
	
	

}
