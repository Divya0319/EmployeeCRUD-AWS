package com.example.employeeCrudAws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeeCrudAws.dao.EmployeeDao;
import com.example.employeeCrudAws.entity.Employee;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao empDao;

	@Override
	public Integer save(Employee emp) {
		return empDao.save(emp);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		return empDao.findAll();
	}

	@Override
	public Employee findEmpById(int theId) {
		return empDao.findEmpById(theId);
	}

	@Override
	public boolean deleteEmpById(int theId) {
		return empDao.deleteEmpById(theId);
	}

	@Override
	public boolean updateEmp(Employee emp) {
		return empDao.updateEmp(emp);
	}

}
