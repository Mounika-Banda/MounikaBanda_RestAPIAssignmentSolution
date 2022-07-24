package com.greatlearning.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.repositories.EmployeeRepository;

//Implementing the Service Interface
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepo.save(employee);	
	}

	@Override
	public Employee findById(Integer id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public void delete(Employee employee) {
		employeeRepo.delete(employee);		
	}

	@Override
	public List<Employee> findByFirstName_LastName(String firstname, String lastname) {
		return employeeRepo.findByFirstnameContainsAndLastNameContainsAllIgnoreCase(firstname, lastname);
	}

}
