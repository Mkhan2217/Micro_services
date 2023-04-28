package com.zkteco.client.departmentservice.controller;

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

import com.zkteco.client.departmentservice.client.EmployeeClient;
import com.zkteco.client.departmentservice.model.Department;
import com.zkteco.client.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeClient employeeClient;

	@PostMapping("/add")
	public Department add(@RequestBody Department department) {
		LOGGER.info("Add () of Department ", department);
		return departmentRepository.addDept(department);
	}

	@GetMapping("/list")
	public List<Department> findAll() {
		LOGGER.info("findAll () of Department ");
		return departmentRepository.findAll();
	}

	@GetMapping("/{id}")
	public Department findByid(@PathVariable Long id) {
		LOGGER.info("findByid () of Department ");
		return departmentRepository.findById(id);
	}

	@GetMapping("/with-employees")
	public List<Department> findAllWithEmployees() {
		LOGGER.info("findAllWithEmployees () of Department ");
		List<Department> departments = departmentRepository.findAll();
		departments.forEach(department -> department.setEmp(employeeClient.findByDepartment(department.getId())));

		return departments;
	}

}
