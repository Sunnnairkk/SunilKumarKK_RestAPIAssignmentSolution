package com.greatlearning.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.EmployeeManagement.entity.Users;

public interface UserService {
	
	public List<Users> findAllUsers();
	
	public Optional<Users> findById(int theId);
	
	public void save(Users theUser);
	
	public void deleteById(int theId);
	
	public Optional<Users> findByUsername(String userName);
}
