package com.greatlearning.EmployeeManagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.EmployeeManagement.entity.Users;
import com.greatlearning.EmployeeManagement.repository.UserRepository;
import com.greatlearning.EmployeeManagement.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public List<Users> findAllUsers() { //findAll
		// TODO Auto-generated method stub
		List<Users> users = userRepository.findAll();
		return users;
	}

	@Override
	@Transactional
	public Optional<Users> findById(int theId) {
		// TODO Auto-generated method stub
		return userRepository.findById(theId);
	}

	@Override
	@Transactional
	public void save(Users theUser) {
		// TODO Auto-generated method stub
		userRepository.save(theUser);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(theId);
	}

	@Override
	@Transactional
	public Optional<Users> findByUsername(String userName) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.getUserByUsername(userName));
	}

}
