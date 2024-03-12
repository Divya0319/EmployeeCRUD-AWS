package com.example.employeeCrudAws.dao;

import java.util.List;

import com.example.employeeCrudAws.entity.Employee;
import com.example.employeeCrudAws.entity.EmployeeDto;

public interface EmployeeDao {
	
	Integer save(Employee emp);
	
	List<Employee> findAll();
	
	Employee findEmpById(int theId);
	
	boolean deleteEmpById(int theId);
	
}
