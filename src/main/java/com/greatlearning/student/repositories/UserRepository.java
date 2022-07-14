package com.greatlearning.student.repositories;

//Package for JPA Repository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.student.entity.User;

// Interface extending JPA Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//Query
	@Query("from User u where u.username=?1")
	public User getUserByUserName(String username);
}