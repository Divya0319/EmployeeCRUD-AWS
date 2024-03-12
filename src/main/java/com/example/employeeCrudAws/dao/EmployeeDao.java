package com.example.employeeCrudAws.dao;

import java.util.List;

import com.example.employeeCrudAws.entity.Employee;

public interface EmployeeDao {
	
	public Integer save(Employee emp);
	
	public List<Employee> findAll();
	
	public Employee findEmpById(int theId);
	
	public boolean deleteEmpById(int theId);

}
