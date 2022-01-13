package com.greatlearning.EmployeeManagement.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagement.entity.Employee;
import com.greatlearning.EmployeeManagement.entity.Roles;
import com.greatlearning.EmployeeManagement.entity.Users;
import com.greatlearning.EmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/roles/list")
	public List<Roles> findAllRoles() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
		System.out.println(currentPrincipalName);
		return employeeService.findAllRoles();
	}

	//1. add roles in the database dynamically in the db.
	
	@PostMapping("/roles/add")
	public Roles saveRole(@RequestBody Roles role) {
		return employeeService.saveRoles(role);
	}

	@GetMapping("/users/list")
	public List<Users> findAllUsers() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
		System.out.println(currentPrincipalName);
		return employeeService.findAllUsers();
	}

	//2. add Users in the db which can be used for authentication purposes.
	
	@PostMapping("/users/add")
	public Users saveUser(@RequestBody Users user) {
		return employeeService.saveUser(user);
	}

	
	//4. list all the employees stored in the database.
	
	@GetMapping("/employees/list")
	public List<Employee> findAll() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
		System.out.println(currentPrincipalName);
		return employeeService.findAll();
	}

	
	//3. add employees data in the db
	
	@PostMapping("/employees/add")
	public String addEmployee(@RequestBody Employee theEmployees) {
		return employeeService.save(theEmployees);
	}

	
	//6. update an existing employee record with the given updated json object.

	@PutMapping("/employees/update")
	public String updateEmployee(@RequestBody Employee theEmployee) {
		return employeeService.updateEmployee(theEmployee);
	}

	//7. delete an existing employee record based on the id of the employee-
	
	@DeleteMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteById(id);
	}

	//8.  fetch an employee by his/her first name and if found more than one record then list them all-

	@GetMapping("/employees/search/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable String firstName) {
		return employeeService.searchByFirstName(firstName);
	}

	//9. list all employee records sorted on their first name in either ascending order or descending order .
	
	@GetMapping("/employees/sort")
	public List<Employee> sortByFirstName(@RequestParam("order") String sortBy) {
		return employeeService.sortByFirstName(sortBy);
	}
	

	//5. fetch or get an employee record specifically based on the id of the employee
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> findById(@PathVariable int id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
		System.out.println(currentPrincipalName);
		return employeeService.findById(id);
	}
}
