package com.greatlearning.EmployeeManagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.entity.Employee;
import com.greatlearning.EmployeeManagement.entity.Roles;
import com.greatlearning.EmployeeManagement.entity.Users;
import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;
import com.greatlearning.EmployeeManagement.repository.RoleRepository;
import com.greatlearning.EmployeeManagement.repository.UserRepository;
import com.greatlearning.EmployeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(int theId) {
		// TODO Auto-generated method stub
		boolean ifEmployeeExist = employeeRepository.existsById(theId);
		if (ifEmployeeExist) {
			return employeeRepository.findById(theId);
		} else
			throw new RuntimeException("No employees with id : " + theId);
	}

	@Override
	public String save(Employee theEmployee) {
		System.out.println(theEmployee);
		// TODO Auto-generated method stub
		if (theEmployee.getFirstName().equals("") || theEmployee.getLastName().equals("")
				|| theEmployee.getEmail().equals("")) {
			throw new RuntimeException("No emptry fields");
		} else {
			employeeRepository.saveAndFlush(theEmployee);
			return "Employee Added Successfully!\nid : " + theEmployee.getId() + "\nFirst Name : "
					+ theEmployee.getFirstName() + "\nLast Name : " + theEmployee.getLastName() + "\nEmail : "
					+ theEmployee.getEmail();

		}

	}

	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

		boolean ifEmployeeExist = employeeRepository.existsById(employee.getId());

		if (ifEmployeeExist) {
			employeeRepository.saveAndFlush(employee);
			return "Employee Updated Successfully!\nUpdated Employee Details is :\nid : " + employee.getId()
					+ "\nFirst Name : " + employee.getFirstName() + "\nLast Name : " + employee.getLastName()
					+ "\nEmail : " + employee.getEmail();
		} else {
			return "No employee with id : " + employee.getId();
		}
	}

	@Override
	public String deleteById(int theId) {
		// TODO Auto-generated method stub
		boolean ifEmployeeExist = employeeRepository.existsById(theId);

		if (ifEmployeeExist) {
			employeeRepository.deleteById(theId);
			return "Deleted id : " + theId;
		} else
			return "No Such employee with id : " + theId;
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
		if (employees.size() > 0)
			return employees;
		else
			throw new RuntimeException("No such employee");
	}


	@Override
	public List<Employee> sortByFirstName(String sortBy) {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll(Sort.by(Direction.fromString(sortBy), "firstName"));
		if (employees.size() > 0)
			return employees;
		else
			throw new RuntimeException("No Employee");
	}

	@Override
	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Roles saveRoles(Roles role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public List<Roles> findAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public List<Users> findAllUsers() {
		return userRepository.findAll();
	}

	//@Override
	//public List<Employee> employeeById(int id) {
		// TODO Auto-generated method stub
	//	return employeeRepository.employeeById(id);
	//}

}
