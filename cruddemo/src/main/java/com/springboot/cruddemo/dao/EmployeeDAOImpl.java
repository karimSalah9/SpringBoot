package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// and setup constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override

	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		// execute query and get result set
		List<Employee> res = query.getResultList();
		// return result

		return res;
	}

	@Override

	public Employee findById(int id) {
		// get the current session
		Session session = entityManager.unwrap(Session.class);
		// create query
		Employee emp = session.get(Employee.class, id);
		return emp;
	}

	@Override

	public Employee save(Employee emp) {
		// get the current session
		Session session = entityManager.unwrap(Session.class);
		// create query
		// if id = 0 it will save if id not = 0 it will do update
		session.saveOrUpdate(emp);

		return emp;
	}

	@Override

	public void deleteById(int id) {
		// get the current session
		Session session = entityManager.unwrap(Session.class);
		Employee emp = session.get(Employee.class, id);
		// create query
//		Query query =session.createQuery("delete from Employee where id=:empId");
//		query.setParameter("empId", id);
//		query.executeUpdate();
//		
		session.remove(emp);
	}

	@Override

	public void updateById(int id) {
		// get the current session
		Session session = entityManager.unwrap(Session.class);
		Employee emp = session.get(Employee.class, id);
		// create query
		// if id = 0 it will save if id not = 0 it will do update
		session.saveOrUpdate(emp);

	}

}
