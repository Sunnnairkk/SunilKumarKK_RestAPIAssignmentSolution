package com.greatlearning.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.EmployeeManagement.entity.Employee;
import com.greatlearning.EmployeeManagement.entity.Roles;
import com.greatlearning.EmployeeManagement.entity.Users;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Optional<Employee> findById(int theId);
	
	public String save(Employee theEmployee);
	
	public String updateEmployee(Employee theEmployee);
	
	public String deleteById(int theId);
	
	public List<Employee> searchByFirstName(String firstName);
	
	public List<Employee> sortByFirstName(String sortBy);
	
	public Users saveUser(Users user);
	
	public Roles saveRoles(Roles role);
	
	public List<Roles> findAllRoles();
	
	public List<Users> findAllUsers();
	
	//public List<Employee> employeeById(int id);
}

