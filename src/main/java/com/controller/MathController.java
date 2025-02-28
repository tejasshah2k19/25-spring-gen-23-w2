package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.MathBean;

@Controller
public class MathController {

	// input

	// read

	// addition
	@GetMapping("input")
	public String input() {
		return "InputData";
	}

	@PostMapping("operation")
	public String operation(MathBean math,Model model) {
		// read
		// addition
		System.out.println(math.getN1() + math.getN2());
		Integer ans  = math.getN1() + math.getN2();//send to jsp
		model.addAttribute("ans",ans);
		return "InputData";//open 
	}
}
