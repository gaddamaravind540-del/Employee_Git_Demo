package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;
import com.demo.exception.EmployeeNotFoundException;

public interface EmployeeServ {

	public abstract String saveEmployee(Employee employee); //persist()
	public abstract String updateEmployee(Employee employee); //merge()
	public abstract String deleteEmployee(int empId); //remove()
	public abstract Employee getEmployeeById(int empId) throws EmployeeNotFoundException;
	public abstract List<Employee> getAllEmployee(); //find()
	public abstract List<Employee> getEmployeeByDesg(String empdesg);  //createQuery("query")
	public abstract List<Employee> getEmployeeBetweenSalary(int intitalSal, int finalSal);
}
