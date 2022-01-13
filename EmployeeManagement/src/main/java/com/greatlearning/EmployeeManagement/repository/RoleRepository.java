package com.greatlearning.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.EmployeeManagement.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
