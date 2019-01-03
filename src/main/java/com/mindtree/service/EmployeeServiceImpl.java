package com.mindtree.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.EmployeeDaoImpl;
import com.mindtree.entity.Employee;

@Component
@Repository
public class EmployeeServiceImpl {

	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	EmployeeDaoImpl ed = context.getBean("d",EmployeeDaoImpl.class);
	
	// employee enters
		public void addEmployee(Employee e)
		{
			ed.addEmployee(e);
		}
		
		// employee by id
		public Employee getEmployeeById(int id)
		{
			return ed.getEmployeeById(id);
		}
		
		//employee leaves
		public void deleteEmployee(int id)
		{
			ed.deleteEmployee(id);
		}
		
		// fetch allemployees
		public List<Employee> getAllEmployees()
		{
			return ed.getAllEmployees();
		}
		
		// update employee
		public void updateEmployee(Employee e)
		{
			ed.updateEmployee(e);
		}
		
		// validate login
		public String validEmployee(String uname, String pass)
		{
			return ed.validEmployee(uname, pass);
		}
}
