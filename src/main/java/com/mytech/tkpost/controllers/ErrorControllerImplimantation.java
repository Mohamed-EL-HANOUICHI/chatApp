package com.mytech.tkpost.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorControllerImplimantation implements ErrorController {
	
	private final static String PATH = "/error";

	@Override
	@RequestMapping(PATH)
	public String getErrorPath() {
		
		return "error in your path";
	}
	

}
