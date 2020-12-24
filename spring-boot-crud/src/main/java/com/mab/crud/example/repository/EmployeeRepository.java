package com.mab.crud.example.repository;

import com.mab.crud.example.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	Employee findByName(String name);
}

