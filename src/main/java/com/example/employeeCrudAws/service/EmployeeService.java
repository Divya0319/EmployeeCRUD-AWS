package com.example.employeeCrudAws.service;

import java.util.List;

import com.example.employeeCrudAws.entity.Employee;
import com.example.employeeCrudAws.entity.EmployeeDto;

public interface EmployeeService {

	Integer save(Employee emp);
	
	List<Employee> fetchAllEmployees();
	
	Employee findEmpById(int theId);
	
	boolean deleteEmpById(int theId);
	
	Integer updateEmp(EmployeeDto emp);
}
