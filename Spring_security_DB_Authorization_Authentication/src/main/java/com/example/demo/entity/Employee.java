package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name="USER_NAME")
	private String user_name;
	
	@Column(name="DEPARTMENT")
	private String dept;
	
	@Column(name="ROLE")
	private String role;
	
	@Column(name="PASSWORD")
	private String passwrod;
	
	@Column(name="EMAIL")
	private String email;

	public Employee() {
		super();
	}

	public Employee(int user_id, String user_name, String dept, String role, String passwrod, String email) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.dept = dept;
		this.role = role;
		this.passwrod = passwrod;
		this.email = email;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [user_id=" + user_id + ", user_name=" + user_name + ", dept=" + dept + ", role=" + role
				+ ", passwrod=" + passwrod + ", email=" + email + "]";
	}
	
}
