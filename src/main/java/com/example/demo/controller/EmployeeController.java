package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO eDAO;
	
	@PostMapping("/company/v1/employees/register")
	public String addEmployees(@RequestBody Employee employee){
		return eDAO.save(employee)+"Employee added successfully";
	}
	
	@PutMapping("/company/v1/employees/update/{id}")
	public String updateEmployees(@RequestBody Employee employee,@PathVariable Integer id){
		return eDAO.update(employee, id)+"Employee updated successfully";
	}
	
	@DeleteMapping("/company/v1/employees/remove/{id}")
	public String deleteEmployees(@PathVariable Integer id){
		return eDAO.delete(id)+"Employee Removed successfully";
	}
	
	
	
	
	@GetMapping("/company/v1/employees")
	public List<Employee> getEmployees(){
		
		return eDAO.getAll();
	}
	
	
	@GetMapping("/company/v1/employees/{id}")
	public Employee getEmployeesById(@PathVariable Integer id){
		return eDAO.getById(id);
	}
	
	
	

}
