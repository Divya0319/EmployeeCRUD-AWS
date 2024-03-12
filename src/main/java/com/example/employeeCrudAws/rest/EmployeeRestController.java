package com.example.employeeCrudAws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeCrudAws.entity.Employee;
import com.example.employeeCrudAws.service.EmployeeService;
import com.hbpractice.ManyToManyMapping.entity.Coder;
import com.hbpractice.ManyToManyMapping.entity.ResponseObject;

import jakarta.servlet.http.HttpServletResponse;

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
	
	@GetMapping("/employees")
	public List<Employee> fetchAllEmployees(HttpServletResponse response) {
		
	}
	
	@GetMapping("/employees/{empId}")
	public Employee fetchEmpById(@PathVariable int empId, HttpServletResponse response) {
		
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		
	}
	
	@PutMapping("/employees/{empId}")
	public Integer updateCoder(@RequestBody Employee emp, HttpServletResponse response) {
		
	}
	
	@DeleteMapping("/employees/{empId}")
	public boolean deleteEmpById(@PathVariable int empId, HttpServletResponse response) {
		
	}

}
