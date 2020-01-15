package com.perfeto.dao;

import com.perfeto.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByEmpId(Long empId);
}
