package com.greatlearning.employee.service;

import java.util.List;

import com.greatlearning.employee.entity.Employee;

//Service Interface to implement the following functions in a service imp class

public interface EmployeeService {	
	public List<Employee> findAll();
	public void save(Employee b);
	public Employee findById(Integer id);
	public void delete(Employee b);
	public List<Employee> findByFirstName_LastName(String firstname, String lastname);
}
