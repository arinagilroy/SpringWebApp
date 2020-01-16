package com.perfeto.controller;

import com.perfeto.dao.EmployeeRepository;
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
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping
    public String getAllEmployee(Model model) {

        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employee";
    }

    @GetMapping("{empId}")
    public String getAllEmployeeById(Model model, @PathVariable Long empId) {
        model.addAttribute("employees", employeeRepository.findByEmpId(empId));
        return "employee";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Employee> index(@RequestParam Long empId) {
        return employeeRepository.findByEmpId(empId);
    }

    @PostMapping
    @ResponseBody
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        if (employee.getEmpNo() == null || employee.getEmpName() == null){
            throw new CantRequestBodyException();
        } else {
            employeeRepository.save(employee);
            return (List<Employee>) employeeRepository.findAll();
        }
    }

    @DeleteMapping("{empId}")
    @ResponseBody
    public List<Employee> deleteEmployee(@PathVariable Long empId) throws NotFoundException {
        List<Employee> employees =  employeeRepository.findByEmpId(empId);
        if (!employees.isEmpty()){
            employeeRepository.deleteById(empId);
        } else {
            throw new NotFoundException();
        }
        return (List<Employee>) employeeRepository.findAll();
    }

    @PutMapping
    @ResponseBody
    public List<Employee> putEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return (List<Employee>) employeeRepository.findAll();
    }
}
