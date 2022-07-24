package com.greatlearning.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.repositories.UserRepository;
import com.greatlearning.employee.security.EmployeeUserDetails;

public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;


	//Method to load student details by Username
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user=userRepo.getUserByUserName(username);

		if(user==null)
		{
			throw new UsernameNotFoundException("User "+username+" not found!!!");
		}

		UserDetails employeeUserDetails=new EmployeeUserDetails(user);
		return employeeUserDetails;
	}

}
