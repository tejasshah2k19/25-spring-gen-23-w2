package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class SessionController {

	
	//jsp open method 
	@GetMapping("signup")//url -> browser 
	public String openSignup() //method 
	{
		return "Signup";//jsp name 
	}

	@GetMapping("login")
	public String login() {
		return "Login";
	}

	@PostMapping("saveuser")
	public String saveUser(UserBean user) {
		System.out.println(user.getEmail());
		return "Login";
	}
}



