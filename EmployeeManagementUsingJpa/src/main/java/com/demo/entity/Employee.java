package com.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cts_emp_info")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@Min(value = 1,message = "Employee cannot be negative")
	private int empId;
	@NotBlank(message = "Employee cannot be null/balnk/null")
	@Column(nullable = false)
	private String empName;
	@Min(value =10000,message =  "Employee salary cannot be below 10000")
	@Max(value = 100000,message = "Employee salary cannot be above 100000")
	private int empSal;
	@NotEmpty(message = "Employee Desgination cannot be empty")
	private String empDesc;
	
	
	
	
}
