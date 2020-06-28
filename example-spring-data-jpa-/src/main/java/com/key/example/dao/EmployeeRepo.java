package com.key.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.key.example.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
