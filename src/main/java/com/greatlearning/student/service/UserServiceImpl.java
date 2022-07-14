package com.greatlearning.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.student.entity.User;
import com.greatlearning.student.repositories.UserRepository;
import com.greatlearning.student.security.StudentUserDetails;

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

		UserDetails studentUserDetails=new StudentUserDetails(user);
		return studentUserDetails;
	}

}
