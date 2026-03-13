package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.empDesc = ?1")
	public abstract List<Employee> getEmployeeByDesg(String empdesg);
	
	@Query("select e from Employee e where e.empSal between ?1 and ?2")
	public List<Employee> getEmployeeBetweenSalary(int intitalSal, int finalSal);
}
