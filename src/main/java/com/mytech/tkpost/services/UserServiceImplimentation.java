package com.mytech.tkpost.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.tkpost.dao.UserRepository;
import com.mytech.tkpost.entities.User;
import com.mytech.tkpost.entities.UserRole;

@Service
public class UserServiceImplimentation {
	
	@Autowired
	UserRepository userRepository;

	public boolean checkUser(List<String> credentials) {
		
		String email= credentials.get(0);
		String password= credentials.get(1);
		User user = userRepository.FindUserByEmail(email);
		if (user!= null) {
			if(user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean selectProfil(String role) {
		
		return false;
	}

	
	public User register(User user) {
		
		return userRepository.save(user);
	}
	
	public User getUserById(long id) {
		
		return userRepository.FindUserById(id);
		
	}

	
	public boolean changePassword(String password) {
		
		return false;
	}
	

}
