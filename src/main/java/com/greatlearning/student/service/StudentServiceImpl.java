package com.greatlearning.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.student.entity.Student;
import com.greatlearning.student.repositories.StudentRepository;

//Implementing the Service Interface
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public void save(Student student) {
		studentRepo.save(student);	
	}

	@Override
	public Student findById(Integer id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public void delete(Student student) {
		studentRepo.delete(student);		
	}

	@Override
	public List<Student> findByFirstName_Course(String firstname, String course) {
		return studentRepo.findByFirstnameContainsAndCourseContainsAllIgnoreCase(firstname, course);
	}

}
