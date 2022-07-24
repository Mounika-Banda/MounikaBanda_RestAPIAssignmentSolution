package com.greatlearning.employee.repositories;

//Import All the required Libraries
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employee.entity.Employee;

//Extend JPA Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByFirstnameContainsAndLastNameContainsAllIgnoreCase(String firstname, String lastname);

}
