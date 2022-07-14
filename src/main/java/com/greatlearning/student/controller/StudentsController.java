package com.greatlearning.student.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.student.entity.Student;
import com.greatlearning.student.service.StudentService;


//Annotations for Controller Class
@Controller
@RequestMapping("/students")
public class StudentsController {


	@Autowired
	private StudentService studentService;



	// add mapping for "/list"

	@RequestMapping("/list")
	public String listStudents(Model theModel) {


		// get Students from db
		List<Student> theStudents = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("students", theStudents);
		return "Students";
	}

	@RequestMapping("/addStudent")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);

		return "StudentForm";
	}


	@RequestMapping("/updateStudent")
	public String showFormForUpdate(@RequestParam("studentId") Integer theId,
			Model theModel) {

		// get the Student from the service
		Student theStudent = studentService.findById(theId);


		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);

		// send over to our form
		return "StudentForm";			
	}


	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentid") Integer studentid,
			@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("course") String course,@RequestParam("country") String country) {

		System.out.println(studentid);
		Student theStudent;
		if(studentid!=0)
		{
			theStudent=studentService.findById(studentid);
			theStudent.setFirstname(firstname);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
			theStudent.setLastname(lastname);
		}
		else
			theStudent=new Student(firstname,lastname, course, country);
		// save the Student
		studentService.save(theStudent);


		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}



	@RequestMapping("/deleteStudent")
	public String delete(@RequestParam("studentId") Integer theId) {

		if(theId!=0)
		{
			Student theStudent=studentService.findById(theId);
			studentService.delete(theStudent);
		}

		// redirect to /Students/list
		return "redirect:/students/list";

	}


	@RequestMapping("/search")
	public String search(@RequestParam("firstname") String firstname,
			@RequestParam("course") String course,
			Model theModel) {

		// check names, if both are empty then just give list of all Students
		if (firstname.trim().isEmpty() && course.trim().isEmpty()) {
			return "redirect:/students/list";
		}
		else {
			// else, search by first name and course
			List<Student> theStudents =studentService.findByFirstName_Course(firstname, course);

			// add to the spring model
			theModel.addAttribute("students", theStudents);

			// send to list-Students
			return "Students";
		}
	}

	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user)
	{
		ModelAndView mv=new ModelAndView();

		if(user!=null)
		{
			mv.addObject("msg", "Hi "+user.getName()+", you are not allowed to access this page");			
		}
		else
		{
			mv.addObject("msg", "Hi, you are not allowed to access this page");	
		}
		mv.setViewName("403");
		return mv;
	}

}
