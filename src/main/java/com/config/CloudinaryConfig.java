package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

	@Bean
	Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dbacynesi", "api_key", "344372511177875", "api_secret",
				"TDm2KtjWoBFYA9qDQs7Lk6fm56w"));
	}
}
