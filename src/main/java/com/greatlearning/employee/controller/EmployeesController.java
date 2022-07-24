package com.greatlearning.employee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.service.EmployeeService;


//Annotations for Controller Class
@Controller
@RequestMapping("/employees")
public class EmployeesController {


	@Autowired
	private EmployeeService employeeService;



	// add mapping for "/list"

	@RequestMapping("/list")
	public String listEmployees(Model theModel) {


		// get Employees from db
		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("students", theEmployees);
		return "Employees";
	}

	@RequestMapping("/addEmployee")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "EmployeeForm";
	}


	@RequestMapping("/updateEmployee")
	public String showFormForUpdate(@RequestParam("employeeId") Integer theId,
			Model theModel) {

		// get the Employee from the service
		Employee theEmployee = employeeService.findById(theId);


		// set Employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);

		// send over to our form
		return "EmployeeForm";			
	}


	@PostMapping("/save")
	public String saveEmployee(@RequestParam("employeeid") Integer employeeid,
			@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("email") String email) {

		System.out.println(employeeid);
		Employee theEmployee;
		if(employeeid!=0)
		{
			theEmployee=employeeService.findById(employeeid);
			theEmployee.setFirstname(firstname);
			theEmployee.setEmail(email);
			theEmployee.setLastname(lastname);
		}
		else
			theEmployee=new Employee(firstname,lastname, email);
		// save the Employee
		employeeService.save(theEmployee);


		// use a redirect to prevent duplicate submissions
		return "redirect:/employeess/list";

	}



	@RequestMapping("/deleteEmployee")
	public String delete(@RequestParam("employeeId") Integer theId) {

		if(theId!=0)
		{
			Employee theEmployee=employeeService.findById(theId);
			employeeService.delete(theEmployee);
		}

		// redirect to /Employees/list
		return "redirect:/employees/list";

	}


	@RequestMapping("/search")
	public String search(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			Model theModel) {

		// check names, if both are empty then just give list of all Students
		if (firstname.trim().isEmpty() && lastname.trim().isEmpty()) {
			return "redirect:/employees/list";
		}
		else {
			// else, search by first name and lastname
			List<Employee> theEmployees =employeeService.findByFirstName_LastName(firstname, lastname);

			// add to the spring model
			theModel.addAttribute("employees", theEmployees);

			// send to list-Employees
			return "Employees";
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
