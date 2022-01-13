package com.greatlearning.EmployeeManagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.EmployeeManagement.entity.Users;
import com.greatlearning.EmployeeManagement.repository.UserRepository;
import com.greatlearning.EmployeeManagement.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = userRepository.getUserByUsername(username);
		if(user == null) {
			System.out.println("No user " + username);
			throw new UsernameNotFoundException("No Such User");
		}
		return new MyUserDetails(user);
	}
	

}
