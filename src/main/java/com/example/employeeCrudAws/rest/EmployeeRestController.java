package com.example.employeeCrudAws.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeCrudAws.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	private EmployeeService empService;
	
	@Autowired
	public EmployeeRestController(EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/welcome")
	public String getDefaultResponse() {
		return "Hi, you have successfully configured H2 database and Spring Booot data JPA in this project";
	}
	

}
