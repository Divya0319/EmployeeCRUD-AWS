package com.example.employeeCrudAws.dao;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.employeeCrudAws.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
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

	@Override
	public boolean updateEmp(Employee theEmp) {
		Session updateEmpSession = entityManager.unwrap(Session.class);
		Employee emp = updateEmpSession.get(Employee.class, theEmp.getId());
		
		if(emp == null) {
			return false;
		}
		
//		myCopyProperties(theEmp, emp);
		
		updateEmpSession.merge(theEmp);
		return true;
	}
	
	public static void myCopyProperties(Object src, Object target) {
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));

	}
	
	private static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl();
		PropertyDescriptor[] pds = src.getPropertyDescriptors();
		
		Set<String> emptyNames = new HashSet<>();
		for(PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			
			if(srcValue == null) emptyNames.add(pd.getName());
		}
		
		String[] result = new String[emptyNames.size()];
		
		return emptyNames.toArray(result);
		
	}
	

}
