package com.key.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.example.dao.EmployeeRepo;
import com.key.example.entity.Employee;

@Service
public class ServiceImpl implements ServiceInterface {

	EmployeeRepo repo;

	@Autowired
	public ServiceImpl(EmployeeRepo employeeRepo) {
		repo = employeeRepo;
	}

	@Override
	public List<Employee> findAll() {
		return repo.findAll();
	}

	@Override
	public Employee findById(int id) {
		Employee emp = null;
		Optional<Employee> result = repo.findById(id);
		if (result.isPresent()) {

			emp = result.get();
			return emp;
		}

		return emp;
	}

	@Override
	public void updateById(Employee e, int id) {
		Employee emp = null;
		Optional<Employee> result = repo.findById(id);
		System.out.println(result.toString());
		System.out.println(result.isPresent());

		if (result.isPresent()) {

			emp = result.get();
			e.setId(emp.getId());

			repo.save(e);
		} else {

			throw new RuntimeException("a7a");
		}
	}

	@Override
	public String deleteById(int id) {
		Employee emp = null;
		Optional<Employee> result = repo.findById(id);
		if (result.isPresent()) {
			repo.deleteById(id);
		}

		throw new RuntimeException("");
	}

	@Override
	public Employee add(Employee e) {
		// TODO Auto-generated method stub
		return repo.save(e);
	}

}
