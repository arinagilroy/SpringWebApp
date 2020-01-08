package com.perfeto.controller;

import com.perfeto.dao.EmployeeDAO;
import com.perfeto.exceptions.CantRequestBodyException;
import com.perfeto.exceptions.NotFoundException;
import com.perfeto.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("employee")
public class MainController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping
    public String getAllEmployee(Model model) {

        List<Employee> employees = employeeDAO.getEmployees();
        model.addAttribute("employees", employees);
        return "employee";
    }

    @GetMapping("{empId}")
    public String getAllEmployeeById(Model model, @PathVariable Long empId) {
        List<Employee> employees = employeeDAO.getEmployees();
        model.addAttribute("employees", getEmployeeById(empId, employees));
        return "employee";
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        if (employee.getEmpNo() == null || employee.getEmpName() == null){
            throw new CantRequestBodyException();
        } else {
            employeeDAO.addEmployee(employee.getEmpNo(), employee.getEmpName());
            List<Employee> employees = employeeDAO.getEmployees();
            System.out.println(employee);
        }
    }

    @DeleteMapping("{empId}")
    public void deleteEmployee(@PathVariable Long empId) {
//TODO
    }

    private Employee getEmployeeById(Long empId, List<Employee> employees) {
        return employees.stream().filter(employee -> employee.getEmpId().equals(empId)).findFirst().orElseThrow(NotFoundException::new);
    }
}
