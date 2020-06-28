package com.key.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.key.example.dao.DAOInterface;
import com.key.example.entity.Employee;

@Service
public class ServiceImpl implements ServiceInterface {

	DAOInterface dao;

	@Autowired
	public ServiceImpl(DAOInterface daoInterface) {
		dao = daoInterface;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional
	public void updateById(Employee e,int id) {
		// TODO Auto-generated method stub
		dao.updateById(e,id);
	}

	@Override
	@Transactional
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteById(id);
	}

	@Override
	@Transactional
	public Employee add(Employee e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}

}
