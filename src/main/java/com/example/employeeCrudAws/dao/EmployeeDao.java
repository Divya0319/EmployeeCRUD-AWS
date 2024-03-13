package com.example.employeeCrudAws.dao;

import java.util.List;

import com.example.employeeCrudAws.entity.Employee;

public interface EmployeeDao {
	
	Integer save(Employee emp);
	
	List<Employee> findAll();
	
	Employee findEmpById(int theId);
	
	boolean deleteEmpById(int theId);
	
	boolean updateEmp(Employee emp);
	
}
