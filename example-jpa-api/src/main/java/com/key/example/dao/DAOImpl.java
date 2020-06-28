package com.key.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.key.example.entity.Employee;

@Repository
public class DAOImpl implements DAOInterface {

	private EntityManager entityManager;

	@Autowired
	public DAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create query JPQL
		Query query = entityManager.createQuery("from Employee");
		// execute query and get result set
		List<Employee> res = query.getResultList();
		// return result
		return res;
	}

	@Override
	public Employee findById(int id) {
		// get the current hibernate session
		Employee emp = entityManager.find(Employee.class, id);

		return emp;
	}

	@Override
	public void updateById(Employee e, int id) {
		// get the current session

		Employee emp = entityManager.find(Employee.class, id);

		e.setId(emp.getId());
		// create query
		// if id = 0 it will save if id not = 0 it will do update

		entityManager.merge(e);
	}

	@Override
	public String deleteById(int id) {

		Employee emp = entityManager.find(Employee.class, id);
		if (emp == null) {
			return "there is no Employee with id : ";
		}

		// entityManager.remove(emp);

		Query query = entityManager.createQuery("delete from Employee where id =:id");
		query.setParameter("id", id);
		query.executeUpdate();
		return "The Employee with id : " + id + "  deleted!";
	}

	@Override
	public Employee add(Employee e) {
		entityManager.persist(e);
		return e;
	}

}
