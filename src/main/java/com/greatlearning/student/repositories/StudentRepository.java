package com.greatlearning.student.repositories;

//Import All the required Libraries
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.student.entity.Student;

//Extend JPA Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findByFirstnameContainsAndCourseContainsAllIgnoreCase(String firstname, String course);

}
