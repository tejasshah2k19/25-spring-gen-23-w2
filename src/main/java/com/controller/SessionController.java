package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;
	
	
	@Autowired
	PasswordEncoder encoder;
	
	
	//jsp open method 
	
//	@GetMapping("signup")//url -> browser 
	
	@GetMapping(value = {"signup","/"})
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
		//encrypt 
		//Bcrypt 
		//spring security -> 
		//spring crypto 
		
		String encPassword = encoder.encode(user.getPassword());
		user.setPassword(encPassword);
		 
		userDao.addUser(user);
		//dao 
		//addUser
		return "Login";
	}
}



