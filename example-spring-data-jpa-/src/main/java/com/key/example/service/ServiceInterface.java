package com.key.example.service;

import java.util.List;

import com.key.example.entity.Employee;

public interface ServiceInterface {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void updateById(Employee e, int id);

	public String deleteById(int id);

	public Employee add(Employee e);

}
