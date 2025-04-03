package com.senai.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// esse codigo permite o cadastro do usuario sem necessitar do token de segurança que o codigo acima oferece
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.csrf(csrf -> csrf.disable());
			http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
			return http.build();
		}
}
