package com.mytech.tkpost.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mytech.tkpost.entities.User;
import com.mytech.tkpost.entities.UserRole;
import com.mytech.tkpost.services.UserFilter;
import com.mytech.tkpost.services.UserRoleServiceImplimentation;
import com.mytech.tkpost.services.UserServiceImplimentation;

@RestController
@CrossOrigin(origins = "**")
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserServiceImplimentation userService;
	
	@Autowired
	UserRoleServiceImplimentation userRoleService;
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public boolean login(@RequestParam List<String> cridentials) {
		
		return userService.checkUser(cridentials);
	}
	
	@RequestMapping(value = "/register", method= RequestMethod.POST)
	public boolean register(@RequestParam  List<String> user) {
		
		User newUser = new User(user.get(0), user.get(1), user.get(2),user.get(3));
		   UserRole userRole= userRoleService.getRole(0);
		   System.out.println(userRole.getName());
		   newUser.setRoles(userRole);
		   System.out.println(newUser.getEmail());
		   System.out.println(newUser.getRoles());

		userService.register(newUser);	
		
		return true;
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public boolean selectRoles (@RequestParam String password) {
		
		return userService.changePassword(password);
		
	}

}
