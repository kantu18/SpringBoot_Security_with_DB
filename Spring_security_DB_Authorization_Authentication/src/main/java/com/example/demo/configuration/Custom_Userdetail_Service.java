package com.example.demo.configuration;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repository.Employee_Repository;

@Component
public class Custom_Userdetail_Service implements UserDetailsService{

	@Autowired
	private Employee_Repository employee_Repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Employee emp= employee_Repository.findByemail(email);
		
		if(emp==null)
		{
			return (UserDetails) new UsernameNotFoundException(email);
		}
		else
		{
			return new Custom_Config_user(emp);
		}
	}
}
