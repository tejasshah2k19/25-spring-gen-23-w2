package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
	@Bean
	PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();//SpringBean -> 
		//class->spring bean-> life cycle -> 
		//singleton
		//@Autowired
	}
	
	
}
