package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security_bean_configuration {

	@Bean
	public BCryptPasswordEncoder cryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService detailsService()
	{
		return new Custom_Userdetail_Service();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(detailsService());
		daoAuthenticationProvider.setPasswordEncoder(cryptPasswordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests().requestMatchers("/signin").permitAll().anyRequest()
                .authenticated().and().formLogin().loginPage("/signin")
                		.loginProcessingUrl("/login")
                		.permitAll();
                		//.and().logout().logoutUrl("/logout").permitAll();
              
                		//failureUrl("/error"))
                		
		
		return http.build();
	}
	
}
