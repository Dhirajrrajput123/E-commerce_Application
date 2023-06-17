package com.dhiraj.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfiguration {

	@Bean
	public SecurityFilterChain appAuthority(HttpSecurity http) throws Exception {
		
		  http
	        .authorizeRequests(auth->auth
	            .requestMatchers("/E-App/WelcomeForAll", "/E-App/Users").permitAll() // Allow access to public resources
	            .requestMatchers("/E-App/WelcomeForAdmin").hasRole("ADMIN") // Allow access to "/admin/**" only for users with the "ADMIN" role
	            .anyRequest().authenticated() // Require authentication for all other requests
                  ).httpBasic();

	    return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
