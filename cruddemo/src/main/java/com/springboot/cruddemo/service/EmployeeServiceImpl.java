package com.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO empDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO emp) {
		empDAO = emp;

	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return empDAO.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return empDAO.save(emp);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		empDAO.deleteById(id);
	}

	@Override
	@Transactional
	public void updateById(int id) {
		empDAO.updateById(id);
	}

}
