package com.zkteco.client.departmentservice.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.zkteco.client.departmentservice.model.Employee;

@HttpExchange
public interface EmployeeClient {
	@GetExchange("/employee/department/{deptId}")
	public List<Employee> findByDepartment(@PathVariable("deptId") Long departmentId);

}
