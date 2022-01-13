package com.greatlearning.EmployeeManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.EmployeeManagement.serviceimpl.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService UserDetailsService() { 
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder PasswordEncoder() { 
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(UserDetailsService()).passwordEncoder(PasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console").permitAll().antMatchers(HttpMethod.GET, "/api/users/list")
				.hasAuthority("ADMIN").antMatchers(HttpMethod.POST, "/api/users/add").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/users/update").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/roles/list").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/roles/add").hasAnyAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/employees/list", "/api/employees/{id}").hasAnyAuthority("USER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/api/employees/add").hasAnyAuthority("USER", "ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/employees/update").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/employees/delete/*").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/employees/search/*", "/api/employees/sort/*").hasAnyAuthority("USER", "ADMIN")
				.anyRequest().authenticated().and().httpBasic().and().cors().and()
				.csrf().disable();
		http.headers().frameOptions().disable();
	}

}
