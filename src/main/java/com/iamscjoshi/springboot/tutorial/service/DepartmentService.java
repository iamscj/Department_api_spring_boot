package com.iamscjoshi.springboot.tutorial.service;

import com.iamscjoshi.springboot.tutorial.entity.Department;
import com.iamscjoshi.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public List<Department> fetchDepartmentByName(String departmentName);

    public List<Department> fetchDepartmentByCode(String departmentName);
}
