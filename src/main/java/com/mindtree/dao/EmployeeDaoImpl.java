package com.mindtree.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Employee;

@Repository
public class EmployeeDaoImpl {

	HibernateTemplate ht = new HibernateTemplate();
	
	public HibernateTemplate getTemplate()
	{
		return ht;
	}
	
	public void setTemplate(HibernateTemplate template)
	{
		this.ht = template;
	}
	
	// employee enters
	public void addEmployee(Employee e)
	{
		Session s = ht.getSessionFactory().openSession();
		s.save(e);
		s.beginTransaction().commit();
	}
	
	// employee by id
	public Employee getEmployeeById(int id)
	{
		return ht.get(Employee.class,id);
	}
	
	//employee leaves
	public void deleteEmployee(int id)
	{
		Employee e = getEmployeeById(id);
		Session s = ht.getSessionFactory().openSession();
		s.delete(e);
		s.beginTransaction().commit();
	}
	
	// fetch allemployees
	public List<Employee> getAllEmployees()
	{
		List<Employee> el = new ArrayList<Employee>();
		el = ht.loadAll(Employee.class);
		return el;
	}
	
	// update employee
	public void updateEmployee(Employee e)
	{
		Session s = ht.getSessionFactory().openSession();
		s.save(e);
		s.beginTransaction().commit();
	}
	
	// validate login
	public String validEmployee(String uname, String pass)
	{
		List<Employee> l = getAllEmployees();
		int i = 0;
		for(Employee e: l)
		{
			if(e.getUsername().equals(uname) && e.getPassword().equals(pass))
			{
				i = 1;
			}
		}
		if(i == 1)
		{
			return "Logged in";
		}
		else
		{
			return "Failure";
		}
	}
}
