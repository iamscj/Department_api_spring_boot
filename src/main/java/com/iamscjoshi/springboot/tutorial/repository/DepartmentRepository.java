package com.iamscjoshi.springboot.tutorial.repository;

import com.iamscjoshi.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public  List<Department> findBydepartmentName(String departmentName);

    @Query(value = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_CODE = ?1", nativeQuery = true)
    public List<Department> findBydepartmentCode1(String departmentCode);
}
