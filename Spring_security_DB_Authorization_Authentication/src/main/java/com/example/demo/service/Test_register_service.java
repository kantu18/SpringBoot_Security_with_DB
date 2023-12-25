package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Test_employee_for_registration;
import com.example.demo.repository.Employee_Repository;
import com.example.demo.repository.Test_register_repository;

@Service
public class Test_register_service {
	
	@Autowired
	private Test_register_repository register_repository;
	
	@Autowired
	private Employee_Repository employee_Repository;
	
	
	public Test_employee_for_registration savedetails(Test_employee_for_registration for_registration)
	{
		return register_repository.save(for_registration);
	}
	
	public Employee savedetailsemployee(Employee reg)
	{
		return employee_Repository.save(reg);
	}
}
