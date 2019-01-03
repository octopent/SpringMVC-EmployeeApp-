package com.mindtree.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.entity.Employee;
import com.mindtree.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl es;
	
	@RequestMapping(value = "/index")
	public ModelAndView indexPage()
	{
		return new ModelAndView("index","message","Select the appropriate button");
	}
	
	@RequestMapping(value = "/addEmp1")
	public ModelAndView addEmp()
	{
		return new ModelAndView("addEmp");
		
	}
	
	@RequestMapping(value ="addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(Employee employee)
	{
		System.out.println("i am in");
		es.addEmployee(employee);
		return new ModelAndView("index","message","added successfully");
	}
	
	@RequestMapping(value = "/deleteEmp1")
	public ModelAndView  deleteEmployeePage()
	{
		return new ModelAndView("deleteEmp");
	}
	
	@RequestMapping(value="/deleteEmp",method=RequestMethod.POST)
	public ModelAndView deleteEmployee(Employee employee)
	{
		es.deleteEmployee(employee.getId());
		return new ModelAndView("index","message","Deleted Successfully");
	}
	
	@RequestMapping(value="/getAllEmpDetails1")
	public ModelAndView  getEmployeePage()
	{
		System.out.println("I am in......");
		//List<Employee> e = new ArrayList<Employee>();
		//e = es.getAllEmployees();
		return new ModelAndView("getAllEmpDetails","message",es.getAllEmployees());
	}
	
	@RequestMapping(value = "/getByEmpId1")
	public ModelAndView  getEmployeeByIDPage()
	{
		return new ModelAndView("getByEmpId","message","");
	}
	
	@RequestMapping(value="/getByEmpId",method=RequestMethod.POST)
	public ModelAndView getEmployeeById(Employee employee) {
		Employee e =  new Employee();
		e = es.getEmployeeById(employee.getId());
		//List<Employee> emps = new ArrayList<Employee>();
		//emps.add(e);
		return new ModelAndView("getByEmpId","message",e);
	}
	
	@RequestMapping(value = "/checkLogin1")
	public ModelAndView  checkLoginPage()
	{
		return new ModelAndView("checkLogin","message","");
	}
	
	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	public ModelAndView checkLogin(Employee employee) {
		return new ModelAndView("checkLogin","message",es.validEmployee(employee.getUsername(), employee.getPassword()));
	}
}
