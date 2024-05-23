package com.example.employeeCrudAws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.employeeCrudAws.entity.Employee;
import com.example.employeeCrudAws.repository.EmployeeRepository;

import jakarta.annotation.PostConstruct;

@Component
public class SampleDataInitializer {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public SampleDataInitializer(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void init() {
        insertSampleData();
    }

    private void insertSampleData() {
        employeeRepository.save(new Employee("Babu", "Rao", 45, 35000, "Science"));
        employeeRepository.save(new Employee("Hema", "Rao", 41, 34000, "Social"));
        employeeRepository.save(new Employee("Anna", "Singh", 35, 25000, "English"));
        employeeRepository.save(new Employee("Jolly", "Singh", 47, 55000, "Maths"));
        employeeRepository.save(new Employee("Baandiya", "Yadav", 40, 40000, "Hindi"));
        employeeRepository.save(new Employee("Kalpit", "Jadhav", 30, 48000, "Psychology"));
        employeeRepository.save(new Employee("Aritha", "Sonkar", 33, 49000, "Biology"));
    }
}