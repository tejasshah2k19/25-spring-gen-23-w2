package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.ProductBean;

@Controller
public class ProductController {

	@GetMapping("newproduct")
	public String newProduct() {
		return "NewProduct";
	}

	@PostMapping("saveproduct")
	public String saveProduct(@Validated ProductBean productBean,BindingResult result,Model model) {
		System.out.println(productBean.getProductName());
		System.out.println(productBean.getPrice());
		if(result.hasErrors()) {
			model.addAttribute("result",result);
			return "NewProduct";
		}
		return "PrintProduct";
	}
}
