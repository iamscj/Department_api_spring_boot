package com.iamscjoshi.springboot.tutorial.controller;

import com.iamscjoshi.springboot.tutorial.entity.Department;
import com.iamscjoshi.springboot.tutorial.error.DepartmentNotFoundException;
import com.iamscjoshi.springboot.tutorial.service.DepartmentService;
import com.iamscjoshi.springboot.tutorial.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public String saveDepartment(@Valid @RequestBody Department department)
    {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        departmentService.saveDepartment(department);
        return "Department inserted successfully";
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
    {
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department)
    {
        return departmentService.updateDepartment(departmentId, department);
    }
    @GetMapping("/departments/name/{name}")
    public List<Department> fetchDepartmentById(@PathVariable("name") String departmentName)
    {
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @GetMapping("/departments/code/{code}")
    public List<Department> fetchDepartmentByCode(@PathVariable("code") String departmentCode)
    {
        System.out.println(departmentCode);
        return departmentService.fetchDepartmentByCode(departmentCode);
    }
}
