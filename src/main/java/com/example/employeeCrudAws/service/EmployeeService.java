package com.example.employeeCrudAws.service;

import java.util.List;

import com.example.employeeCrudAws.entity.Employee;

public interface EmployeeService {

	Integer save(Employee emp);
	
	List<Employee> fetchAllEmployees();
	
	Employee findEmpById(int theId);
	
	boolean deleteEmpById(int theId);
	
	boolean updateEmp(Employee emp);
}
