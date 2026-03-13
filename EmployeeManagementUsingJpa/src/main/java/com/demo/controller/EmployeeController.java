package com.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.EmployeeServ;
import com.demo.entity.Employee;
import com.demo.exception.EmployeeNotFoundException;

@RestController //@Controller+@ResponseBody
@RequestMapping("/employee")
public class EmployeeController {

	
	public EmployeeController(EmployeeServ employeeServ) {
		super();
		this.employeeServ = employeeServ;
	}

	private EmployeeServ employeeServ;
	
	@GetMapping("/message")
	public String getMessage() {
		return "leave us we are getting sleep";
	}
	
	@PostMapping("/saveEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		return employeeServ.saveEmployee(employee);
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		return employeeServ.updateEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable @Validated int empId) {
		return employeeServ.deleteEmployee(empId);
	}
	
	@GetMapping("/getById/{empId}")
	public Employee getEmployeeById(@PathVariable("empId") int empId) throws EmployeeNotFoundException{
		return employeeServ.getEmployeeById(empId);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return employeeServ.getAllEmployee();
	}
	
	@GetMapping("/getEmployeeByDesc/{empDesc}")
	public List<Employee> getEmployeeByDesc(@PathVariable("empDesc") String empDesc){
		return employeeServ.getEmployeeByDesg(empDesc);
	}
	
	@GetMapping("/getEmployeeSal")
	public List<Employee> getEmployeeBetweenSalary(@RequestParam("sal1") int initialSal,@RequestParam("sal2") int finalSal){
		return employeeServ.getEmployeeBetweenSalary(initialSal, finalSal);
	}
}
