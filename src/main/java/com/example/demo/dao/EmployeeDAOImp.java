package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Employee employee) {
		String query = "insert into employees (name,email,department) values(?,?,?)";
		return jdbcTemplate.update(query, new Object[] {employee.getName(),employee.getEmail(),employee.getDepartment()});
	};
	
	@Override
	public int update(Employee employee,int id) {
		String query = "UPDATE employees SET name = ?, email = ?,department = ? WHERE id = ?";
		return jdbcTemplate.update(query, employee.getName(), employee.getEmail(),
				employee.getDepartment(), id);
	};
	
	@Override
	public int delete(int id) {
		String query = "DELETE from employees WHERE id = ?";
		return jdbcTemplate.update(query,id);
	}
	
	@Override
	public List<Employee> getAll() {
		return jdbcTemplate.query("select * from employees", new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	@Override
	public Employee getById(int id) {
		String query = "select * from employees where id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Employee>(Employee.class),id);
	}
	
}	
