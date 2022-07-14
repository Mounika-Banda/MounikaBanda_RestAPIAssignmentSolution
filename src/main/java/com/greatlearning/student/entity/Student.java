package com.greatlearning.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Annotations for entity class
@Entity
@Table(name="students")
public class Student {

	@Column(name="student_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentid;

	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String lastname;

	@Column(name="course")
	private String course;

	@Column(name="country")
	private String country;

	public Student() {
		super();
	}

	//Parameterized constructor
	public Student(String firstname, String lastname, String course, String country) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.course = course;
		this.country = country;
	}

	//Getter & Setter Methods
	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}
