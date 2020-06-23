package com.springboot.cruddemo.dao;

import java.util.List;

import com.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();

	public Employee findById(int id);

	public Employee save(Employee emp);

	public void deleteById(int id);

	public void updateById(int id);

}
