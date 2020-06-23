package com.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService emp;

	// inject employee DAO
	public EmployeeRestController(EmployeeService theEmp) {
		emp = theEmp;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		System.out.println("sss");
		return emp.findAll();

	}

	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		Employee e = emp.findById(id);
		if (e == null) {
			throw new RuntimeException("the employee with id :" + id + " not found!");
		}
		return e;

	}

	@PostMapping("/employees/ins")
	public Employee save(@RequestBody Employee employee) {
		employee.setId(0);
		emp.save(employee);
		return employee;

	}

	@PutMapping("/employees/update/{id}")
	public Employee updateById(@PathVariable int id, @RequestBody Employee eu) {
		Employee e = emp.findById(id);
		if (e == null) {

			throw new RuntimeException("there  is no data for employees with id :" + id);
		}
		e.setFirstName(eu.getFirstName());
		e.setLastName(eu.getLastName());
		e.setEmail(eu.getEmail());
		emp.updateById(id);
		return e;
	}

	@DeleteMapping("/employees/delete/{id}")
	public String deleteById(@PathVariable int id) {
		Employee e = emp.findById(id);
		if (e == null) {

			throw new RuntimeException("there  is no data for employees with id :" + id);
		}
		emp.deleteById(id);
		return "the Emp with id :" + id + " deleted!";
	}

}
