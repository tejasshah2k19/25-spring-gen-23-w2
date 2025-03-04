package com.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductBean {

	@NotBlank(message = "Please Enter Product Name")
	String productName;
	
	@NotNull(message = "Please Enter Price")
	Integer price;
	Integer qty;
	Float tax;

//getters and setters -> 
//all variable -> private 
//lombok

//1:sts lombok
//2:project dep/lib ->lombok 

}
