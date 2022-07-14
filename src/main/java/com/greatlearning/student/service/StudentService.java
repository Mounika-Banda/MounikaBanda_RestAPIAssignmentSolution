package com.greatlearning.student.service;

import java.util.List;

import com.greatlearning.student.entity.Student;

//Service Interface to implement the following functions in a service imp class

public interface StudentService {	
	public List<Student> findAll();
	public void save(Student b);
	public Student findById(Integer id);
	public void delete(Student b);
	public List<Student> findByFirstName_Course(String firstname, String course);
}
