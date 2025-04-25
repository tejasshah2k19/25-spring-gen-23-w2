package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bean.UserBean;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dao.UserDao;
import com.service.MailerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	MailerService mailerService;
	// jsp open method

	@Autowired
	private Cloudinary cloudinary;

//	@GetMapping("signup")//url -> browser 

	@GetMapping(value = { "signup", "/" })
	public String openSignup() // method
	{
		return "Signup";// jsp name
	}

	@GetMapping("login")
	public String login() {
		return "Login";
	}

	@PostMapping("saveuser")
	public String saveUser(UserBean user, MultipartFile profilePic) {
		System.out.println(user.getEmail());
		// encrypt
		// Bcrypt
		// spring security ->
		// spring crypto

		System.out.println(profilePic.getOriginalFilename());

		try {
			
		Map uploadResult = 	cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
			
		String profilePicUrl = uploadResult.get("url").toString();
		
		user.setProfilePicUrl(profilePicUrl);	
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		String encPassword = encoder.encode(user.getPassword());
		user.setPassword(encPassword);

		userDao.addUser(user);
		// dao
		// addUser

//		Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				// welcome mail -> simple text
//				mailerService.sendWelcomeMail(user.getEmail(), user.getFirstName());
//			}
//		});
//		t.start();

		return "Login";
	}

	@PostMapping("authenticate")
	public String authenticate(String email, String password,HttpSession session) {

		// select * from users where email = :email and password = :password
		UserBean dbUser = userDao.getByEmail(email);

		if (dbUser != null && encoder.matches(password, dbUser.getPassword())) {
		
			session.setAttribute("user", dbUser);
			
			return "Home";
		} else {
			return "Login";
		}
	}

}
