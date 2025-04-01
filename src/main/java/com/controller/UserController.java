package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("listuser")
	public String listUser(Model model) {
		// dao
		List<UserBean> users = userDao.getAllUsers();
		model.addAttribute("users", users);
		return "ListUser";//open ListUser jsp 
	}

	@GetMapping("deleteuser")
	public String deleteUser(@RequestParam("userId") Integer userId) {
		userDao.deleteByUserId(userId);
		//
		return "redirect:/listuser";//open another url 
	}
	
	@GetMapping("viewuser")
	public String viewUser(Integer userId,Model model) {
		UserBean user =  userDao.getByUserId(userId);
		model.addAttribute("user",user);
		return "ViewUser";
	}
	
	@GetMapping("search")
	public String search() {
		return "SearchUser";
	}
	
	

	@PostMapping("search")
	public String searchDb(String firstName,Model model) {
	List<UserBean>	users = userDao.searchByFirstName(firstName);
	model.addAttribute("users",users);
		return "ListUser";
	}
	
	
	
}
