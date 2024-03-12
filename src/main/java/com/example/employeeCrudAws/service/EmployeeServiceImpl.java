package com.example.employeeCrudAws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.employeeCrudAws.dao.EmployeeDao;
import com.example.employeeCrudAws.entity.Employee;
import com.example.employeeCrudAws.entity.EmployeeDto;
import com.example.employeeCrudAws.entity.EmployeeMapper;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao empDao;
	
	@Autowired
	private EmployeeMapper empMapper;

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
	public Integer updateEmp(EmployeeDto dto) {
		Employee myEmp = empDao.findEmpById(dto.getId());
		if(myEmp == null) {
			return -1;
		}
		
		empMapper.updateEmpFromDto(dto, myEmp);
		return empDao.save(myEmp);
	}

}
