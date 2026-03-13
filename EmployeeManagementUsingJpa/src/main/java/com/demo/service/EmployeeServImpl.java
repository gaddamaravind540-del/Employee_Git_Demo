package com.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.exception.EmployeeNotFoundException;
import com.demo.repo.EmployeeRepo;

@Service
public class EmployeeServImpl implements EmployeeServ {

	
	public EmployeeServImpl(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	private EmployeeRepo employeeRepo;
	
	
	@Override
	public String saveEmployee(Employee employee) {
		
		employeeRepo.save(employee);
		return "Employee Added Succesfully";
	}

	@Override
	public String updateEmployee(Employee employee) {
		
		employeeRepo.save(employee);
		return "Employee Updated Successfully";
	}

	@Override
	public String deleteEmployee(int empId) {
		
		employeeRepo.deleteById(empId);
		return null;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeNotFoundException{
		
		Optional<Employee> optional = employeeRepo.findById(empId);
		if(optional.isEmpty()) {
			throw new EmployeeNotFoundException("No employee not found by the given emp id");
		}
		return optional.get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		
		return employeeRepo.findAll();
	}

	@Override
	public List<Employee> getEmployeeByDesg(String empdesg) {
		
		return employeeRepo.getEmployeeByDesg(empdesg);
	}

	@Override
	public List<Employee> getEmployeeBetweenSalary(int intitalSal, int finalSal) {
		
		return employeeRepo.getEmployeeBetweenSalary(intitalSal, finalSal);
	}

}
