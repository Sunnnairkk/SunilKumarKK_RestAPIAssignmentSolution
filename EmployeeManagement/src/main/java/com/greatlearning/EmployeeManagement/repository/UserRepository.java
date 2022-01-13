package com.greatlearning.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.EmployeeManagement.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	
	@Query("Select u from Users u where u.username = ?1")
	public Users getUserByUsername(String username);

}
