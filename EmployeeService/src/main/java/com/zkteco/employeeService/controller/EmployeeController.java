package com.zkteco.employeeService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.employeeService.model.Employee;
import com.zkteco.employeeService.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeRepository employeeRepository;
	 

	@PostMapping("/add")
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Add () of employee ", employee);
		return employeeRepository.add(employee);
	}

	@GetMapping("/{id}")
	public Employee getById(@PathVariable("id") Long id) {
		LOGGER.info("getById () of employee ");
		return employeeRepository.findById(id);
	}

	@GetMapping("/list")
	public List<Employee> listOfEmp() {
		LOGGER.info("listOfEmp () of employee ");
		return employeeRepository.findAll();
	}

	@GetMapping("/department/{deptId}")
	public List<Employee> findByDeptId(@PathVariable("deptId") Long departmentId) {
		LOGGER.info("findByDeptId () of employee ");
		return employeeRepository.findByDeptId(departmentId);
	}

}
