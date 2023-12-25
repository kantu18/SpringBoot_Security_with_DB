package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Test_employee_for_registration;
import com.example.demo.repository.Test_register_repository;
import com.example.demo.service.Test_register_service;


@Controller
//@RequestMapping("/api")
public class Employee_controller {

	@Autowired
	private Test_register_service service;
	
	@GetMapping("/home")
	public String gethomepage(){
		return "home";
	}
	
	@GetMapping("/register")
	public String getregisterpage(){
		return "register";
	}
	
	@GetMapping("/signin")
	public String getloginpage(){
		return "login";
	}
	@GetMapping("/about")
	public String getaboutpage(){
		return "about";
	}
	
	@GetMapping("/error")
	public String geterrorpage(){
		return "error";
	}
	
	@GetMapping("/logout")
	public String getlogoutpage(){
		return "logout";
	}
	
	@PostMapping("/register")
	public String saveandregisteruser(@ModelAttribute Test_employee_for_registration registration){
		
		Test_employee_for_registration test_employee_for_registration= service.savedetails(registration);
		
		if(test_employee_for_registration !=null)
		{
			System.out.print("Success");
		}
		else
		{
			System.out.print("Error occured");
		}
		return "register";
	}
	
	@PostMapping("/register_emp")
	public String saveandregisteremployee(@ModelAttribute Employee registration){
		
		Employee emp= service.savedetailsemployee(registration);
		
		if(emp !=null)
		{
			System.out.print("Success");
		}
		else
		{
			System.out.print("Error occured");
		}
		return "register_emp";
	}
}
