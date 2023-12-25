package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Test_employee_for_registration;

@Repository
public interface Test_register_repository extends JpaRepository<Test_employee_for_registration, Integer>{

}
