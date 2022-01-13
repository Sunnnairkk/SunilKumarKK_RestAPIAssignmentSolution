package com.greatlearning.EmployeeManagement.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.EmployeeManagement.entity.Roles;
import com.greatlearning.EmployeeManagement.entity.Users;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails {

	private Users user;
	
	public MyUserDetails(Users user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<Roles> roles = user.getRoles();
		List<SimpleGrantedAuthority> authority = new ArrayList<>();
		for(Roles role : roles) {
			authority.add(new SimpleGrantedAuthority(role.getName()));
		}
		System.out.println(authority);
		return authority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
