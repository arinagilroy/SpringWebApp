package com.perfeto.dao;

import com.perfeto.exceptions.NotFoundException;
import com.perfeto.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
 
@Repository
public class EmployeeDAOArray {

    public EmployeeDAOArray() {
        list.add(new Employee("E01", "Tom"));
        list.add(new Employee("E02", "Jerry"));
    }

    public List<Employee> list = new ArrayList<>();

    public List<Employee> getEmployees() {
        return list;        
    }

    public void addEmployee(String empNo, String empName) {
        list.add(new Employee(empNo, empName));
    }

    public void updateEmployee(Long empId, Employee employee) {
        Employee forUpdateEmployee = getEmployeeById(empId, list);
        forUpdateEmployee.setEmpName(employee.getEmpName());
        forUpdateEmployee.setEmpNo(employee.getEmpNo());
    }

    public Employee getEmployeeById(Long empId, List<Employee> employees) {
        return employees.stream().filter(employee -> employee.getEmpId().equals(empId)).findFirst().orElseThrow(NotFoundException::new);
    }
}