package com.key.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.key.example.entity.Employee;
import com.key.example.service.ServiceInterface;

@RestController
@RequestMapping("/api")
public class MyController {
	private ServiceInterface service;

	@Autowired
	public MyController(ServiceInterface serviceInterface) {
		service = serviceInterface;
	}

	@GetMapping("/welcome")
	public String test() {

		return "Welcome to my controller!";
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		List<Employee> employees = service.findAll();
		return employees;
	}

	@GetMapping("/employee/{id}")
	public Employee findById(@PathVariable int id) {
		Employee employee = service.findById(id);
		return employee;
	}

	@PostMapping("/employee")
	public Employee add(@RequestBody Employee e) {

		service.add(e);
		return e;
	}

	@PutMapping("/employees/update/{id}")
	public Employee updateById(@PathVariable int id, @RequestBody Employee eu) {
		service.updateById(eu, id);
		return eu;
	}

	@DeleteMapping("/employee/{id}")
	public String deleteById(@PathVariable int id) {

		return service.deleteById(id);

	}
}
