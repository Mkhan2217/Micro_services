package com.zkteco.client.departmentservice.repository;

import java.util.ArrayList;
import java.util.List;

import com.zkteco.client.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
	private List<Department> departments = new ArrayList<>();

	public Department addDept(Department dept) {
		departments.add(dept);
		return dept;
	}

	public Department findById(Long id) {
		return departments.stream().filter(department -> department.getId().equals(id)).findFirst().orElseThrow();
	}

	public List<Department> findAll() {
		return departments;
	}
}
