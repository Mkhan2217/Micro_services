package com.zkteco.employeeService.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zkteco.employeeService.model.Employee;

@Repository
public class EmployeeRepository {
	private List<Employee> employees = new ArrayList<>();

	public Employee add(Employee employee) {
		employees.add(employee);
		return employee;
	}

	public Employee findById(Long id) {
		return employees.stream().filter(emp -> emp.id().equals(id)).findFirst().orElseThrow();
	}

	public List<Employee> findAll() {
		return employees;
	}
	public List<Employee>  findByDeptId(Long departmentId) {
		return employees.stream().filter(emp -> emp.departmentId().equals(departmentId)).toList();
	}
	

}
