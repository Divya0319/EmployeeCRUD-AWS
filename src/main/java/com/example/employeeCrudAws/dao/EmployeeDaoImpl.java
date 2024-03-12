package com.example.employeeCrudAws.dao;

import java.util.List;

import com.example.employeeCrudAws.entity.Employee;

import jakarta.persistence.EntityManager;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private EntityManager entityManager;

	@Override
	public Integer save(Employee emp) {
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return null;
	}

}
