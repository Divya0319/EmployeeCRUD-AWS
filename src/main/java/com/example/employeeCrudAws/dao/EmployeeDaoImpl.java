package com.example.employeeCrudAws.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.employeeCrudAws.entity.Employee;
import com.example.employeeCrudAws.entity.EmployeeDto;

import jakarta.persistence.EntityManager;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Integer save(Employee emp) {
		
		Session addEmployeeSession = entityManager.unwrap(Session.class);
		return addEmployeeSession.merge(emp).getId();
	}

	@Override
	public List<Employee> findAll() {
		Session getAllEmployeeSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = getAllEmployeeSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findEmpById(int theId) {
		Session findEmpByIdSession = entityManager.unwrap(Session.class);
		
		Employee emp = findEmpByIdSession.get(Employee.class, theId);

		return emp;
	}

	@Override
	public boolean deleteEmpById(int theId) {
		Session deleteEmpByIdSession = entityManager.unwrap(Session.class);
		Employee emp = deleteEmpByIdSession.get(Employee.class, theId);
		
		if(emp == null) {
			return false;
		}
		
		deleteEmpByIdSession.remove(emp);
		return true;
	}

}
