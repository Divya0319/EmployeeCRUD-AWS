package com.example.employeeCrudAws.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeCrudAws.entity.Employee;
import com.example.employeeCrudAws.service.EmployeeService;

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
		
		List<Employee> employees = empService.fetchAllEmployees();
		
		if(employees.size() == 0) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			List<Employee> blank = new ArrayList<>();
			return blank;
		}
		
		response.setStatus(HttpStatus.OK.value());
		return employees;
		
	}
	
	@GetMapping("/employees/{empId}")
	public Employee fetchEmpById(@PathVariable int empId, HttpServletResponse response) {
		Employee emp = empService.findEmpById(empId);
		
		if(emp == null) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return null;
		}
		
		response.setStatus(HttpStatus.OK.value());
		return emp;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		emp.setId(0);
		empService.save(emp);
		
		return emp;
	}
	
	@PutMapping("/employees")
	public boolean updateCoder(@RequestBody Employee emp, HttpServletResponse response) {
		
		boolean coderFound = empService.updateEmp(emp);
		
		if(!coderFound) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return true;
		}
		
		response.setStatus(HttpStatus.OK.value());
		
		return coderFound;
		
	}
	
	@DeleteMapping("/employees/{empId}")
	public boolean deleteEmpById(@PathVariable int empId, HttpServletResponse response) {
		
		boolean deleted = empService.deleteEmpById(empId);
		
		if(!deleted) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return false;
		}
		
		response.setStatus(HttpStatus.OK.value());
		
		return deleted;
	}

}
