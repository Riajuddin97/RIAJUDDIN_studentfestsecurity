package com.greatlearning.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.studentmanagement.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	
	//from classname
	@Query("select u from User u where u.username =?1")
	public User getUserByUsername(String username);// class Variable
}
